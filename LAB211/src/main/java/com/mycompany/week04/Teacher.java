/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04;

/**
 *
 * @author LE ANH TUAN
 */
public class Teacher extends Person{
    public int yearInProfession;
    public String contractType;
    public double salaryCoefficient;
    
    public Teacher() {
        super();
        yearInProfession = 0;
        contractType = "";
        salaryCoefficient = 0f;
    }
    
    @Override
    public String toString() {
        return ID + " - " + fullName + " - " + phoneNumber + " - " + yearOB + " - " + major + " - " + yearInProfession + " - " + contractType + " - " + salaryCoefficient;
    }
}
