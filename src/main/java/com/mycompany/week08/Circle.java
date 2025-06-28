
package com.mycompany.week08;

/*
    Note: 
 */
public class Circle extends TwoDimensionalShape{
    private double radius;

    public Circle() {}
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
}
