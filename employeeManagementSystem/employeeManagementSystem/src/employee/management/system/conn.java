package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class conn {
    Connection connection;
    java.sql.Statement statement;

    public conn() {
        try {
            Properties props = new Properties();
            // Load from classpath
            InputStream is = ClassLoader.getSystemResourceAsStream("config.properties");
            if (is == null) {
                // Fallback to file system if not found in classpath
                is = new FileInputStream("src/config.properties");
            }
            props.load(is);

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.username"),
                    props.getProperty("db.password"));
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
