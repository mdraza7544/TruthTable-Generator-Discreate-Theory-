package com.truthtable.model;

import java.util.*;

import com.truthtable.parser.Token;

public class Expression {
    private String rawExpression;
    private Set<Variable> variables;
    private List<Token> tokens;
    
    public Expression(String rawExpression) {
        this.rawExpression = rawExpression;
        this.variables = new TreeSet<>();
    }
    
    public String getRawExpression() {
        return rawExpression;
    }
    
    public Set<Variable> getVariables() {
        return variables;
    }
    
    public void setVariables(Set<Variable> variables) {
        this.variables = variables;
    }
    
    public List<Token> getTokens() {
        return tokens;
    }
    
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}