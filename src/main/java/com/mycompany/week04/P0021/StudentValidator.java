package com.mycompany.week04.P0021;

class StudentValidator {
    public static boolean isValidID(String ID) {
        return ID != null && ID.matches("^[a-zA-Z]{2}\\d{6}$");
    }
    
    public static boolean isExistID(String ID) {
        return StudentManagement.getStudentByID(ID) != null;
    }
    
    public static boolean isExistStudent(String ID, String name) {
        for (Student student : StudentManagement.getListOfStudent())
            if(student.getID().equals(ID) && student.getName().equals(name))
                return true;
        return false;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
