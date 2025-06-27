package com.mycompany.week05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Utils {
    public static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
    
    public static int readInteger(Scanner sc, String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine().trim());
    }
    
    public static LocalDate readTime(Scanner sc, String prompt) {
        LocalDate time = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        while(time == null) {
            String input = readString(sc, prompt);
            try {
                time = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data input is invalid, data format(d/m/yyyy) " + e);
            }
        }
        
        return time;
    }
    
    public static String format(String format, Object... values) {
        return String.format(format, values);
    }
    
    public static String convertToID(String ID) {
        if (ID == null) return null;
        return ID.trim().toUpperCase();
    }
    
    public static String readId(Scanner sc) {
        String ID = Utils.readString(sc, "ID: ");
        return convertToID(ID);
    }
    
    public static String getInput(Scanner sc, String prompt, String keyComparator) {
        String choice;
        boolean isMatch;
        do {
            System.out.print(prompt);
            choice = sc.nextLine().trim();
            isMatch = choice.matches(keyComparator);
            
            if(!isMatch) System.out.println("\u001B[31mData input is invalid\u001B[0m");
        } while(!isMatch);
        return choice;
    }
    
    public static LocalDate convertStringToLCDate(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        try {
            LocalDate date = LocalDate.parse(str, formatter);
            return date;
        } catch (DateTimeParseException e) {
            System.out.println("Data input is invalid, format date (3/9/2024)");
        }
        return null;
    }
}
