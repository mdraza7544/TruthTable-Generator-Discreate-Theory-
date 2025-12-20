package com.truthtable.model;

import java.util.Objects;

public class Variable implements Comparable<Variable> {
    private char symbol;
    private boolean value;
    
    public Variable(char symbol) {
        this.symbol = symbol;
        this.value = false;
    }
    
    public Variable(char symbol, boolean value) {
        this.symbol = symbol;
        this.value = value;
    }
    
    public char getSymbol() {
        return symbol;
    }
    
    public boolean getValue() {
        return value;
    }
    
    public void setValue(boolean value) {
        this.value = value;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return symbol == variable.symbol;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
    
    @Override
    public int compareTo(Variable other) {
        return Character.compare(this.symbol, other.symbol);
    }
    
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}

