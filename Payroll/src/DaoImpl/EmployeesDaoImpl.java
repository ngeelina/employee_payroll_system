/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Controller.SQLConnect;
import Dao.EmployeesDao;
import Model.Employees;
import Model.ResultSetTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sam
 */
public class EmployeesDaoImpl implements EmployeesDao{

    Connection con = null;
    Statement stmt = null;
    
    public int add(String city, String dept_name, String designation, String dob, 
            String email_ID, String emp_ID, String first_name, String hire_date, 
            String last_name, String middle_name, String phone_no) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM employees WHERE emp_ID = '"+emp_ID+"' "
                    + "AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();
            
            if (recordfound){
                return 0;
            }
            else{
                sql = "INSERT INTO employees(emp_bar,emp_ID,first_name,middle_name,last_name,"
                        + "dob,hire_date,dept_name,designation,city,phone_no,email_ID) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, "kec"+emp_ID+"s");
                st.setString(2, emp_ID);
                st.setString(3, first_name);
                st.setString(4, middle_name);
                st.setString(5, last_name);
                st.setString(6, dob);
                st.setString(7, hire_date);
                st.setString(8, dept_name);
                st.setString(9, designation);
                st.setString(10, city);
                st.setString(11, phone_no);
                st.setString(12, email_ID);
                
                st.executeUpdate();
                con.close();
                return 1;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 2;
        }
    }

    public int find(String emp_ID) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM employees WHERE emp_ID = '"+emp_ID+"' "
                    + "AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();
            con.close();
            if (recordfound){
                return 1;
            }
            else
                return 0;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public Employees give_details(String emp_ID) {
        Employees result = new Employees();
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM employees WHERE emp_ID = '"+emp_ID+"' "
                    + "AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            rs.next();
            result.setEmp_ID(rs.getString("emp_ID"));
            result.setFirst_name(rs.getString("first_name"));
            result.setMiddle_name(rs.getString("middle_name"));
            result.setLast_name(rs.getString("last_name"));
            result.setDob(rs.getString("dob"));
            result.setHire_date(rs.getString("hire_date"));
            result.setDept_name(rs.getString("dept_name"));
            result.setDesignation(rs.getString("designation"));
            result.setCity(rs.getString("city"));
            result.setPhone_no(rs.getString("phone_no"));
            result.setEmail_ID(rs.getString("email_ID"));
            con.close();
            return result;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return result;
        }
    }

    public int update(String city, String dept_name, String designation, String dob, 
            String email_ID, String emp_ID, String first_name, String hire_date, 
            String last_name, String middle_name, String phone_no) {
        try{
            con = SQLConnect.getConnection();
            String sql = "UPDATE employees SET first_name = '"+first_name+"', middle_name = '"+middle_name+"',"
                        + "last_name = '"+last_name+"', dob = '"+dob+"',hire_date = '"+hire_date+"',"
                        + "dept_name = '"+dept_name+"',designation = '"+designation+"',city = '"+city+"',"
                        + "phone_no = '"+phone_no+"',email_ID = '"+email_ID+"' "
                        + "WHERE emp_ID = '"+emp_ID+"' AND status = '"+"0"+"'";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);
            con.close();
            return 1;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 2;
        }
    }

    public int delete(String emp_ID) {
        try{
            con = SQLConnect.getConnection();
            String sql = "Select * from users WHERE emp_ID = '"+emp_ID+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();

            if (recordfound){
                con.close();
                return 0;
            }
            else{
                sql = "UPDATE employees SET status = '"+"1"+"' WHERE emp_ID = '"+emp_ID+"'";
                PreparedStatement st = con.prepareStatement(sql);
                st.executeUpdate(sql);
                sql = "UPDATE attendance SET status = '"+"1"+"' WHERE emp_ID = '"+emp_ID+"'";
                st = con.prepareStatement(sql);
                st.executeUpdate(sql);
                con.close();
                return 1;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 2;
        }
    }

    public ResultSetTableModel emp_info() {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT emp_ID, concat(first_name,' ',middle_name,' ',last_name) "
                    + "AS Fullname, dept_name, designation, city FROM employees "
                    + "WHERE status = '"+"0"+"' ORDER BY emp_ID";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            return new ResultSetTableModel(rs);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public String name(String emp_ID) {
        String result = null;
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT first_name FROM employees WHERE emp_ID = '"+emp_ID+"'";
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
