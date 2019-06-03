/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Samir
 */
public class SQLConnect {
    static String url = "jdbc:mysql://localhost:3306/payrolldb";
    static String driver = "com.mysql.jdbc.Driver";
    static String userName = "root";
    static String password = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
        return conn;
        }
        return conn;
    }
}
