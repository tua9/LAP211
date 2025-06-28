
package com.mycompany.week08;

/*
    Note: 
 */
public class Sphere extends ThreeDimensionalShape{

    private double radius;

    public Sphere() {
    }

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
    @Override
    public double getVolume() {
        return Math.PI * 4 * radius * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * 4/3 * Math.pow(radius, 3);
    }

}
