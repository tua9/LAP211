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

public class BinarySearch {
    private Scanner scanner = new Scanner(System.in);
    private int n, searchValue;

    public void run() {
        while (true) {
            try {
                System.out.println("Enter a positive number of array size: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    System.out.println("Please enter a number greater than 0.");
                    continue;
                }

                System.out.println("Enter the number to search: ");
                searchValue = Integer.parseInt(scanner.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers only.");
            }
        }

        int[] array = generateRandomArray(n);
        Arrays.sort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));

        int index = binarySearch(array, searchValue);
        if (index >= 0) {
            System.out.println("Found  " + searchValue + " at index: " + index);
        } else {
            System.out.println(searchValue + " is not in the array.");
        }

        scanner.close();
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size); 
        }
        return arr;
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; 
    }
}

