package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    private static final String DB_NAME = "ems";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    
    private static Connection connection;
    static DatabaseConnection instance;
    
    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public ResultSet selectQueryBuilder(String query){
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    // here iud stands for i = insert, u = update & d = delete
    // this method will build insert, update & delete query
    public int iudQueryBuilder(String query){
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
