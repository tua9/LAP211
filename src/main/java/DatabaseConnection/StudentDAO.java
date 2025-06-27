
package DatabaseConnection;

import com.mycompany.week04.P0021.Student;
import java.util.ArrayList;
import java.util.List;

/*
    Note: 
 */
public class StudentDAO {
    
    private StudentDAO(){}
    
    public static List<Student> getListOfStudent(){
        String query = "SELECT * FROM STUDENT";
        List<List<String>> data = DataProvider.Instance.executeQuery(query);
        
        List<Student> listOfStudent = new ArrayList<>();
        for(List<String> row : data) {
            String ID = row.get(0);
            String name = row.get(1);
            listOfStudent.add(new Student(ID, name));
        }
        
        return listOfStudent;
    }
    
    public static void addStudentToDatabase(Student student){
        String query = "INSERT INTO STUDENT(ID, sName) VALUES(?, ?);";
        DataProvider.Instance.executeNonQuery(query, student.getID(), student.getName());
    }
    
    public static void updateStudentNameByID(String name, String ID) {
        String query = "UPDATE STUDENT SET sName = ? WHERE ID = ?;";
        DataProvider.Instance.executeNonQuery(query, name, ID);
    }
    
    public static void deleteStudent(String ID){
        String query = "DELETE FROM STUDENT WHERE ID = ?";
        DataProvider.Instance.executeNonQuery(query, ID);
    }
}
