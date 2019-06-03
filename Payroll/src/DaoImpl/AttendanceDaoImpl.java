/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Controller.SQLConnect;
import Dao.AttendanceDao;
import Model.ResultSetTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class AttendanceDaoImpl implements AttendanceDao{

    Connection con = null;
    Statement stmt = null;
    
    @Override
    public int record(String emp_bar, String date) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT emp_ID FROM employees WHERE emp_bar = '"+emp_bar+"' AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();
            
            if (recordfound){
                String emp_ID = rs.getString("emp_ID");
                sql = "SELECT * FROM attendance  WHERE emp_ID = '"+emp_ID+"' "
                        + "AND date = '"+date+"' AND status = '"+"0"+"'";
                stmt = con.createStatement();
                stmt.execute(sql);
                rs = stmt.getResultSet();
                recordfound = rs.next();
                if (recordfound){
                    con.close();
                    return 2;
                }
                else{
                    sql = "INSERT INTO attendance(emp_ID,date) VALUES (?,?)";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, emp_ID);
                    st.setString(2, date);
                    st.executeUpdate();
                    con.close();
                    return 1;
                }
            }
            else{
                con.close();
                return 0;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 3;
        }
    }

    @Override
    public int view(String emp_bar) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT emp_ID FROM employees WHERE emp_bar = '"+emp_bar+"' AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();
            
            if (recordfound){
                String emp_ID = rs.getString("emp_ID");
                sql = "SELECT COUNT(*) AS total FROM attendance  WHERE emp_ID = '"+emp_ID+"' "
                        + "AND status = '"+"0"+"'";
                stmt = con.createStatement();
                stmt.execute(sql);
                rs = stmt.getResultSet();
                if(rs.next()==true){
                    int total = rs.getInt("total");
                    con.close();
                    return total;
                }
                else{
                    con.close();
                    return 0;
                }
                
            }
            else{
                con.close();
                return -1;
            }
        }catch(Exception ex){
            System.out.println("fail"+ex.getMessage());
            return -2;
        }
    }

    @Override
    public ArrayList<String> fromto(String emp_bar) {
        ArrayList<String> result = new ArrayList<>();
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT emp_ID,designation FROM employees WHERE emp_bar = '"+emp_bar+"' AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();
            
            if (recordfound){
                String emp_ID = rs.getString("emp_ID");
                String desig = rs.getString("designation");
                sql = "SELECT date FROM attendance  WHERE emp_ID = '"+emp_ID+"' "
                        + "AND status = '"+"0"+"' ORDER BY date";
                stmt = con.createStatement();
                stmt.execute(sql);
                rs = stmt.getResultSet();
                rs.next();
                result.add(rs.getString("date"));
                rs.afterLast();
                rs.previous();
                result.add(rs.getString("date"));
                
                result.add(desig);
                con.close();
                return result;
            }
            else{
                con.close();
                result.add(0, "no");
                return result;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            result.add(0, "error");
            return result;
        }
    }

    public String present(String emp_bar) {
        String result = null;
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT COUNT(*) AS present FROM attendance  WHERE emp_ID = '"+emp_bar+"' "
                        + "AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            rs.next();
            result = rs.getString("present");
            con.close();
            return result;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return result;
        }
    }
    
    public void setupdate(String emp_bar) {
        try{
            con = SQLConnect.getConnection();
            String sql = "UPDATE attendance SET status = '"+"1"+"' WHERE emp_ID = '"+emp_bar+"'";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);
            con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public ResultSetTableModel att_record() {
        try{
            Connection conn = SQLConnect.getConnection();
            Statement stmt = null;
            String sql = "SELECT emp_ID, concat(first_name,' ',middle_name,' ',last_name) "
                    + "AS Fullname, date FROM employees NATURAL JOIN attendance ";
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
