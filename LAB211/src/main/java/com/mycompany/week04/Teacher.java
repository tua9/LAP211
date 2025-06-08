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

class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0;
    }

    public boolean validateYearInProfession(int yip) {
        int currentYear = Year.now().getValue();
        int age = currentYear - this.yearOfBirth;
        return yip >= 0 && yip < age;
    }

    public boolean validateContractType(String ct) {
        return ct.equals("Long") || ct.equals("Short");
    }

    public boolean validateSalaryCoefficient(double sc) {
        return sc >= 0;
    }

    @Override
    public void InputAll(Scanner sc) {
        while (true) {
            super.InputAll(sc);

            System.out.print("Year in the profession: ");
            String yipStr = sc.nextLine().trim();
            
            int yip;
            
            try {
                yip = Integer.parseInt(yipStr);
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
                continue;
            }
            
            if (!validateYearInProfession(yip)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.yearInProfession = yip;
            }

            System.out.print("Contract type: ");
            String ct = sc.nextLine().trim();
            ct = capitalizeFirstLetter(ct);
            if (!validateContractType(ct)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.contractType = ct;
            }

            System.out.print("Salary coefficient: ");
            String scStr = sc.nextLine().trim();
            double scVal;
            try {
                scVal = Double.parseDouble(scStr);
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
                continue;
            }
            if (!validateSalaryCoefficient(scVal)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.salaryCoefficient = scVal;
            }
            break;
        }
    }

    @Override
    public void printPersonFull() {
        System.out.printf("- %s - %s - %s - %d - %s - %d - %s - %.1f%n",
            this.ID, this.fullName, this.phoneNumber, this.yearOfBirth, this.major,
            this.yearInProfession, this.contractType, this.salaryCoefficient);
    }

    public int getYearInProfession() {
        return this.yearInProfession;
    }
    
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}