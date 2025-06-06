package com.mycompany.week03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class MyStack {
    private ArrayList<Integer> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }

    public void push(int value) {
        stackValues.add(value);
        System.out.println("Pushed: " + value);
    }

    public Integer pop() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        int poppedValue = stackValues.remove(stackValues.size() - 1);
        System.out.println("Popped: " + poppedValue);
        return poppedValue;
    }

    public Integer get() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        int topValue = stackValues.get(stackValues.size() - 1);
        System.out.println("Top value: " + topValue);
        return topValue;
    }

    public void display() {
        System.out.println("Current Stack: " + stackValues);
    }
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        MyStack myStack = new MyStack();
        int choice;

        do {
            System.out.println("\n===== STACK MENU =====");
            System.out.println("1. Push value");
            System.out.println("2. Pop value");
            System.out.println("3. Get top value");
            System.out.println("4. Display stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter value to push: ");
                        int val = Integer.parseInt(scanner.nextLine());
                        myStack.push(val);
                        break;
                    case 2:
                        myStack.pop();
                        break;
                    case 3:
                        myStack.get();
                        break;
                    case 4:
                        myStack.display();
                        break;
                    case 5:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
                choice = 0;
            }
        } while (choice != 5);

        scanner.close();
    }
}
