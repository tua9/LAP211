/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04.P0021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class StudentManagement {
    private static final Map<String, Student> studentMap = new HashMap<>();
    
    public static void create(String ID, String name, ProgrammingLanguage course) {
        studentMap.put(ID, new Student(ID, name, course));
    }
    
    public static List<Student> findAndSort(String name) {
        List<Student> listOfStudents;
        
        listOfStudents = findByName(name);
        
        if(listOfStudents.isEmpty()) return null;
        
        sortByName(listOfStudents);
        
        return listOfStudents;
    }
    
    public static List<Student> findByName(String name) {
        List<Student> listOfStudents = new ArrayList<>();
        for (Student student : studentMap.values()) {
            if (student.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                listOfStudents.add(student);
            }
        }
        return listOfStudents;
    }
    
    public static void sortByName(List<Student> result) {
        result.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
    }
    
    public static void updateStudentName(String ID, Scanner sc) {
        String newName = Utils.readString(sc, "new name: ");
        if(StudentValidator.isBlank(newName)) {
            System.out.println("Name is blank!");
            return;
        }
        studentMap.get(ID).setName(newName);
    }
    
    public static void updateStudentCourse(String ID, Scanner sc) {
        String courseStr = Utils.readString(sc, "new course: ");
        if(StudentValidator.isBlank(courseStr)) {
            System.out.println("Course is blank!");
            return;
        }
        
        ProgrammingLanguage newCourse = ProgrammingLanguage.fromLabel(courseStr);
        if(newCourse == null) {
            System.out.println("Invalid course!");
            return;
        }
        
        studentMap.get(ID).setCourse(newCourse);
    }
    
    public static boolean deleteStudentByID(String ID) {
        ID = ID.trim().toUpperCase();
        if (studentMap.containsKey(ID)) {
            studentMap.remove(ID);
            return true; 
        }
        return false;
    }
    
    public static void report() {
        List<Student> students = new ArrayList<>(studentMap.values());
        System.out.println("------------------- Report -------------------");
        display(students);
    }
    
    public static void display(List<Student> students) {
        String prompt = "%-14s %-30s %-10s";
        String header = Utils.format(prompt, "ID", "Name", "Course");
        System.out.println(header);
        
        for(Student s : students) {
            String data = Utils.format(prompt, s.getID(), s.getName(), s.getCourse());
            System.out.println(data);
        }
    }
    
    public static Map<String, Student> getStudentMap() {
        return studentMap;
    }
}
