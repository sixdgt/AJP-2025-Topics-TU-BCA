package main;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseConnectionExample {
    public static void main(String[] args) {
        try {
            // Step 1: loading/installing jdbc Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // in exam mention both old and latest version for old version
            // Class.forName("com.mysql.jdbc.Driver");
            String db_name = "jdbc_example";
            String user = "root";
            String password = "1234";
            String url = "jdbc:mysql://localhost:3306/" + db_name;
            // Step 2: creating connection
            Connection con = DriverManager.getConnection(url, user, password);
            // Step 3: creating statement
            Statement stmt = con.createStatement();
            // Step 4: prepare sql query
            String query = "INSERT INTO item(`item_title`, `item_price`,"
                    + " `item_category`, `item_desc`) "
                    + "VALUES('Gaming Chair', 15000.00, 'Computer Accessories', 'Flexible Chair')";
            // Step 5: executing sql query
            // in case of insert, update and delete
            if(stmt.executeUpdate(query) > 0){
                System.out.println("Data inserted successfully!!");
            } else {
                System.out.println("Something went wrong!!");
            }
            // in case of select query
            String select_query = "SELECT * FROM item";
            ResultSet rs = stmt.executeQuery(select_query);
            // use loop to display data or manipulate the data
            while(rs.next()){
                System.out.println("Item ID: " + rs.getInt("id"));
                System.out.println("Item Title: " + rs.getString("item_title"));
                System.out.println("Item Price: " + rs.getDouble("item_price"));
                System.out.println("Item Category: " + rs.getString("item_category"));
                System.out.println("Item Description: " + rs.getString("item_desc"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
