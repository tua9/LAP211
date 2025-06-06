/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.week01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author LE ANH TUAN
 */

public class LetterAndCharacterCount {
    private String inputString;
    private String[] words;
    private Map<String, Integer> wCount;
    private Map<Character, Integer> chCount;
    
    public Map<String, Integer> wordCount() {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
  //
  
        for(String word : words) {
            wordCount.put(word,wCount.getOrDefault(word, 0) + 1);
        }
        
        return wordCount;
    }
    
    public Map<Character, Integer> charCount() {
        Map<Character, Integer> charCount = new TreeMap<>();
        for (char ch : inputString.toCharArray()) {
            if (Character.isLetter(ch)) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }
        }
        return charCount;
    }
    
    public void process() {
        wCount = wordCount();
        chCount = charCount();
    }
    
    public void showOutput() {
        System.out.println(wCount);
        System.out.println(chCount);
    }
    
    public void enterInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your content:");
        inputString = scanner.nextLine().toLowerCase();
        words = inputString.split("\\s+");
        
        scanner.close();
    }
}
