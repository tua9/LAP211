
package com.mycompany.week05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/*
    Note: 
 */
public class CourseValidator {
    
    public static final String TIME_PATTERN = "^([1-9]|[12]\\d|3[01])/([1-9]|1[0-2])/(\\d{4})$";
    
    private CourseValidator(){}
    
    public static boolean isValidID(String courseID) {
        for(Course c: CourseManagement.Instance.getCourses())
            if(c.getCourseID().equals(courseID)) return false;
        return true;
    }
    
    public static boolean isUnique(String nameCourse) {
        return true;
    }
    
    public static boolean isValidTimeStr(String str) {
        return str.matches(TIME_PATTERN);
    }
}
