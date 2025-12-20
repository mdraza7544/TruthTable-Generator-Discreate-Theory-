package com.truthtable;

import com.truthtable.display.*;
import com.truthtable.exception.*;
import com.truthtable.generator.*;
import com.truthtable.model.*;
import com.truthtable.parser.ExpressionParser;
import com.truthtable.validator.ExpressionValidator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionValidator validator = new ExpressionValidator();
        ExpressionParser parser = new ExpressionParser();
        TruthTableGenerator generator = new TruthTableGenerator();
        TautologyChecker tautologyChecker = new TautologyChecker();
        ConsoleDisplay display = new ConsoleDisplay();
        HTMLExporter htmlExporter = new HTMLExporter();
        
        System.out.println("=== Truth Table Generator ===");
        System.out.println("Supported operators:");
        System.out.println("  AND: & or && or ∧");
        System.out.println("  OR: | or || or ∨");
        System.out.println("  NOT: ! or ~ or ¬");
        System.out.println("  IMPLIES: -> or →");
        System.out.println("  BICONDITIONAL: <-> or ↔");
        System.out.println("\nExample: (p&q)->r  or  (A|B)&!C\n");
        
        while (true) {
            try {
                System.out.print("Enter logical expression (or 'exit' to quit): ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye!");
                    break;
                }
                
                if (input.isEmpty()) {
                    continue;
                }
                
                // Validate expression
                validator.validate(input);
                
                // Parse expression
                Expression expression = parser.parse(input);
                
                // Generate truth table
                TruthTable table = generator.generate(expression);
                
                // Display truth table
                display.display(table);
                
                // Check if tautology
                if (tautologyChecker.isTautology(table)) {
                    System.out.println("✓ This is a TAUTOLOGY (always true)");
                } else if (tautologyChecker.isContradiction(table)) {
                    System.out.println("✗ This is a CONTRADICTION (always false)");
                } else {
                    System.out.println("~ This is a CONTINGENCY (sometimes true, sometimes false)");
                }
                
                // Ask if user wants to export to HTML
                System.out.print("\nExport to HTML? (y/n): ");
                String exportChoice = scanner.nextLine().trim();
                if (exportChoice.equalsIgnoreCase("y")) {
                    String filename = "truth_table_" + System.currentTimeMillis() + ".html";
                    htmlExporter.exportToHTML(table, filename);
                    System.out.println("Exported to: " + filename);
                }
                
                System.out.println();
                
            } catch (InvalidExpressionException e) {
                System.err.println("Invalid Expression: " + e.getMessage());
            } catch (ParsingException e) {
                System.err.println("Parsing Error: " + e.getMessage());
            } catch (EvaluationException e) {
                System.err.println("Evaluation Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        scanner.close();
    }
}




