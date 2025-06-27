
package com.mycompany.week05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Note: 
 */
public class CourseManagement {
    public static CourseManagement Instance = new CourseManagement();
    private final List<Course> courses = new ArrayList<>();

    private final Scanner sc = new Scanner(System.in);

    private CourseManagement() {}
    
    public void run() {
        String menu = """
                      
                      *** Course Management ***
                      1. Add online course/ offline course
                      2. Update course
                      3. Delete course
                      4. Print all / online course / offline course
                      5. Search information base on course name
                      6. Exit
                      you choose: """;
        
        int choice;
        do {
            String choiceStr = Utils.getInput(sc, menu, "^[1-6]$");
            choice = Integer.parseInt(choiceStr);
            switch(choice) {
                case 1 -> addNewCourse();
                case 2 -> updateCourse();
                case 3 -> deleteCourse();
                case 4 -> printCourse();
                case 5 -> searching();
            }
        } while(choice != 6);
        System.out.println("BYE AND SEE YOU NEXT TIME");
    }
    
    
    public void addNewCourse(){
        System.out.println("*** Add new course ***");
        String prompt = "Online (O) or Offline (F): ";

        String choice = Utils.getInput(sc, prompt, Course.COURSE_KIND);
        switch(choice) {
            case "O" -> createNewCourse(new OnlineCourse());
            case "F" -> createNewCourse(new OfflineCourse());
        }
    }
    
    public void updateCourse() {
        System.out.println("*** Update course ***");
        boolean isValidCourseID = true;
        while(isValidCourseID) {
            String courseID = Utils.getInput(sc, "Course ID: ", Course.COURSE_ID);
            isValidCourseID = CourseValidator.isValidID(courseID);
            if(isValidCourseID) {
                String choice = Utils.getInput(sc, "No data found, do you want to find again? (Y/N): ", "^[YN]$");
                if(choice.equals("N")) break;
            } else {
                Course course = searchByID(courseID);
                searchResults(course);
                update(course);
            }
        }
    }
    
    public void deleteCourse() {
        System.out.println("*** Delete course ***");
        boolean isValidCourseID = true;
        while(isValidCourseID) {
            String courseID = Utils.getInput(sc, "Course ID: ", Course.COURSE_ID);
            isValidCourseID = CourseValidator.isValidID(courseID);
            if(isValidCourseID) {
                String choice = Utils.getInput(sc, "No data found, do you want to find again? (Y/N): ", "^[YN]$");
                if(choice.equals("N")) break;
            } else {
                Course course = searchByID(courseID);
                delete(course);
            }
        }
    }
    
    public boolean delete(Course course) {
        return courses.remove(course);
    }
    
    public Course searchByID(String courseID) {
        for(Course c : courses) 
            if(c.getCourseID().equals(courseID))
                return c;
        return null;
    }
    
    public void searchResults(Course c) {
        System.out.println("*** Search results ***");
        System.out.println("Course ID: " + c.getCourseID());
        System.out.println("Course name: " + c.getCourseName());
        System.out.println("Credits: " + c.getCredits());
        if(c instanceof OnlineCourse onlineCourse) {
            
            System.out.println("Platform: " + onlineCourse.getPlatform());
            System.out.println("Instructors: " + onlineCourse.getInstructors());
            System.out.println("Note: " + onlineCourse.getNote());
        } else {
            System.out.println("Begin: " + ((OfflineCourse) c).getBegin());
            System.out.println("End: " + ((OfflineCourse) c).getEnd());
            System.out.println("Campus: " + ((OfflineCourse) c).getCampus());
        }
    }
    
    public void createNewCourse(Course course) {
        System.out.println("Create new online course");
        course.inputAll(sc);
        courses.add(course);
    }
    
