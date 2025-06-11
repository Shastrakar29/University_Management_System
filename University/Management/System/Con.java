package University.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Con {
    public Connection connection;
    public Statement statement;

    public Con() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/university_management", "root", "4567");

            statement = connection.createStatement();
            System.out.println("✅ Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Con();
    }
}




