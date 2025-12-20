package com.truthtable.display;

import com.truthtable.model.TruthTable;

public class ConsoleDisplay {
    private TableFormatter formatter;
    
    public ConsoleDisplay() {
        this.formatter = new TableFormatter();
    }
    
    public void display(TruthTable table) {
        System.out.println("\nTruth Table for: " + table.getExpression().getRawExpression());
        System.out.println("Variables: " + table.getVariables().size());
        System.out.println("Rows: " + table.getRows().size());
        System.out.println();
        System.out.println(formatter.format(table));
    }
}
