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
public class NormalCalculator {
    public void run(Scanner scanner) {
        Double memory = InputUtils.readDouble(scanner, "Enter number: ");
        if (memory == null) return;

        while (true) {
            String operatorStr = InputUtils.readString(scanner, "Enter Operator: ");
            Operator operator = Operator.fromString(operatorStr);

            if (operator == null) {
                System.out.println("Please input (+, -, *, /, ^, =)");
                continue;
            }
            
            if (operator == Operator.EQUAL) {
                System.out.printf("Result: %.2f\n", memory);
                return;
            }

            Double nextNum = InputUtils.readDouble(scanner, "Enter number: ");
            if (nextNum == null) return;

            try {
                memory = operator.calculate(memory, nextNum);
                System.out.printf("Memory: %.2f\n", memory);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
