/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week02;

import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */

public class MatrixCalculatorApp {
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("====== MATRIX CALCULATOR ======");
            System.out.println("1. Addition of matrices");
            System.out.println("2. Subtraction of matrices");
            System.out.println("3. Multiplication of matrices");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            String option = sc.nextLine();

            switch (option) {
                case "1" -> handleOperation(sc, "addition");
                case "2" -> handleOperation(sc, "subtraction");
                case "3" -> handleOperation(sc, "multiplication");
                case "4" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void handleOperation(Scanner sc, String operation) {
        System.out.println("Enter Matrix 1:");
        Matrix m1 = Matrix.inputMatrix(sc, "Matrix1");

        System.out.println("Enter Matrix 2:");
        Matrix m2 = Matrix.inputMatrix(sc, "Matrix2");

        Matrix result = null;
        switch (operation) {
            case "addition" -> {
                if (m1.sameSize(m2)) {
                    result = m1.additionMatrix(m2);
                } else {
                    System.out.println("Matrix sizes do not match for addition.");
                    return;
                }
            }
            case "subtraction" -> {
                if (m1.sameSize(m2)) {
                    result = m1.subtractionMatrix(m2);
                } else {
                    System.out.println("Matrix sizes do not match for subtraction.");
                    return;
                }
            }
            case "multiplication" -> {
                if (m1.getCols() == m2.getRows()) {
                    result = m1.multiplicationMatrix(m2);
                } else {
                    System.out.println("Matrix sizes are not valid for multiplication.");
                    return;
                }
            }
        }

        System.out.println("Result:");
        result.display();
    }
}
