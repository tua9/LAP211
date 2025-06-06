/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week01;

/**
 *
 * @author LE ANH TUAN
 */
class SuperlativeEquation {
    private int a, b;

    public SuperlativeEquation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void solve() {
        System.out.println("\n--- Superlative Equation: " + a + "x + " + b + " = 0 ---");
        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            double x = -1.0 * b / a;
            System.out.printf("Solution: x = %.2f\n", x);
        }

        EquationUtils.displayNumberTypes(a, b);
    }
}