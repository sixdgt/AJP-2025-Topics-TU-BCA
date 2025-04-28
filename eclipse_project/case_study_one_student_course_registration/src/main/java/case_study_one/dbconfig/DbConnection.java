package case_study_one.dbconfig;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class DbConnection {
	private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    private static final String DB_NAME = "case_study_one";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    
    private static Connection connection;
    static DbConnection instance;
    
    public DbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static DbConnection getInstance(){
        if(instance == null){
            instance = new DbConnection();
        }
        return instance;
    }
}
