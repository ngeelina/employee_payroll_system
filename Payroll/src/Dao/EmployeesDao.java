/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Employees;
import Model.ResultSetTableModel;

/**
 *
 * @author Sam
 */
public interface EmployeesDao {
    public int add(String city, String dept_name, String designation, String dob, 
            String email_ID, String emp_ID, String first_name, String hire_date, 
            String last_name, String middle_name, String phone_no);
    public int find(String emp_ID);
    public Employees give_details(String emp_ID);
    public int update(String city, String dept_name, String designation, String dob, 
            String email_ID, String emp_ID, String first_name, String hire_date, 
            String last_name, String middle_name, String phone_no);
    public int delete(String emp_ID);
    public ResultSetTableModel emp_info();
    public String name(String emp_ID);
}
