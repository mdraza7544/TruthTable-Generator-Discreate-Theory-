package com.truthtable.generator;

import com.truthtable.evaluator.ExpressionEvaluator;
import com.truthtable.exception.EvaluationException;
import com.truthtable.model.*;
import java.util.*;

public class TruthTableGenerator {
    private CombinationGenerator combinationGenerator;
    private ExpressionEvaluator evaluator;
    
    public TruthTableGenerator() {
        this.combinationGenerator = new CombinationGenerator();
        this.evaluator = new ExpressionEvaluator();
    }
    
    public TruthTable generate(Expression expression) throws EvaluationException {
        TruthTable table = new TruthTable(expression);
        
        List<Map<Variable, Boolean>> combinations = 
            combinationGenerator.generateCombinations(expression.getVariables());
        
        for (Map<Variable, Boolean> combination : combinations) {
            TruthTableRow row = new TruthTableRow();
            
            for (Map.Entry<Variable, Boolean> entry : combination.entrySet()) {
                row.setVariableValue(entry.getKey(), entry.getValue());
            }
            
            boolean result = evaluator.evaluate(expression, combination);
            row.setResult(result);
            
            table.addRow(row);
        }
        
        return table;
    }
}