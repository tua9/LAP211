/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week01;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class LinearSearch {
    
    private int[] array;
    private int searchValue;
    
    public void enterInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of array: ");
        int n = scanner.nextInt();
        array = new int[n];
        
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }

        System.out.println("Enter search value: ");
        searchValue = scanner.nextInt();
        scanner.close();
    }
    
    public void showArray() {
        System.out.print("The array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public int searchByLinearSearch() {
        for (int i = 0; i < array.length; i++)
            if (array[i] == searchValue)
                return i;
        
        return -1;
    }
    
    public void showResult(int index) {
        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index);
        } else {
            System.out.println(searchValue + " not found in the array.");
        }
    }
    
}
