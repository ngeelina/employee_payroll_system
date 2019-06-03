/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DaoImpl.SalaryDaoImpl;
import Model.ResultSetTableModel;
import Model.Salary;

/**
 *
 * @author Sam
 */
public class SalaryController {
    Salary salary = new Salary();
    SalaryDaoImpl salaryDaoImpl= new SalaryDaoImpl();

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public void setupdate() {
        salaryDaoImpl.setupdate(salary.getEmpID(),salary.getsal_From(),salary.getsal_To(),
                salary.getsal_Date(),salary.getHolding_amt());
    }
    
    public ResultSetTableModel sal_record(){
        return salaryDaoImpl.sal_record();
    }
    
}
