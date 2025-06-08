/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04;

/**
 *
 * @author LE ANH TUAN
 */
import java.util.*;
import java.time.Year;

class Person {
    protected String ID;
    protected String fullName;
    protected String phoneNumber;
    protected int yearOfBirth;
    protected String major;

    public Person() {
        this.ID = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.yearOfBirth = 0;
        this.major = "";
    }

    public boolean validateID(String id) {
        return id.matches("\\d{6}");
    }

    public boolean validateFullName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    public boolean validatePhoneNumber(String phone) {
        return phone.matches("\\d{12}");
    }

    public boolean validateYearOfBirth(int yob) {
        int currentYear = Year.now().getValue();
        return yob > 0 && yob < currentYear;
    }

    public boolean validateMajor(String mj) {
        return mj.length() <= 30 && !mj.isEmpty();
    }

    public void InputAll(Scanner sc) {
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine().trim();
            if (!validateID(id)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.ID = id;
            }

            System.out.print("Fullname: ");
            String name = sc.nextLine().trim();
            if (!validateFullName(name)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.fullName = name;
            }

            System.out.print("Phone number: ");
            String phone = sc.nextLine().trim();
            if (!validatePhoneNumber(phone)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.phoneNumber = phone;
            }

            System.out.print("Year of birth: ");
            String yobStr = sc.nextLine().trim();
            int yob = 0;
            try {
                yob = Integer.parseInt(yobStr);
            } catch (Exception e) {
                System.out.println("Data input is invalid");
                continue;
            }
            if (!validateYearOfBirth(yob)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.yearOfBirth = yob;
            }

            System.out.print("Major: ");
            String mj = sc.nextLine().trim();
            if (!validateMajor(mj)) {
                System.out.println("Data input is invalid");
                continue;
            } else {
                this.major = mj;
            }
            break;
        }
    }

    public void printPersonBasic() {
        System.out.printf("- %s - %s - %s - %d - %s%n", this.ID, this.fullName, this.phoneNumber, this.yearOfBirth, this.major);
    }

    public void printPersonFull() {
        printPersonBasic();
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }
}
