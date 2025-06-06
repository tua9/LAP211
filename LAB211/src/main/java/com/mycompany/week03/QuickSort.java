/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week03;

/**
 *
 * @author LE ANH TUAN
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort{
    private int n;
    private int[] arr;
    Scanner scanner = new Scanner(System.in);

    public void run (){
        while (true) {
            System.out.print("Enter a positive decimal number (array size): ");
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n > 0) break;
                else System.out.println("Number must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }

        arr = generateRandomArray(n);
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        
        quickSort(0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        scanner.close();
    }

    private static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n) + 1; 
        }
        return arr;
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = arr[(low + high) / 2];
        int i = low, j = high;
        while (true) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i >= j) return j;
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
