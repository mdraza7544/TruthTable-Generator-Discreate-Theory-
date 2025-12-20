package com.truthtable.validator;

import com.truthtable.exception.InvalidExpressionException;

public class SyntaxValidator {
    
    public void checkParentheses(String expression) throws InvalidExpressionException {
        int count = 0;
        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    throw new InvalidExpressionException("Unbalanced parentheses");
                }
            }
        }
        if (count != 0) {
            throw new InvalidExpressionException("Unbalanced parentheses");
        }
    }
    
    public void checkOperatorPlacement(String expression) throws InvalidExpressionException {
        expression = expression.replaceAll("\\s+", "");
        
        if (expression.isEmpty()) {
            throw new InvalidExpressionException("Empty expression");
        }
        
        for (int i = 0; i < expression.length() - 1; i++) {
            char current = expression.charAt(i);
            char next = expression.charAt(i + 1);
            
            if (isOperator(current) && current != '!' && current != '¬' && current != '~' 
                && isOperator(next) && next != '!' && next != '¬' && next != '~') {
                throw new InvalidExpressionException(
                    "Invalid operator placement at position " + i);
            }
        }
    }
    
    private boolean isOperator(char ch) {
        return ch == '&' || ch == '|' || ch == '!' || ch == '~' || 
               ch == '¬' || ch == '∧' || ch == '∨' || ch == '→' || ch == '↔';
    }
}
