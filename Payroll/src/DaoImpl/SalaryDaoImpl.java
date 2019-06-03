/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Controller.SQLConnect;
import Dao.SalaryDao;
import Model.ResultSetTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sam
 */
public class SalaryDaoImpl implements SalaryDao{

    Connection con = null;
    Statement stmt = null;
    
    @Override
    public void setupdate(String emp_ID, String sal_from, String sal_to, String sal_date, String holding_amt) {
        try{
            con = SQLConnect.getConnection();
            String sql = "INSERT INTO salary(emp_ID,sal_from,sal_to,sal_date,holding_amt) VALUES(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, emp_ID);
                st.setString(2, sal_from);
                st.setString(3, sal_to);
                st.setString(4, sal_date);
                st.setString(5, holding_amt);
                
                st.executeUpdate();
                con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public ResultSetTableModel sal_record() {
        try{
            Connection conn = SQLConnect.getConnection();
            Statement stmt = null;
            String sql = "SELECT emp_ID, concat(first_name,' ',middle_name,' ',last_name) "
                    + "AS Fullname, sal_from AS 'Paid From', sal_to AS 'Paid Till', sal_date AS 'Date taken', "
                    + "holding_amt AS Holdings FROM employees NATURAL JOIN salary ";
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
