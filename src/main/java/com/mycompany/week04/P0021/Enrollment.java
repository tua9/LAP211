
package com.mycompany.week04.P0021;

public class Enrollment {

    private final String studentID;
    private final String courseID;
    private int attempt;
    private double score;
    private String state;
    
    public Enrollment(String studentID, String courseID, int attempt, double score, String state) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.attempt = attempt;
        this.score = score;
        this.state = state;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getCourseID() {
        return courseID;
    }
    

    public int getAttempt() {
        return attempt;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getState() {
        return state;
    }
    
    
    public void increaseAttempt() {
        this.attempt += 1;
    }

    public void setState(String state) {
        this.state = state;
    }
}
