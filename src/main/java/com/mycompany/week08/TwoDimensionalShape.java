/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.week08;

/**
 *
 * @author LE ANH TUAN
 */
public abstract class TwoDimensionalShape implements Shape{
    @Override
    public String toString() {
        return getClass().getSimpleName() + " ->  Area = " + getArea();
    }
}
