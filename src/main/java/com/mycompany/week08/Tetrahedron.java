
package com.mycompany.week08;

/*
    Note: 
 */
public class Tetrahedron extends ThreeDimensionalShape{
    private double side;

    public Tetrahedron() {
    }

    public Tetrahedron(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3) / 6 / Math.sqrt(2);
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * Math.pow(side, 2);
    }
}
