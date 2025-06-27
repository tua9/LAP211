/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04.P0021;

import DatabaseConnection.CourseDAO;
import DatabaseConnection.EnrollmentDAO;
import DatabaseConnection.StudentDAO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LE ANH TUAN
 */
public class StudentManagement {

    private static List<Student> listOfStudent = new ArrayList<>();
    private static List<Course> listOfCourse = new ArrayList<>();
    private static List<Enrollment> listOfEnrollment = new ArrayList<>();
    
    public static void create(String sID, String name, ProgrammingLanguage lang) {
        Course course = getCourseByName(lang);
        if(course == null) {
            System.out.println("create Fail");
            return;
        }
        createStudent(sID, name);
        createEnrollment(sID, course);
    }
    
    public static void createStudent(String sID, String name) {
        Student student = new Student(sID, name);
        listOfStudent.add(student);
        StudentDAO.addStudentToDatabase(student);
    }
    
    public static void createEnrollment(String sID, Course course) {
        String cID = course.getID();
        Enrollment enrollment = new Enrollment(sID, cID, 1, 0, "in progress");
        listOfEnrollment.add(enrollment);
        EnrollmentDAO.addEnrollmentToDatabase(enrollment);
    }
    
    public static List<Student> findAndSort(String name) {
        List<Student> listOfStudents = findByName(name);
        
        if(listOfStudents.isEmpty()) return null;
        sortByName(listOfStudents);
        
        return listOfStudents;
    }
    
    public static List<Student> findByName(String name) {
        List<Student> students = new ArrayList<>();
        for (Student student : listOfStudent) {
            if (student.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                students.add(student);
            }
        }
        
        return students;
    }
    
    public static Student findByID(String ID) {
        for (Student student : listOfStudent)
            if (student.getID().contains(ID.toUpperCase().trim())) {
                return student;
            }
        
        return null;
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
        
        findByID(ID).setName(newName);
        StudentDAO.updateStudentNameByID(newName, ID);
    }
    
    public static void deleteStudent(String ID) {
        listOfEnrollment.removeIf(enrollment -> enrollment.getStudentID().equals(ID));
        EnrollmentDAO.deleteEnrollment(ID);
        
        listOfStudent.removeIf(student -> student.getID().equals(ID));
        StudentDAO.deleteStudent(ID);
    }
    
    public static Student getStudentByID(String ID) {
        for (Student s : listOfStudent) {
            if (s.getID().equals(ID))
                return s;
        }
        return null;
    }
    
    
    public static Course getCourseByName(ProgrammingLanguage course) {
        for (Course c : listOfCourse) {
            if (c.getCourseName().equals(course))
                return c;
        }
        return null;
    }
    
    public static Course getCourseByID(String ID) {
        for (Course c : listOfCourse) {
            if (c.getID().equals(ID))
                return c;
        }
        return null;
    }
    
    public static void loadData() {
        listOfStudent = StudentDAO.getListOfStudent();
        listOfCourse = CourseDAO.getListOfCourse();
        listOfEnrollment = EnrollmentDAO.getListOfEnrollment();
    }
    
    private static List<Enrollment> getEnrollmentBySID(String sID) {
        List<Enrollment> enrollments = new ArrayList<>();
        for(Enrollment enrollment : listOfEnrollment) {
            if(enrollment.getStudentID().equals(sID))
            {
                enrollments.add(enrollment);
            }
        }
        
        return enrollments;
    } 
    
    public static void report() {
        System.out.println("------------------------ Report ------------------------");
        display(listOfStudent);
    }
    
    public static void display(List<Student> students) {
        String prompt = "%-14s %-25s %-10s %-10s";
        String header = Utils.format(prompt, "ID", "Name", "Course", "Attempt");
        System.out.println(header);
        
        for(Student s : students) {
            String sID = s.getID();
            String sName = s.getName();
            List<Enrollment> enrollments = getEnrollmentBySID(sID);
            for(Enrollment enrollment : enrollments) {
                String cID = enrollment.getCourseID();
                String cName = getCourseByID(cID).getCourseName().toString();
                int attempt = enrollment.getAttempt();
                String data = Utils.format(prompt, sID, sName, cName, attempt);
                System.out.println(data);
            }
        }    
    }
   
    public static List<Student> getListOfStudent() {
        return listOfStudent;
    }

    public static List<Course> getListOfCourse() {
        return listOfCourse;
    }

    public static List<Enrollment> getListOfEnrollment() {
        return listOfEnrollment;
    }
}
