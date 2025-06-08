/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class PersonTeacherStudentManagement {
    private static final ArrayList<Teacher> teachers = new ArrayList<>();
    private static final ArrayList<Student> students = new ArrayList<>();

    private static final Scanner sc = new Scanner(System.in);

    public static void teacherManagement() {
        int choice;
        do {
            System.out.println("*** Teacher Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            String input = sc.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Invalid input!");
            }
            switch (choice) {
                case 1 -> inputTeachers();
                case 2 -> printTeachers();
                case 3 -> {
                    System.out.println("Exit Teacher Management...");
                }
                default -> {
                    System.out.println("Invalid choice!");
                }
            }
        } while (choice != 3);
    }

    private static void inputTeachers() {
        Teacher t = new Teacher();
        t.InputAll(sc);
        teachers.add(t);
    }

    private static void printTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers to print.");
            return;
        }
        
        teachers.sort((a, b) -> b.getYearInProfession() - a.getYearInProfession());
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year in the profession - Contract type - Salary coefficient");
        int index = 1;
        for (Teacher t : teachers) {
            System.out.print(index++);
            t.printPersonFull();
        }
    }

    public static void studentManagement() {
        int choice;
        do {
            System.out.println("*** Student Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            String input = sc.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Invalid input!");
            }
            switch (choice) {
                case 1 -> inputStudents();
                case 2 -> printStudents();
                case 3 -> {
                    System.out.println("Exit Student Management...");
                }
                default -> {
                    System.out.println("Invalid choice!");
                }
            }
        } while (choice != 3);
    }

    private static void inputStudents() {
        Student s = new Student();
        s.InputAll(sc);
        students.add(s);
    }

    private static void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to print.");
            return;
        }
        
        students.sort(Comparator.comparingInt(Student::getYearOfAdmission));
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year of admission - Entrance English score");
        int index = 1;
        for (Student s : students) {
            System.out.print(index++);
            s.printPersonFull();
        }
    }

    public static void personManagement() {
        int choice;
        do {
            System.out.println("*** Person Management ***");
            System.out.println("1. Search");
            System.out.println("2. Print all");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            String input = sc.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Invalid input!");
            }
            switch (choice) {
                case 1 -> searchPersonByName();
                case 2 -> printAllPersons();
                case 3 -> {
                    System.out.println("Exit Person Management...");
                }
                default -> {
                    System.out.println("Invalid choice!");
                }
            }
        } while (choice != 3);
    }

    private static void searchPersonByName() {
        System.out.print("Name: ");

        String name = sc.nextLine().trim();
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.addAll(teachers);
        allPersons.addAll(students);

        List<Person> filtered = new ArrayList<>();
        
        for (Person p : allPersons) {
            if (p.getFullName().toLowerCase().contains(name.toLowerCase())) {
                filtered.add(p);
            }
        }
        
        if (filtered.isEmpty()) {
            System.out.println("Result: not found");
            return;
        }
        
        filtered.sort((a, b) -> b.getYearOfBirth() - a.getYearOfBirth());
        
        System.out.println("Result:");
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");
        
        int idx = 1;
        for (Person p : filtered) {
            System.out.printf("%d", idx++);
            p.printPersonBasic();
        }
    }

    private static void printAllPersons() {
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.addAll(teachers);
        allPersons.addAll(students);
        
        allPersons.sort((a, b) -> b.getYearOfBirth() - a.getYearOfBirth());
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");
        int idx = 1;
        for (Person p : allPersons) {
            System.out.printf("%d", idx++);
            p.printPersonBasic();
        }
    }

    public static void run() {
        int mainChoice;
        do {
            System.out.println("*** Information Management ***");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Person");
            System.out.println("4. Exit");
            System.out.print("You choose: ");
            String input = sc.nextLine().trim();
            try {
                mainChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                mainChoice = 0;
                continue;
            }

            switch (mainChoice) {
                case 1 -> teacherManagement();
                case 2 -> studentManagement();
                case 3 -> personManagement();
                case 4 -> System.out.println("BYE AND SEE YOU NEXT TIME");
                default -> {
                    System.out.println("Invalid choice!");
                }
            }
        } while (mainChoice != 4);
    }
}

