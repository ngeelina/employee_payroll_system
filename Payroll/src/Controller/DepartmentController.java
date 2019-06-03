/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DaoImpl.DepartmentDaoImpl;
import Model.Department;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class DepartmentController {

    Department department = new Department();
    DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public ArrayList<String> get_dept() {
        return departmentDaoImpl.give_dept();
    }

    public int add() {
        return departmentDaoImpl.add(department.getDept_name(),department.getDept_no());
    }

    public String getID() {
        return departmentDaoImpl.give_ID(department.getDept_name());
    }

    public int delete() {
        return departmentDaoImpl.delete(department.getDept_name());
    }

    public int update() {
        return departmentDaoImpl.update(department.getDept_name(),department.getDept_no());
    }
    
}
