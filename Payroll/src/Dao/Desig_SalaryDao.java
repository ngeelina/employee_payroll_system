/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Desig_Salary;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public interface Desig_SalaryDao {
    public ArrayList<String> give_desig();
    public Desig_Salary give_details(String desig);
    public int add(String designation, String basic_pay);
    public int update(String desig_no, String designation, String basic_pay,String DA_allow, 
            String HRA_allow, String TA_allow, String GPF_dedu,String IT_dedu, 
            String GIS_dedu, String Holdings, String LIC_dedu);
    public int delete(String desig);
}
