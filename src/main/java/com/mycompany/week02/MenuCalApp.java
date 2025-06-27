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
public class MenuCalApp {
    private final Scanner scanner = new Scanner(System.in);
    private final NormalCalculator normalCalculator = new NormalCalculator();
    private final BMICalculator bmiCalculator = new BMICalculator();

    public void run() {
        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> normalCalculator.run(scanner);
                case "2" -> bmiCalculator.run(scanner);
                case "3" -> {
                    System.out.println("End!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

