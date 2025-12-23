Truth Table Generator
A Java application that generates truth tables for logical expressions with multiple variables. Automatically detects tautologies, contradictions, and contingencies.

Features
•	 Handle expressions with 2, 3, 4+ variables
•	 Automatic tautology/contradiction detection
•	 Multiple operator formats (symbolic & ASCII)
•	 HTML export functionality
•	 Input validation and error handling

Supported Operators
Operator	Symbols	Example
AND	&, &&, ∧	p&q
OR	|, ||, ∨	p|q
NOT	!, ~, ¬	!p
IMPLIES	->, →	p->q
BICONDITIONAL	<->, ↔	p<->q

Installation
Prerequisites
•	Java JDK 8 or higher

Usage
=== Truth Table Generator ===
Enter logical expression (or 'exit' to quit): p|!p

Truth Table for: p|!p
Variables: 1
Rows: 2

p       Result  
----------------
F       T       
T       T       

✓ This is a TAUTOLOGY (always true)
Export to HTML? (y/n):

Example Expressions
Simple:
p&q
p|q
!p
p->q

Tautologies:
p|!p                        # Law of Excluded Middle
((p->q)&p)->q               # Modus Ponens
(p->q)<->(!p|q)            # Implication Equivalence

Complex:
(p&q)->r
((p->q)&(q->r))->(p->r)    # Hypothetical Syllogism


Project Structure
src/main/java/com/truthtable/
├── Main.java
├── model/          # Data structures (Expression, Variable, TruthTable)
├── parser/         # Tokenization and parsing
├── evaluator/      # Expression evaluation
├── generator/      # Truth table generation
├── validator/      # Input validation
├── display/        # Output formatting
└── exception/      # Custom exceptions


Algorithm
1.	Tokenize input expression (O(n))
2.	Parse and extract variables (O(n))
3.	Generate 2^n combinations (O(2^n))
4.	Evaluate each combination (O(2^n × m))
5.	Classify as tautology/contradiction/contingency
Time Complexity: O(2^n × m) where n = variables, m = expression complexity

Testing
Try these expressions:
•	p|!p → Should detect tautology
•	p&!p → Should detect contradiction
•	(p&q)->r → Should generate 8 rows

Known Limitations
•	Practical limit: ~10 variables (1024 rows)
•	Propositional logic only (no quantifiers)
•	No expression simplification

Future Enhancements
•	GUI interface
•	Additional operators (XOR, NAND, NOR)
•	Karnaugh map generation
•	Expression simplification

Author
Md Ashif Raza
