/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DaoImpl.AttendanceDaoImpl;
import Model.Attendance;
import Model.ResultSetTableModel;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class AttendanceController {
    Attendance attendance = new Attendance();
    AttendanceDaoImpl attendanceDaoImpl = new AttendanceDaoImpl();

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public int record() {
        return attendanceDaoImpl.record(attendance.getEmp_bar(),attendance.getDate());
    }

    public int view() {
        return attendanceDaoImpl.view(attendance.getEmp_bar());
    }

    public ArrayList<String> getFromTo() {
        return attendanceDaoImpl.fromto(attendance.getEmp_bar());
    }

    public String present() {
        return attendanceDaoImpl.present(attendance.getEmp_bar());
    }
    
    public void setupdate() {
        attendanceDaoImpl.setupdate(attendance.getEmp_bar());
    }
    
    public ResultSetTableModel att_record(){
        return attendanceDaoImpl.att_record();
    }
    
}
