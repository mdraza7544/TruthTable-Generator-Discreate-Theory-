package com.truthtable.model;

import java.util.*;

public class TruthTable {
    private List<Variable> variables;
    private List<TruthTableRow> rows;
    private Expression expression;
    
    public TruthTable(Expression expression) {
        this.expression = expression;
        this.variables = new ArrayList<>(expression.getVariables());
        this.rows = new ArrayList<>();
    }
    
    public List<Variable> getVariables() {
        return variables;
    }
    
    public List<TruthTableRow> getRows() {
        return rows;
    }
    
    public void addRow(TruthTableRow row) {
        rows.add(row);
    }
    
    public Expression getExpression() {
        return expression;
    }
}
