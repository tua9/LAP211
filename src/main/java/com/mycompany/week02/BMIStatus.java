/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week02;

/**
 *
 * @author LE ANH TUAN
 */
public enum BMIStatus {
    UNDER_STANDARD, STANDARD, OVERWEIGHT, FAT, VERY_FAT;

    public static BMIStatus fromValue(double bmi) {
        if (bmi < 19) return UNDER_STANDARD;
        if (bmi < 25) return STANDARD;
        if (bmi < 30) return OVERWEIGHT;
        if (bmi < 40) return FAT;
        return VERY_FAT;
    }
}
