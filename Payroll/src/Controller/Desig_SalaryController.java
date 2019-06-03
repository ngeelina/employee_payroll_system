/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DaoImpl.Desig_SalaryDaoImpl;
import Model.Desig_Salary;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class Desig_SalaryController {
    Desig_Salary desig_Salary = new Desig_Salary();
    Desig_SalaryDaoImpl desig_SalaryDaoImpl = new Desig_SalaryDaoImpl();

    public Desig_Salary getDesig_Salary() {
        return desig_Salary;
    }

    public void setDesig_Salary(Desig_Salary desig_Salary) {
        this.desig_Salary = desig_Salary;
    }
    
    public ArrayList<String> get_desig(){
        return desig_SalaryDaoImpl.give_desig();
    }
    
    public Desig_Salary get_details(){
        return desig_SalaryDaoImpl.give_details(desig_Salary.getDesignation());
    }
    
    public int add(){
        return desig_SalaryDaoImpl.add(desig_Salary.getDesignation(),desig_Salary.getBasic_pay());
    }
    
    public int update(){
        return desig_SalaryDaoImpl.update(desig_Salary.getDes_no(),desig_Salary.getDesignation(), desig_Salary.getBasic_pay(), 
                desig_Salary.getDA_allow(), desig_Salary.getHRA_allow(), desig_Salary.getTA_allow(), 
                desig_Salary.getGPF_dedu(), desig_Salary.getIT_dedu(), desig_Salary.getGIS_dedu(),
                desig_Salary.getHoldings(), desig_Salary.getLIC_dedu());
    }
    
    public int delete(){
        return desig_SalaryDaoImpl.delete(desig_Salary.getDesignation());
    }
}
