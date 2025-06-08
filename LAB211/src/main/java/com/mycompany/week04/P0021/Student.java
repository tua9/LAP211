/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week04.P0021;

/**
 *
 * @author LE ANH TUAN
 */
public class Student {
    private final String ID;
    private String name;
    private int Semester;
    private ProgrammingLanguage course;

    public Student(String ID, String name, ProgrammingLanguage course) {
        this.ID = ID;
        this.name = name;
        this.course = course;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgrammingLanguage getCourse() {
        return course;
    }

    public void setCourse(ProgrammingLanguage course) {
        this.course = course;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }
    
    @Override
    public String toString() {
        return ID + " - " + name + " - " + course;
    }
}
