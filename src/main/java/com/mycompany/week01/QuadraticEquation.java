/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week01;

/**
 *
 * @author LE ANH TUAN
 */
class QuadraticEquation {
    private int a, b, c;

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve() {
        System.out.println("\n--- Quadratic Equation: " + a + "x² + " + b + "x + " + c + " = 0 ---");

        if (a == 0) {
            System.out.println("This is not a quadratic equation.");
            return;
        }

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("Two distinct roots: x1 = %.2f, x2 = %.2f\n", x1, x2);
        } else if (delta == 0) {
            double x = -b / (2.0 * a);
            System.out.printf("Double root: x = %.2f\n", x);
        } else {
            System.out.println("No real roots.");
        }

        EquationUtils.displayNumberTypes(a, b, c);
    }
}

