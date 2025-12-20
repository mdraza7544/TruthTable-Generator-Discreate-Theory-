package com.truthtable.evaluator;

import com.truthtable.exception.EvaluationException;
import com.truthtable.model.*;
import com.truthtable.parser.*;
import java.util.*;

public class ExpressionEvaluator {
    private OperatorHandler operatorHandler;
    
    public ExpressionEvaluator() {
        this.operatorHandler = new OperatorHandler();
    }
    
    public boolean evaluate(Expression expr, Map<Variable, Boolean> values) 
            throws EvaluationException {
        try {
            List<Token> postfix = convertToPostfix(expr.getTokens());
            return evaluatePostfix(postfix, values);
        } catch (Exception e) {
            throw new EvaluationException("Error evaluating expression: " + e.getMessage());
        }
    }
    
    private List<Token> convertToPostfix(List<Token> infix) {
        List<Token> output = new ArrayList<>();
        Stack<Token> operators = new Stack<>();
        
        for (Token token : infix) {
            switch (token.getType()) {
                case VARIABLE:
                    output.add(token);
                    break;
                case LEFT_PAREN:
                    operators.push(token);
                    break;
                case RIGHT_PAREN:
                    while (!operators.isEmpty() && 
                           operators.peek().getType() != TokenType.LEFT_PAREN) {
                        output.add(operators.pop());
                    }
                    if (!operators.isEmpty()) {
                        operators.pop();
                    }
                    break;
                default:
                    while (!operators.isEmpty() && 
                           precedence(operators.peek()) >= precedence(token)) {
                        output.add(operators.pop());
                    }
                    operators.push(token);
                    break;
            }
        }
        
        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }
        
        return output;
    }
    
    private int precedence(Token token) {
        switch (token.getType()) {
            case NOT:
                return 4;
            case AND:
                return 3;
            case OR:
                return 2;
            case IMPLIES:
                return 1;
            case BICONDITIONAL:
                return 0;
            default:
                return -1;
        }
    }
    
    private boolean evaluatePostfix(List<Token> postfix, Map<Variable, Boolean> values) {
        Stack<Boolean> stack = new Stack<>();
        
        for (Token token : postfix) {
            if (token.getType() == TokenType.VARIABLE) {
                Variable var = new Variable(token.getValue().charAt(0));
                stack.push(values.get(var));
            } else {
                switch (token.getType()) {
                    case NOT:
                        boolean operand = stack.pop();
                        stack.push(operatorHandler.applyOperator(LogicalOperator.NOT, operand));
                        break;
                    case AND:
                        boolean b1 = stack.pop();
                        boolean a1 = stack.pop();
                        stack.push(operatorHandler.applyOperator(LogicalOperator.AND, a1, b1));
                        break;
                    case OR:
                        boolean b2 = stack.pop();
                        boolean a2 = stack.pop();
                        stack.push(operatorHandler.applyOperator(LogicalOperator.OR, a2, b2));
                        break;
                    case IMPLIES:
                        boolean b3 = stack.pop();
                        boolean a3 = stack.pop();
                        stack.push(operatorHandler.applyOperator(LogicalOperator.IMPLIES, a3, b3));
                        break;
                    case BICONDITIONAL:
                        boolean b4 = stack.pop();
                        boolean a4 = stack.pop();
                        stack.push(operatorHandler.applyOperator(LogicalOperator.BICONDITIONAL, a4, b4));
                        break;
                }
            }
        }
        
        return stack.pop();
    }
}
