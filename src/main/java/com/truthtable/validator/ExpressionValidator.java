package com.truthtable.validator;

import com.truthtable.exception.InvalidExpressionException;

public class ExpressionValidator {
    private SyntaxValidator syntaxValidator;
    
    public ExpressionValidator() {
        this.syntaxValidator = new SyntaxValidator();
    }
    
    public boolean validate(String expression) throws InvalidExpressionException {
        if (expression == null || expression.trim().isEmpty()) {
            throw new InvalidExpressionException("Expression cannot be null or empty");
        }
        
        syntaxValidator.checkParentheses(expression);
        syntaxValidator.checkOperatorPlacement(expression);
        
        return true;
    }
}