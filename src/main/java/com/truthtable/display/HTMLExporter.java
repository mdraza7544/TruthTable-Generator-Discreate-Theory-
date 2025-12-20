package com.truthtable.display;

import com.truthtable.model.*;
import java.io.*;
import java.util.*;

public class HTMLExporter {
    
    public void exportToHTML(TruthTable table, String filename) throws IOException {
        StringBuilder html = new StringBuilder();
        
        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n<head>\n");
        html.append("<title>Truth Table</title>\n");
        html.append("<style>\n");
        html.append("table { border-collapse: collapse; margin: 20px; }\n");
        html.append("th, td { border: 1px solid black; padding: 10px; text-align: center; }\n");
        html.append("th { background-color: #4CAF50; color: white; }\n");
        html.append("tr:nth-child(even) { background-color: #f2f2f2; }\n");
        html.append("</style>\n");
        html.append("</head>\n<body>\n");
        
        html.append("<h2>Truth Table for: ").append(table.getExpression().getRawExpression()).append("</h2>\n");
        html.append("<table>\n<tr>\n");
        
        for (Variable var : table.getVariables()) {
            html.append("<th>").append(var.getSymbol()).append("</th>\n");
        }
        html.append("<th>Result</th>\n</tr>\n");
        
        for (TruthTableRow row : table.getRows()) {
            html.append("<tr>\n");
            for (Variable var : table.getVariables()) {
                boolean value = row.getVariableValues().get(var);
                html.append("<td>").append(value ? "T" : "F").append("</td>\n");
            }
            html.append("<td>").append(row.getResult() ? "T" : "F").append("</td>\n");
            html.append("</tr>\n");
        }
        
        html.append("</table>\n");
        html.append("</body>\n</html>");
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(html.toString());
        }
    }
}
