/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week01;

import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class MenuEquation {
    
    public void menu() {
            System.out.println("\n================== MENU ==================");
            System.out.println("1. Calculate Superlative Equation (Ax + B = 0)");
            System.out.println("2. Calculate Quadratic Equation (Ax² + Bx + C = 0)");
            System.out.println("3. Exit");
            System.out.println("================== MENU ==================");
    }
    
    public void enterInput() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid. Enter again: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            System.out.println("C = " + choice);
            switch (choice) {
                case 1:
                    System.out.print("Enter coefficient A: ");
                    int a1 = scanner.nextInt();
                    System.out.print("Enter coefficient B: ");
                    int b1 = scanner.nextInt();
                    SuperlativeEquation se = new SuperlativeEquation(a1, b1);
                    se.solve();
                    break;

                case 2:
                    System.out.print("Enter coefficient A: ");
                    int a2 = scanner.nextInt();
                    System.out.print("Enter coefficient B: ");
                    int b2 = scanner.nextInt();
                    System.out.print("Enter coefficient C: ");
                    int c2 = scanner.nextInt();
                    QuadraticEquation qe = new QuadraticEquation(a2, b2, c2);
                    qe.solve();
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1, 2 or 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
