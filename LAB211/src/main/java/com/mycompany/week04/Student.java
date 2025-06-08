/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04;

import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
class Student extends Person {
    private int yearOfAdmission;
    private double entranceEnglishScore;

    public Student() {
        super();
        this.yearOfAdmission = 0;
        this.entranceEnglishScore = 0;
    }

    public boolean validateYearOfAdmission(int yoa) {
        int currentYear = Year.now().getValue();
        return yoa >= this.yearOfBirth && yoa <= currentYear;
    }

    public boolean validateEntranceEnglishScore(double score) {
        return score >= 0 && score <= 100;
    }

    @Override
    public void InputAll(Scanner sc) {
        while (true) {
            super.InputAll(sc);

            System.out.print("Year of admission: ");
            
            String yoaStr = sc.nextLine().trim();
            int yoa;
            
            try {
                yoa = Integer.parseInt(yoaStr);
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
                continue;
            }
            if (!validateYearOfAdmission(yoa)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.yearOfAdmission = yoa;
            }

            System.out.print("Entrance English score: ");
            
            String scoreStr = sc.nextLine().trim();
            double score;
            
            try {
                score = Double.parseDouble(scoreStr);
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
                continue;
            }
            
            if (!validateEntranceEnglishScore(score)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.entranceEnglishScore = score;
            }
            break;
        }
    }

    @Override
    public void printPersonFull() {
        System.out.printf("- %s - %s - %s - %d - %s - %d - %.0f%n",
            this.ID, this.fullName, this.phoneNumber, this.yearOfBirth, this.major,
            this.yearOfAdmission, this.entranceEnglishScore);
    }

    public int getYearOfAdmission() {
        return this.yearOfAdmission;
    }
}