package com.mycompany.week01;

import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class BaseConverter {
    
    private int fromBase;
    private int toBase;
    private int decimalValue;
    private String inputNumber;
    private String convertedValue;
    
    public int toDecimal(String number, int base) {
        int result = 0;
        int power = 1;

        for (int i = number.length() - 1; i >= 0; i--) {
            char digitChar = number.charAt(i);
            int digit;

            if (Character.isDigit(digitChar)) {
                digit = digitChar - '0';
            } else {
                digit = Character.toUpperCase(digitChar) - 'A' + 10;
            }

            if (digit >= base) {
                throw new IllegalArgumentException("Invalid digit for base " + base);
            }

            result += digit * power;
            power *= base;
        }

        return result;
    }

    public String fromDecimaltoBase(int decimal, int base) {
        if (decimal == 0) return "0";

        StringBuilder result = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % base;
            char digitChar;

            if (remainder < 10) {
                digitChar = (char) ('0' + remainder);
            } else {
                digitChar = (char) ('A' + (remainder - 10));
            }

            result.insert(0, digitChar);
            decimal /= base;
        }

        return result.toString();
    }
    
    public void process() {
        decimalValue = toDecimal(inputNumber, fromBase);
        convertedValue = fromDecimaltoBase(decimalValue, toBase);
    }
    
    public void showOutput() {
        System.out.println("Result: " + convertedValue);
    }

    public void enterInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Choose input base (2, 10, 16): ");
            String fromBaseStr = scanner.nextLine();

            System.out.print("Choose output base (2, 10, 16): ");
            String toBaseStr = scanner.nextLine();

            System.out.print("Enter number to convert: ");
            inputNumber = scanner.nextLine();

            fromBase = Integer.parseInt(fromBaseStr);
            toBase = Integer.parseInt(toBaseStr);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
