/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public interface DepartmentDao {
    public ArrayList<String> give_dept();
    public int add(String dept_name, String dept_no);
    public String give_ID(String dept_name);
    public int delete(String dept_name);
    public int update(String dept_name, String dept_no);
}
