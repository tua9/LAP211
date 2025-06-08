/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04.P0021;

/**
 *
 * @author LE ANH TUAN
 */
public enum ProgrammingLanguage {
    JAVA("Java"),
    DOT_NET(".Net"),
    C_CPP("C/C++");
    
    private final String label;

    ProgrammingLanguage(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static ProgrammingLanguage fromLabel(String label) {
        for (ProgrammingLanguage lang : values()) {
            if (lang.getLabel().equalsIgnoreCase(label)) {
                return lang;
            }
        }
        return null;
    }
}
