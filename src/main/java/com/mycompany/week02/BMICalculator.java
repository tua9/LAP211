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
public class BMICalculator {
    public void run(Scanner scanner) {
        Double weight = InputUtils.readDouble(scanner, "Enter Weight (kg): ");
        Double heightCm = InputUtils.readDouble(scanner, "Enter Height (cm): ");
        if (weight == null || heightCm == null) return;

        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);

        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus.fromValue(bmi));
    }
}