    public void update(Course course) {
        System.out.println("*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");
       
        String str;
        
        str = Utils.getInput(sc, "Course ID: ", Course.STRING_EMPTY);
        if(!str.isEmpty())
            course.setCourseID(str);
        
        str = Utils.getInput(sc, "Course name: ", Course.STRING_EMPTY);
        if(!str.isEmpty())
            course.setCourseName(str);
        
        boolean isValidCredits = false;
        while(!isValidCredits) {
            try {
                str = Utils.getInput(sc, "Credits: ", Course.STRING_EMPTY);
                if(str.isEmpty()) break;
                int credits = Integer.parseInt(str);
                if(credits < 0) {
                    isValidCredits = false;
                    System.out.println("Data input is invalid, credits > 0");
                } else
                    course.setCredits(credits);
            } catch(NumberFormatException e) {
                System.out.println("Data input is invalid!");
            }
        }
        
        if(course instanceof OnlineCourse onlineCourse) {
            str = Utils.getInput(sc, "Platform: ", Course.STRING_EMPTY);
            if(!str.isEmpty())
                onlineCourse.setPlatform(str);
            
            str = Utils.getInput(sc, "Instructors: ", Course.STRING_EMPTY);
            if(!str.isEmpty())
                onlineCourse.setInstructors(str);
            
            str = Utils.getInput(sc, "Note: ", Course.STRING_EMPTY);
            if(!str.isEmpty())
                onlineCourse.setNote(str);
        }
        
        if(course instanceof OfflineCourse offlineCourse) {
            boolean isValidBegin = false;
            boolean isValidEnd = false;
            LocalDate begin = LocalDate.now(), end;
            
            while(!isValidBegin) {
                str = Utils.getInput(sc, "Begin: ", Course.STRING_EMPTY);
                if(str.isEmpty()) break;
                isValidBegin = CourseValidator.isValidTimeStr(str);
                if(isValidBegin) {
                    begin = Utils.convertStringToLCDate(str);
                    if(begin.isAfter(LocalDate.now())) 
                        offlineCourse.setBegin(begin);
                } else {
                    System.out.println("Data input is invalid");
                }
            }
            
            while(!isValidEnd) {
                str = Utils.getInput(sc, "End: ", Course.STRING_EMPTY);
                if(str.isEmpty()) break;
                isValidEnd = CourseValidator.isValidTimeStr(str);
                if(isValidBegin) {
                    end = Utils.convertStringToLCDate(str);
                    if(begin.isBefore(end)) 
                        offlineCourse.setEnd(end);
                } else {
                    System.out.println("Data input is invalid");
                }
            }
            
            str = Utils.getInput(sc, "Campus: ", Course.STRING_EMPTY);
            if(!str.isEmpty())
                offlineCourse.setCampus(str);
        }
    }
    
    public void printCourse() {
        System.out.println("*** Print course ***");
        String choice = Utils.getInput(sc, "Do you want to print all (A), online course (O) or offline course (F): ", "^[AOF]$");
        switch(choice) {
            case "A" -> printAllCourses();
            case "O" -> printOnlineCourse();
            case "F" -> printOfflineCourse();
        }
    }
    
    public void searching() {
        System.out.println("*** Searching ***");
        boolean isNotExistCourseID = true;
        while(isNotExistCourseID) {
            String courseID = Utils.getInput(sc, "Course ID: ", Course.COURSE_ID);
            isNotExistCourseID = CourseValidator.isValidID(courseID);
            if(isNotExistCourseID) {
                String choice = Utils.getInput(sc, "No data found, do you want to find again? (Y/N): ", "^[YN]$");
                if(choice.equals("N")) break;
            } else {
                Course course = searchByID(courseID);
                searchResults(course);
            }
        }
    }

    public void printAllCourses() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }
    
    public void printOnlineCourse() {
        System.out.println("Course ID-Course Name-Credits-Platform-Instructors-Note");
        for(Course c : courses) {
            if(c instanceof OnlineCourse onlineCourse)
                System.out.println(onlineCourse);
        }
    }
    
    public void printOfflineCourse() {
        System.out.println("Course ID-Course Name-Credits-Begin-End-Campus");
        for(Course c : courses) {
            if(c instanceof OfflineCourse offlineCourse)
                System.out.println(offlineCourse);
        }
    }

    public void searchByName(String keyword) {
        boolean found = false;
        System.out.println("\nSearch results for: " + keyword);
        for (Course c : courses) {
            if (c.getCourseName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No suitable courses could be found.");
        }
    }
    
    public List<Course> getCourses() {
        return courses;
    }
    
    public static CourseManagement getInstance() {
        if(Instance == null) Instance = new CourseManagement();
        return Instance;
    }
}
