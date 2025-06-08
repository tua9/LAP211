/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04.P0021;

import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class Utils {
    public static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
    
    public static String format(String format, Object... values) {
        return String.format(format, values);
    }
    
    public static String convertToID(String ID) {
        if (ID == null) return null;
        return ID.trim().toUpperCase();
    }
    
    public static String readExistingStudentId(Scanner sc) {
        String ID = Utils.readString(sc, "ID: ");
        
        if(!StudentValidator.isValidID(ID)) {
            System.out.println("Invalid ID!");
            return null;
        }
        
        if(!StudentValidator.isExistID(ID)) {
            System.out.println("ID not found!");
            return null;
        }
        
        ID = convertToID(ID);
        return ID;
    }
    
    public static String readId(Scanner sc) {
        String ID = Utils.readString(sc, "ID: ");
        
        if(!StudentValidator.isValidID(ID)) {
            System.out.println("Invalid ID!");
            return null;
        }
        
        if(StudentValidator.isExistID(ID)) {
            System.out.println("ID already exists!");
            return null;
        }
        
        ID = convertToID(ID);
        return ID;
    }
}
