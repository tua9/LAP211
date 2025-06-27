
package com.mycompany.week05;

import java.util.Scanner;

/*
    Note: 
 */
public class OnlineCourse extends Course{
    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }
    
    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        try{
            platform = Utils.getInput(sc, "Platform: ", COURSE_NAME);
            instructors = Utils.getInput(sc, "Instructors: ", COURSE_NAME);
            note = Utils.getInput(sc, "Note: ", COURSE_NAME);
        } catch(Exception e) {
            System.out.println("Input All OC -> Error -> " + e);
        }
    }
    
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    @Override
    public String toString() {
        return super.toString() + "-" + platform + "-" + instructors + "-" + note;
    }
}
