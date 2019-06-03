/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Controller.SQLConnect;
import Dao.UsersDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Samir
 */
public class UsersDaoImpl implements UsersDao{

    Connection con = null;
    Statement stmt = null;
    
    @Override
    public int isValidUser(String username, String password, String type) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM users WHERE username='"+username+"' AND "
                    + "password = '"+password+"' AND type = '"+type+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();

            boolean recordfound = rs.next();

            if (recordfound){
                if ("Admin".equals(rs.getString("type"))){
                    con.close();
                    return 1;
                }
                else{
                    con.close();
                    return 2;
                }
            }
            else{
                con.close();
                return 0;
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public int changepass(String username, String password, String newpass) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM users WHERE username = '"+username+"' AND password = '"+password+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();

            boolean recordfound = rs.next();

            if (recordfound){
                sql = "UPDATE users SET password = '"+newpass+"' WHERE username = '"+username+"'";
                stmt = con.createStatement();
                stmt.executeUpdate(sql);
                return 1;
            }
            else{
                return 0;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 2;
        }
    }

    public String giveuser(String username) {
        String result = null;
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT first_name FROM employees NATURAL JOIN users WHERE username = '"+username+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();

            if (recordfound){
                result = rs.getString("first_name");
                return result;
            }
            else{
                return result;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return result;
        }
    }
    
}
