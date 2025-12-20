package com.truthtable.evaluator;

public class OperatorHandler {
    
    public boolean applyOperator(LogicalOperator op, boolean... operands) {
        switch (op) {
            case AND:
                return operands[0] && operands[1];
            case OR:
                return operands[0] || operands[1];
            case NOT:
                return !operands[0];
            case IMPLIES:
                return !operands[0] || operands[1];
            case BICONDITIONAL:
                return operands[0] == operands[1];
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}
