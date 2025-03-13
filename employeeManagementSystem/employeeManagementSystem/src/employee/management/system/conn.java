package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

public class conn {
    Connection connection;
    java.sql.Statement statement;


    public conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagementSystem", "root", "");
            statement = connection.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
