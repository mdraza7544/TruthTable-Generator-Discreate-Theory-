package com.truthtable.parser;

import com.truthtable.exception.ParsingException;
import java.util.*;

public class Tokenizer {
    
    public List<Token> tokenize(String expression) throws ParsingException {
        List<Token> tokens = new ArrayList<>();
        expression = expression.replaceAll("\\s+", "");
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (Character.isLetter(ch)) {
                tokens.add(new Token(TokenType.VARIABLE, String.valueOf(ch)));
            } else if (ch == '(') {
                tokens.add(new Token(TokenType.LEFT_PAREN, "("));
            } else if (ch == ')') {
                tokens.add(new Token(TokenType.RIGHT_PAREN, ")"));
            } else if (ch == '&' || ch == '∧') {
                if (i + 1 < expression.length() && expression.charAt(i + 1) == '&') {
                    i++;
                }
                tokens.add(new Token(TokenType.AND, "AND"));
            } else if (ch == '|' || ch == '∨') {
                if (i + 1 < expression.length() && expression.charAt(i + 1) == '|') {
                    i++;
                }
                tokens.add(new Token(TokenType.OR, "OR"));
            } else if (ch == '!' || ch == '¬' || ch == '~') {
                tokens.add(new Token(TokenType.NOT, "NOT"));
            } else if (ch == '-') {
                if (i + 1 < expression.length() && expression.charAt(i + 1) == '>') {
                    i++;
                    tokens.add(new Token(TokenType.IMPLIES, "IMPLIES"));
                } else {
                    throw new ParsingException("Invalid character: " + ch);
                }
            } else if (ch == '→') {
                tokens.add(new Token(TokenType.IMPLIES, "IMPLIES"));
            } else if (ch == '<') {
                if (i + 2 < expression.length() && 
                    expression.charAt(i + 1) == '-' && 
                    expression.charAt(i + 2) == '>') {
                    i += 2;
                    tokens.add(new Token(TokenType.BICONDITIONAL, "BICONDITIONAL"));
                } else {
                    throw new ParsingException("Invalid character: " + ch);
                }
            } else if (ch == '↔') {
                tokens.add(new Token(TokenType.BICONDITIONAL, "BICONDITIONAL"));
            } else {
                throw new ParsingException("Invalid character: " + ch);
            }
        }
        
        return tokens;
    }
}

