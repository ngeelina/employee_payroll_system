/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ResultSetTableModel;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public interface AttendanceDao {
    public int record(String emp_bar, String date);
    public int view(String emp_bar);
    public ArrayList<String> fromto(String emp_bar);
    public String present(String emp_bar);
    public void setupdate(String emp_bar);
    public ResultSetTableModel att_record();
}
