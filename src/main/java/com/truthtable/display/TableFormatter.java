package com.truthtable.display;

import com.truthtable.model.*;
import java.util.*;

public class TableFormatter {

    public String format(TruthTable table) {
        StringBuilder sb = new StringBuilder();
        List<Variable> variables = table.getVariables();

        int colWidth = 8;

        for (Variable var : variables) {
            sb.append(String.format("%-" + colWidth + "s", var.getSymbol()));
        }
        sb.append(String.format("%-" + colWidth + "s", "Result"));
        sb.append("\n");

        // Java 8 compatible string repetition
        int dashCount = (variables.size() + 1) * colWidth;
        for (int i = 0; i < dashCount; i++) {
            sb.append("-");
        }
        sb.append("\n");

        for (TruthTableRow row : table.getRows()) {
            for (Variable var : variables) {
                boolean value = row.getVariableValues().get(var);
                sb.append(String.format("%-" + colWidth + "s", value ? "T" : "F"));
            }
            sb.append(String.format("%-" + colWidth + "s", row.getResult() ? "T" : "F"));
            sb.append("\n");
        }

        return sb.toString();
    }
}