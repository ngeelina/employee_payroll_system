/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Controller.SQLConnect;
import Dao.LogDetailsDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Samir
 */
public class LogDetailsDaoImpl implements LogDetailsDao{

    Connection con = null;
    Statement stmt = null;
        
    @Override
    public void setlogin(String username) {
        try{
            con = SQLConnect.getConnection();
            String sql = "INSERT INTO logDetails (username) " + "VALUES ('" + username + "')";
            try {
                stmt = con.createStatement();
                stmt.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                con.close();
                System.out.println(ex.getMessage());
            }
        }
        catch(Exception ex)
        {
             System.out.println(ex.getMessage());
        }    
    }

    @Override
    public void setlogout(String date) {
        try{
            con = SQLConnect.getConnection();
            String sql = "UPDATE logDetails SET logout = '" + date + "' WHERE Logout is null";
            try {
                stmt = con.createStatement();
                stmt.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                con.close();
                System.out.println(ex.getMessage());
            }
        }
        catch(Exception ex)
        {
             System.out.println(ex.getMessage());
        }    
    }
    
}
