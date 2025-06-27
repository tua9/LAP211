/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week02;

/**
 *
 * @author LE ANH TUAN
 */
public class Circle implements IShape{
    
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.printf("Radius: %.1f\n", radius);
        System.out.printf("Area:%f\n", getArea());
        System.out.printf("Perimeter: %f\n", getPerimeter());
    }
    
}
