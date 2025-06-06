/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class InformationManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Person> listPerson;
    
    public static void management() {
        int choice = -1;
        do {
            try {
                System.out.println("** Information Management ***");
                System.out.println("1. Teacher");
                System.out.println("2. Student");
                System.out.println("3. Person");
                System.out.println("4. Exit");
                choice = scanner.nextInt();
            }
            catch(NumberFormatException e) {
                System.out.println("Input invalid!");
            }
            
            switch(choice) {
                case 1 -> teacherManagement();
                case 2 -> studentManagement();
                case 3 -> personManagement();
                case 4 -> System.out.println("Exit Informantion Management.");
            }
            
        } while (choice != 4);
    }
    
    public static void teacherManagement() {
        int choice = -1;
        do {
            try {
                System.out.println("*** Teacher Management ***");
                System.out.println("1. Input");
                System.out.println("2. Print");
                System.out.println("3. Exit");
                choice = scanner.nextInt();
            }
            catch(NumberFormatException e) {
                System.out.println("Input invalid!");
            }
            
            switch(choice) {
                case 1 -> teacherInput();
                case 2 -> teacherPrint();
                case 3 -> System.out.println("Exit Informantion Management.");
            }
            
        } while (choice != 3);
    }
    
    public static void teacherInput() {
        do {
            int ID = InputUtils.readInteger(scanner, "ID: ");
            if (ID == -1) continue;
            
            String fullName = InputUtils.readString(scanner, "Fullname: ");
            
            String phoneNumber = InputUtils.readString(scanner, "Phone number: ");
            
            int yearOB = InputUtils.readInteger(scanner, "Year of birth: ");
            if (yearOB == -1) continue;
            
            String major = InputUtils.readString(scanner, "Major: ");
            
            int yearInProfession = InputUtils.readInteger(scanner, "Year in the profession: ");
            if (yearInProfession == -1) continue;
            
            String contractType = InputUtils.readString(scanner, "Contract type: ");
            
            Double salaryCoefficient = InputUtils.readDouble(scanner, "Salary coefficient: ");
            if (salaryCoefficient == null) continue;
        } while(false);
    }
    
    public static void teacherPrint() {
        for(Person p : listPerson) {
            if (p instanceof Teacher) 
                System.out.println(p);
        }
    }

    public static void studentManagement() {
        int choice = -1;
        do {
            try {
                System.out.println("*** Student Management ***");
                System.out.println("1. Input");
                System.out.println("2. Print");
                System.out.println("3. Exit");
                choice = scanner.nextInt();
            }
            catch(NumberFormatException e) {
                System.out.println("Input invalid!");
            }
            
            switch(choice) {
                case 1 -> studentInput();
                case 2 -> studentPrint();
                case 3 -> System.out.println("Exit Informantion Management.");
            }
            
        } while (choice != 3);
    }
    
    private static void studentInput() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void studentPrint() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void personManagement() {
        int choice = -1;
        do {
            try {
                System.out.println("*** Student Management ***");
                System.out.println("1. Search");
                System.out.println("2. Print All");
                System.out.println("3. Exit");
                choice = scanner.nextInt();
            }
            catch(NumberFormatException e) {
                System.out.println("Input invalid!");
            }
            
            switch(choice) {
                case 1 -> personSearch();
                case 2 -> personPrintAll();
                case 3 -> System.out.println("Exit Informantion Management.");
            }
            
        } while (choice != 3);
    }

    private static void personSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void personPrintAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
