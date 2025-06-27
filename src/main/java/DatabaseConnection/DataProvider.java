package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DataProvider {

    public static DataProvider Instance = new DataProvider();

    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=FPTU;user=sa;password=123456789;encrypt=false";
    
    private DataProvider() {}

    public List<List<String>> executeQuery(String query, Object... params) {
        List<List<String>> data = new ArrayList<>();
        
        try(Connection connection = DriverManager.getConnection(url);
            PreparedStatement stm = connection.prepareStatement(query);) 
        {
            for(int i = 0; i < params.length; ++i)
                stm.setObject(i+1, params[i]);
            
            ResultSet resultSet = stm.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();
            int columnCount = meta.getColumnCount();
            
            while(resultSet.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; ++i)
                    row.add(resultSet.getString(i));
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println("Connect fail -> " + e);
        }
        
        return data;
    }
    
    public int executeNonQuery(String query, Object... params) {
        try(Connection connection = DriverManager.getConnection(url);
            PreparedStatement stm = connection.prepareStatement(query)) 
        {
            for(int i = 0; i < params.length; ++i)
                stm.setObject(i + 1, params[i]);
            
            int rowAffected = stm.executeUpdate();
            return rowAffected;
        } catch(SQLException e) {
            System.out.println("execute none query -> " + e);
        }
        return -1;
    }
    
    public static DataProvider getInstance() {
        return Instance != null ? Instance : new DataProvider();
    }
}
