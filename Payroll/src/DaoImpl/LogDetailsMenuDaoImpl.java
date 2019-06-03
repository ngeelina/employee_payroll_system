/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Controller.SQLConnect;
import Dao.LogDetailsMenuDao;
import Model.ResultSetTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Samir
 */
public class LogDetailsMenuDaoImpl implements LogDetailsMenuDao{

    @Override
    public ResultSetTableModel getlogdetails() {
        try{
            Connection conn = SQLConnect.getConnection();
            Statement stmt = null;
            
//            String sql = "SELECT username, concat(first_name,' ',middle_name,' ',last_name) "
//                    + "AS Fullname, login, logout FROM employees NATURAL JOIN users "
//                    + "NATURAL JOIN logdetails WHERE (logout IS NOT NULL) ORDER BY logout DESC";
            String sql = "SELECT * FROM logsdetails";
            stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            return new ResultSetTableModel(rs);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }    
    }
    
}
