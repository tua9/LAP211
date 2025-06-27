
package DatabaseConnection;

import com.mycompany.week04.P0021.Enrollment;
import java.util.ArrayList;
import java.util.List;

/*
    Note: 
 */
public class EnrollmentDAO {
    
    private EnrollmentDAO(){}
    
    public static List<Enrollment> getListOfEnrollment(){
        String query = "SELECT * FROM ENROLLMENT";
        List<List<String>> data = DataProvider.Instance.executeQuery(query);
        
        List<Enrollment> listOfEnrollment = new ArrayList<>();
        for(List<String> row : data) {
            String sID = row.get(0);
            String cID = row.get(1);
            int attempt = Integer.parseInt(row.get(2));
            double score = Double.parseDouble(row.get(3));
            String result = row.get(4);
            listOfEnrollment.add(new Enrollment(sID, cID, attempt, score, result));
        }
        
        return listOfEnrollment;
    }
    public static void addEnrollmentToDatabase(Enrollment enrollment){
        String query = "INSERT INTO ENROLLMENT(studentID, courseID, attempt, score, result) VALUES(?, ?, ?, ?, ?);";
        DataProvider.Instance.executeNonQuery(query, 
                enrollment.getStudentID(), enrollment.getCourseID(), 
                enrollment.getAttempt(), enrollment.getScore(),
                enrollment.getState());
    }
    
    public static void deleteEnrollment(String ID){
        String query = "DELETE FROM ENROLLMENT WHERE studentID = ?";
        DataProvider.Instance.executeNonQuery(query, ID);
    }
}
