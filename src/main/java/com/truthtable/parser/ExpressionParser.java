package com.truthtable.parser;

import com.truthtable.exception.ParsingException;
import com.truthtable.model.*;
import java.util.*;

public class ExpressionParser {
    private Tokenizer tokenizer;
    
    public ExpressionParser() {
        this.tokenizer = new Tokenizer();
    }
    
    public Expression parse(String expressionStr) throws ParsingException {
        Expression expression = new Expression(expressionStr);
        List<Token> tokens = tokenizer.tokenize(expressionStr);
        expression.setTokens(tokens);
        
        Set<Variable> variables = extractVariables(tokens);
        expression.setVariables(variables);
        
        return expression;
    }
    
    private Set<Variable> extractVariables(List<Token> tokens) {
        Set<Variable> variables = new TreeSet<>();
        for (Token token : tokens) {
            if (token.getType() == TokenType.VARIABLE) {
                variables.add(new Variable(token.getValue().charAt(0)));
            }
        }
        return variables;
    }
}

