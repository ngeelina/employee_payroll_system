/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Controller.SQLConnect;
import Dao.Desig_SalaryDao;
import Model.Desig_Salary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class Desig_SalaryDaoImpl implements Desig_SalaryDao{

    Connection con = null;
    Statement stmt = null;
    
    @Override
    public ArrayList<String> give_desig() {
        ArrayList<String> desig = new ArrayList<String>();
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT designation FROM desig_salary WHERE status = '"+"0"+"' "
                    + "ORDER BY designation";
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) { 
                    String temp_desig = rs.getString("designation");
                    desig.add(temp_desig);
                }
                con.close();
                return desig;
            } catch (SQLException ex) {
                con.close();
                System.out.println(ex.getMessage());
                return desig;
            }
        }
        catch(Exception ex)
        {
             System.out.println(ex.getMessage());
             return desig;
        }
    }

    @Override
    public Desig_Salary give_details(String desig) {
        Desig_Salary result = new Desig_Salary();
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM desig_salary WHERE designation = '"+desig+"'"
                    + "AND status = '"+"0"+"'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            result.setDesignation(rs.getString("Designation"));
            result.setDes_no(rs.getString("des_id"));
            result.setBasic_pay(rs.getString("basic_pay"));
            result.setDA_allow(rs.getString("DA_allow"));
            result.setHRA_allow(rs.getString("HRA_allow"));
            result.setTA_allow(rs.getString("TA_allow"));
            result.setGPF_dedu(rs.getString("GPF_dedu"));
            result.setIT_dedu(rs.getString("IT_dedu"));
            result.setGIS_dedu(rs.getString("GIS_dedu"));
            result.setHoldings(rs.getString("Holdings"));
            result.setLIC_dedu(rs.getString("LIC_dedu"));
            con.close();
            return result;
        }
        catch(Exception ex)
        {
             System.out.println(ex.getMessage());
             return result;
        }    
    }

    @Override
    public int add(String designation, String basic_pay) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM desig_salary WHERE designation LIKE '"+designation+"'"
                    + "AND status = '"+"0"+"'";
            stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();

            if (recordfound){
                return 0;
            }
            else{
                sql = "INSERT INTO desig_salary(designation,basic_pay) VALUES(?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, designation);
                st.setString(2, basic_pay);
                st.executeUpdate();
                con.close();
                return 1;
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return 2;
        }
    }
    
    @Override
    public int update(String desig_no, String designation, String basic_pay, String DA_allow, 
            String HRA_allow, String TA_allow, String GPF_dedu, String IT_dedu, 
            String GIS_dedu, String Holdings, String LIC_dedu) {
        try{
            con = SQLConnect.getConnection();
            String sql = "UPDATE desig_salary SET designation = '"+designation+"',"
                    + "basic_pay = '"+basic_pay+"',DA_allow = '"+DA_allow+"',"
                    + "HRA_allow = '"+HRA_allow+"',TA_allow = '"+TA_allow+"',"
                    + "GPF_dedu = '"+GPF_dedu+"',IT_dedu = '"+IT_dedu+"',"
                    + "GIS_dedu = '"+GIS_dedu+"',Holdings = '"+Holdings+"',"
                    + "LIC_dedu = '"+LIC_dedu+"' WHERE des_id = '"+desig_no+"'";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);
            con.close();
            return 1;
        }
        catch(Exception ex)
        {
             System.out.println(ex.getMessage());
             return 0;
        }
    }

    @Override
    public int delete(String desig) {
        try{
            con = SQLConnect.getConnection();
            String sql = "SELECT * FROM employees WHERE designation LIKE '"+desig+'%'+"'"
                    + "AND status = '"+"0"+"'";
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            boolean recordfound = rs.next();

            if (recordfound){
                return 0;
            }
            else{
                sql = "UPDATE desig_salary set status = '"+"1"+"' "
                    + "WHERE designation = '"+desig+"'";
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
    
}
