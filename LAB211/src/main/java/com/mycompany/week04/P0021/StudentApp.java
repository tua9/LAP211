/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04.P0021;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class StudentApp {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        int choice = -1;
        do
        {
            System.out.println("----- WELCOME TO STUDENT MANAGEMENT -----");
            String[] listOfOptions = {"Create", "Find and sort", "Update/Delete", "Report", "Exit"};
            try 
            {
                choice = getChoice(listOfOptions);
                switch(choice) 
                {
                    case 1 -> create();
                    case 2 -> findAndSort();
                    case 3 -> updateAndDelete();
                    case 4 -> StudentManagement.report();
                    case 5 -> System.out.println("End!");
                    default -> System.out.println("Invalid choice!");
                }
            } 
            catch(NumberFormatException e)
            {
                System.out.println("You must enter a number.");
            }
        } while(choice != 5);
        
        sc.close();
    }
    
    public static void create() {
        int count = 1;
        boolean _continue;
        System.out.println("\n----- Create Student (at least 3) -----");
        do {
            _continue = false;
            System.out.println("Student - " + count);
            
            String ID = Utils.readId(sc);
            if(ID == null) continue;
            
            String name = Utils.readString(sc,"name: ");
            if(StudentValidator.isBlank(name)) {
                System.out.println("Name cannot blank!");
                continue;
            }
            
            String courseStr = Utils.readString(sc, "Course (Java, .Net, C/C++): ");
            if(StudentValidator.isBlank(courseStr)) {
                System.out.println("course cannot blank!");
                continue;
            }
            
            ProgrammingLanguage course = ProgrammingLanguage.fromLabel(courseStr);
            
            if(course == null) {
                System.out.println("Invalid course!");
                continue;
            }
            
            StudentManagement.create(ID, name, course);
            count++;
            
            if (count > 3) _continue = isContinue(sc);
            
        } while (count < 4 || _continue);
    }
    
    public static boolean isContinue(Scanner sc) {
        while (true) {
            String input = Utils.readString(sc, "Do you want to continue (Y/N): ");
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }
    
    public static void findAndSort() {
        String name;
        System.out.println("\n----- Find And Sort -----");
        do {
            name = Utils.readString(sc, "name: ");
        }while(name.isEmpty());
        
        List<Student> listOfStudents = StudentManagement.findAndSort(name);
        
        if(listOfStudents.isEmpty()) {
            System.out.println(name + " not found!");
            return;
        }
        
        System.out.println("Found " + listOfStudents.size() + " " + name);
        StudentManagement.display(listOfStudents);
    }
    
    public static void updateAndDelete() {
        System.out.println("\n--------------- Update And Delete ---------------");
        
        String ID = Utils.readExistingStudentId(sc);
        if(ID == null) return;
        
        System.out.println(StudentManagement.getStudentMap().get(ID));
        
        int choice;
        String[] listOfOptions = {"Update", "Delete", "Exit"};
        
        do {
            choice = getChoice(listOfOptions);
            
            switch(choice) {
                case 1 -> update(ID);
                case 2 -> {
                    if(StudentManagement.deleteStudentByID(ID))
                        System.out.println("Delete Successful!");
                    else 
                        System.out.println("Delete failed!");
                }
                case 3 -> System.out.println("Exit Update And Delete!");
                default -> System.out.println("Input invalid!");
            }
        } while(choice != 3);
    }
    
    public static void update(String ID) {
        System.out.println("\n--------------- Update ---------------");
        int choice;
        String[] listOfOptions = {"Name", "Course", "Exit"};
        do {
            choice = getChoice(listOfOptions);
            
            switch(choice) {
                case 1 -> StudentManagement.updateStudentName(ID, sc);
                case 2 -> StudentManagement.updateStudentCourse(ID, sc);
                case 3 -> System.out.println("Exit Update!");
                default -> System.out.println("Input invalid!");
            }
        } while(choice != 3);
    }
    
    public static int getChoice(String[] listOfOptions) {
        for (int i = 0; i < listOfOptions.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), listOfOptions[i]);
        }
        return Integer.parseInt(Utils.readString(sc, "Your choice: "));
    }
}
