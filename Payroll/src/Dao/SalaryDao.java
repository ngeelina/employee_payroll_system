/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ResultSetTableModel;

/**
 *
 * @author Sam
 */
public interface SalaryDao {
    public void setupdate(String emp_ID, String sal_from, String sal_to, String sal_date, String holding_amt);
    public ResultSetTableModel sal_record();
}
