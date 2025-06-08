/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04.P0021;

/**
 *
 * @author LE ANH TUAN
 */
class StudentValidator {
    public static boolean isValidID(String ID) {
        return ID != null && ID.matches("^[a-zA-Z]{2}\\d{6}$");
    }
    
    public static boolean isExistID(String ID) {
        for (String key : StudentManagement.getStudentMap().keySet()) {
            if (key.equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
