/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04;

import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class InputUtils {
    public static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public static int readInteger(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return (int)Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e) {
            System.out.println("Input invalid!");
        }
        return -1;
    }
    
    public static Double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(scanner.nextLine());
        } 
        catch (NumberFormatException e) {
            System.out.println("Input invalid!");
            return null;
        }
    }
}
