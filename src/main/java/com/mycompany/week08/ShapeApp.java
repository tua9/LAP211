
package com.mycompany.week08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Note: 
 */
public class ShapeApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Shape> shapes = new ArrayList<>();
   
    public static void run() {
        try {
            int choice = 0;
            while(choice != 8) {
                System.out.println("---- Shape App ----");
                System.out.println("1. Circle");
                System.out.println("2. Square");
                System.out.println("3. Triangle");
                System.out.println("4. Sphere");
                System.out.println("5. Cube");
                System.out.println("6. Tetrahedron");
                System.out.println("7. Show calculated shapes");
                System.out.println("8. Exit");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch(choice) {
                    case 1 -> createShape(1);
                    case 2 -> createShape(2);
                    case 3 -> createShape(3);
                    case 4 -> createShape(4);
                    case 5 -> createShape(5);
                    case 6 -> createShape(6);
                    case 7 -> showShapes();
                    case 8 -> System.out.println("Exit!");
                    default -> System.out.println("Data input is invalid");
                }
            }
        } catch(NumberFormatException e) {
            System.out.println("Input invalid!");
        }
    }
    
    public static void createShape(int choice) {
        Shape shape = switch (choice) {
            case 1 -> createCircle();
            case 2 -> createSquare();
            case 3 -> createTriangle();
            case 4 -> createSphere();
            case 5 -> createCube();
            case 6 -> createTetrahedron();
            default -> throw new IllegalArgumentException("Invalid shape choice: " + choice);
        };
        
        shapes.add(shape);
    }
    
    private static Shape createCircle() {
        System.out.print("Enter radius of Circle: ");
        double r = Double.parseDouble(sc.nextLine());
        return new Circle(r);
    }

    private static Shape createSquare() {
        System.out.print("Enter side of Square: ");
        double s = Double.parseDouble(sc.nextLine());
        return new Square(s);
    }

    private static Shape createTriangle() {
        System.out.print("Enter Side A: ");
        double A = Double.parseDouble(sc.nextLine());
        
        System.out.print("Enter Side B: ");
        double B = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Side C: ");
        double C = Double.parseDouble(sc.nextLine());
        return new Triangle(A, B, C);
    }

    private static Shape createSphere() {
        System.out.print("Enter radius of Sphere: ");
        double r = Double.parseDouble(sc.nextLine());
        return new Sphere(r);
    }

    private static Shape createCube() {
        System.out.print("Enter side of Cube: ");
        double s = Double.parseDouble(sc.nextLine());
        return new Cube(s);
    }

    private static Shape createTetrahedron() {
        System.out.print("Enter side of Tetrahedron: ");
        double s = Double.parseDouble(sc.nextLine());
        return new Tetrahedron(s);
    }
    
    public static void showShapes() {
        System.out.println("--- Shapes added ---");
        for(Shape s : shapes) {
            System.out.println(s);
        }
    }
}
