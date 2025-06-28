
package com.mycompany.week08;

/*
    Note: 
 */
public class Cube extends ThreeDimensionalShape{

    private double a;

    public Cube() {
    }

    public Cube(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }
    
    
    @Override
    public double getVolume() {
        return Math.pow(a, 3);
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(a, 2);
    }
}
