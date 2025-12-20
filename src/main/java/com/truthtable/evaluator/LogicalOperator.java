package com.truthtable.evaluator;

public enum LogicalOperator {
    AND("∧", "&&"),
    OR("∨", "||"),
    NOT("¬", "!"),
    IMPLIES("→", "->"),
    BICONDITIONAL("↔", "<->");
    
    private String symbol;
    private String alternative;
    
    LogicalOperator(String symbol, String alternative) {
        this.symbol = symbol;
        this.alternative = alternative;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public String getAlternative() {
        return alternative;
    }
}
