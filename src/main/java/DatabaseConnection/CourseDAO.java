
package DatabaseConnection;

import com.mycompany.week04.P0021.Course;
import com.mycompany.week04.P0021.ProgrammingLanguage;
import java.util.ArrayList;
import java.util.List;

/*
    Note: 
 */
public class CourseDAO {
    
    private CourseDAO(){}

    public static List<Course> getListOfCourse(){
        String query = "SELECT * FROM COURSE";
        List<List<String>> data = DataProvider.Instance.executeQuery(query);
        
        List<Course> listOfCourse = new ArrayList<>();
        for(List<String> row : data) {
            String ID = row.get(0);
            String courseName = row.get(1);
            ProgrammingLanguage lang = ProgrammingLanguage.fromLabel(courseName);
            listOfCourse.add(new Course(ID, lang));
        }
        
        return listOfCourse;
    }
    
    public static void addCourseToDatabase(Course course){
        String query = "INSERT INTO COURSE(ID, cName) VALUES(N'?', N'?');";
        DataProvider.Instance.executeNonQuery(query, course.getID(), course.getCourseName());
    }
    
    public static void deleteCourse(String ID){
        //delete by id
    }
}
