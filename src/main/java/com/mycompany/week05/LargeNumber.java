
package com.mycompany.week05;

import com.mycompany.week04.P0021.Utils;
import java.util.Scanner;

/*
    Note: 
 */
public class LargeNumber {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while(choice != 3) {
            System.out.println("\n-------------- Larger Number --------------");
            BigNum numA = new BigNum(Utils.readString(sc, "A = "));
            BigNum numB = new BigNum(Utils.readString(sc, "B = "));
            
            if(!isValidNumber(numA.toString()) || !isValidNumber(numB.toString()))
            {
                System.out.println("Invalid input!");
                break;
            }
            
            choice = Utils.readInteger(sc,"1.Add\n2.Multiply\n3.Exit\n>");
            if(choice > 3 && choice < 1) System.out.println("Invalid input!");
            if (choice == 1) System.out.println("Result = " + numA.add(numB));
            if (choice == 2) System.out.println("Result = " + numA.multiply(numB));
        }
    }
    
     public static boolean isValidNumber(String s) {
        return s.matches("\\d+");
    }
}
