/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week01;

/**
 *
 * @author LE ANH TUAN
 */
class EquationUtils {
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isSquareNumber(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static void displayNumberTypes(int... nums) {
        System.out.print("Even numbers: ");
        for (int n : nums) {
            if (isEven(n)) System.out.print(n + " ");
        }
        System.out.print("\nOdd numbers: ");
        for (int n : nums) {
            if (isOdd(n)) System.out.print(n + " ");
        }
        System.out.print("\nSquare numbers: ");
        for (int n : nums) {
            if (isSquareNumber(n)) System.out.print(n + " ");
        }
        System.out.println();
    }
}
