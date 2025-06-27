/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class BubbleSort {
    private int[] arr;
    private int n;

    public void run() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of array:");
        n = sc.nextInt();
        
        arr = new int[10];
        Random ran = new Random();
        
        for (int i = 0; i < n; ++i)
            arr[i] = ran.nextInt(n) + 1;
        
        this.sort();
    }
    
    public void sort() {
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        for (int i = 0; i < n; ++i)
        {
            for (int j = 1; j < n; ++j)
            {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
}
