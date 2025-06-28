
package com.mycompany.week08;

/*
    Note: 
 */
public class Square extends TwoDimensionalShape{
    private double side;

    public Square() {
    }
    
    public Square(double side) {
        this.side = side;
    }
    
    public void setSide(double side) {
        this.side = side;
    }
    
    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
