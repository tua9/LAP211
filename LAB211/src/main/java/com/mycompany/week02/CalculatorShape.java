/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week02;

import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class CalculatorShape {
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====Calculator Shape Program=====");
        double width = InputUtils.readDouble(scanner, "Please input side width of Rectangle:\n");
        double length = InputUtils.readDouble(scanner, "Please input side length of Rectangle:\n");
        double radius = InputUtils.readDouble(scanner, "Please input radius of Circle:\n");
        double sideA = InputUtils.readDouble(scanner, "Please input side A of Triangle:\n");
        double sideB = InputUtils.readDouble(scanner, "Please input side B of Triangle:\n");
        double sideC = InputUtils.readDouble(scanner, "Please input side C of Triangle:\n");
    
        Rectangle rec = new Rectangle(width, length);
        Circle cir = new Circle(radius);
        Triangle tri = new Triangle(sideA, sideB, sideC);
        rec.printResult();
        cir.printResult();
        tri.printResult();
    }
}
