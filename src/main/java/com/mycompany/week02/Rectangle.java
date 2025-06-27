/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week02;

/**
 *
 * @author LE ANH TUAN
 */
public class Rectangle implements IShape{
    private double width, length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    
    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.printf("Width: %.1f\nLength: %.1f\nArea: %.1f\nPerimeter: %.1f\n",
            width, length, getArea(), getPerimeter());
        
    }
    
}
