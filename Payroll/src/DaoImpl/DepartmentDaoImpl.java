/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Controller.SQLConnect;
import Dao.DepartmentDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class DepartmentDaoImpl implements DepartmentDao{

    Connection con = null;
    Statement stmt = null;
    
    @Override
    public ArrayList<String> give_dept() {
        ArrayList<String> dept = new ArrayList<String>();
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT dept_name FROM department WHERE status = '"+"0"+"' "
                    + "ORDER BY dept_name";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) { 
                String temp_dept = rs.getString("dept_name");
                dept.add(temp_dept);
            }
            con.close();
            return dept;
        }
        catch(Exception ex)
        {
             System.out.println(ex.getMessage());
             return dept;
        }
    }

    public int add(String dept_name, String dept_no) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM department WHERE (dept_name = '"+dept_name+"' "
                    + "OR dept_no = '"+dept_no+"' )AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();
            
            if (recordfound){
                return 0;
            }
            else{
                sql = "INSERT INTO department(dept_no,dept_name) VALUES(?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, dept_no);
                st.setString(2, dept_name);
                st.executeUpdate();
                con.close();
                return 1;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 2;
        }
    }

    public String give_ID(String dept_name) {
        String result = null;
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT dept_no FROM department WHERE dept_name = '"+dept_name+"'AND status = '"+"0"+"'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            result = rs.getString("dept_no");
            con.close();
            return result;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return result;
        }
    }

    public int delete(String dept_name) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM employees WHERE dept_name = '"+dept_name+"'"
                    + "AND status = '"+"0"+"'";
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();

            if (recordfound){
                return 0;
            }
            else{
                sql = "UPDATE department set status = '"+"1"+"' "
                    + "WHERE dept_name = '"+dept_name+"'";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
                return 1;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 2;
        }
    }

    public int update(String dept_name, String dept_no) {
        try{
            con = SQLConnect.getConnection();
            String sql = "UPDATE department SET dept_name = '"+dept_name+"',dept_no = '"+dept_no+"'"
                    + "WHERE dept_name = '"+dept_name+"' AND status = '"+"0"+"'";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
            con.close();
            return 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
}
