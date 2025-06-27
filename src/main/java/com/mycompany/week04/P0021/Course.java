
package com.mycompany.week04.P0021;


public class Course {
    private final String ID;
    private final ProgrammingLanguage courseName;
    
    public Course(String ID, ProgrammingLanguage courseName) {
        this.ID = ID;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public ProgrammingLanguage getCourseName() {
        return courseName;
    }
}
