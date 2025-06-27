
package com.mycompany.week05;

import java.util.Scanner;

/*
    Note: 
 */
public class Course {
    public static final String COURSE_KIND = "^[OF]$";
    public static final String COURSE_ID = "^.+$";
    public static final String COURSE_NAME = "^[A-Za-z0-9 \\-]+$";
    public static final String COURSE_CREDITS = "^[1-9]\\d*$";
    public static final String STRING_EMPTY = "^.*$";
    
    String courseID;
    String courseName;
    int credits;

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }
    
    public void inputAll(Scanner sc) {
        try{
            boolean isValidCourseID = false;
            
            while(!isValidCourseID) {
                courseID = Utils.getInput(sc, "Course ID: ", COURSE_ID);
                isValidCourseID = CourseValidator.isValidID(courseID);
                if(!isValidCourseID) {
                    System.out.println("Data input is invalid, ID must be unique");
                }
            }
            
            courseName = Utils.getInput(sc, "Course Name: ", COURSE_NAME);
            String creditStr = Utils.getInput(sc, "Credits: ", COURSE_CREDITS);
            credits = Integer.parseInt(creditStr);
        } catch (NumberFormatException e) {
            System.out.println("Input All -> Error -> " + e);
        }
    }
    
    public void setCourseID(String ID) {
        courseID = ID;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    @Override
    public String toString() {
        return courseID + "-" + courseName + "-" + credits;
    }
}
