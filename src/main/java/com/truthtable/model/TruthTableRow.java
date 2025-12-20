package com.truthtable.model;

import java.util.*;

public class TruthTableRow {
    private Map<Variable, Boolean> variableValues;
    private boolean result;
    
    public TruthTableRow() {
        this.variableValues = new LinkedHashMap<>();
    }
    
    public Map<Variable, Boolean> getVariableValues() {
        return variableValues;
    }
    
    public void setVariableValue(Variable var, boolean value) {
        variableValues.put(var, value);
    }
    
    public boolean getResult() {
        return result;
    }
    
    public void setResult(boolean result) {
        this.result = result;
    }
}
