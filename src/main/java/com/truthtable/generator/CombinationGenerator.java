package com.truthtable.generator;

import com.truthtable.model.*;
import java.util.*;

public class CombinationGenerator {
    
    public List<Map<Variable, Boolean>> generateCombinations(Set<Variable> variables) {
        List<Map<Variable, Boolean>> combinations = new ArrayList<>();
        List<Variable> varList = new ArrayList<>(variables);
        int n = varList.size();
        int totalCombinations = (int) Math.pow(2, n);
        
        for (int i = 0; i < totalCombinations; i++) {
            Map<Variable, Boolean> combination = new LinkedHashMap<>();
            for (int j = 0; j < n; j++) {
                boolean value = (i & (1 << (n - 1 - j))) != 0;
                combination.put(varList.get(j), value);
            }
            combinations.add(combination);
        }
        
        return combinations;
    }
}
