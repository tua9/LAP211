/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week02;

/**
 *
 * @author LE ANH TUAN
 */
public enum Operator {
    ADD("+") {
        @Override
        public double calculate(double a, double b) { return a + b; }
    },
    SUBTRACT("-") {
        @Override
        public double calculate(double a, double b) { return a - b; }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double a, double b) { return a * b; }
    },
    DIVIDE("/") {
        @Override
        public double calculate(double a, double b) {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        }
    },
    EXPONENT("^") {
        @Override
        public double calculate(double a, double b) { return Math.pow(a, b); }
    },
    EQUAL("=") {
        @Override
        public double calculate(double a, double b) { return a; }
    };

    private final String symbol;
    
    Operator(String symbol) { this.symbol = symbol; }

    public abstract double calculate(double a, double b);

    public static Operator fromString(String s) {
        for (Operator op : values()) {
            if (op.symbol.equals(s)) return op;
        }
        return null;
    }
}
