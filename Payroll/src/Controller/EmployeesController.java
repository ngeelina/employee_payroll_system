/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DaoImpl.EmployeesDaoImpl;
import Model.Employees;
import Model.ResultSetTableModel;

/**
 *
 * @author Sam
 */
public class EmployeesController {
    Employees employees = new Employees();
    EmployeesDaoImpl employeesDaoImpl = new EmployeesDaoImpl();

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public int add() {
        return employeesDaoImpl.add(employees.getCity(),employees.getDept_name(),
                employees.getDesignation(),employees.getDob(),employees.getEmail_ID(),
                employees.getEmp_ID(),employees.getFirst_name(),employees.getHire_date(),
                employees.getLast_name(),employees.getMiddle_name(),employees.getPhone_no());
    }
    
    public int find(){
        return employeesDaoImpl.find(employees.getEmp_ID());
    }
    
    public Employees get_details(){
        return employeesDaoImpl.give_details(employees.getEmp_ID());
    }

    public int update() {
        return employeesDaoImpl.update(employees.getCity(),employees.getDept_name(),
                employees.getDesignation(),employees.getDob(),employees.getEmail_ID(),
                employees.getEmp_ID(),employees.getFirst_name(),employees.getHire_date(),
                employees.getLast_name(),employees.getMiddle_name(),employees.getPhone_no());
    }

    public int delete() {
        return employeesDaoImpl.delete(employees.getEmp_ID());
    }
    
    public ResultSetTableModel emp_info(){
        return employeesDaoImpl.emp_info();
    }
    
    public String name(){
        return employeesDaoImpl.name(employees.getEmp_ID());
    }
    
}
