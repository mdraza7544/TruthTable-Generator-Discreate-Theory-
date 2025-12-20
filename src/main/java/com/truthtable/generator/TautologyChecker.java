package com.truthtable.generator;

import com.truthtable.model.*;

public class TautologyChecker {
    
    public boolean isTautology(TruthTable table) {
        for (TruthTableRow row : table.getRows()) {
            if (!row.getResult()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isContradiction(TruthTable table) {
        for (TruthTableRow row : table.getRows()) {
            if (row.getResult()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isContingency(TruthTable table) {
        return !isTautology(table) && !isContradiction(table);
    }
}
