/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DaoImpl.LogDetailsMenuDaoImpl;
import Model.LogsDetails;
import Model.ResultSetTableModel;

/**
 *
 * @author Samir
 */
public class LogDetailsMenuController {
    LogsDetails logsDetails = new LogsDetails();
    LogDetailsMenuDaoImpl logsDetailsDaoImpl = new LogDetailsMenuDaoImpl();

    public LogsDetails getLogsDetails() {
        return logsDetails;
    }

    public void setLogsDetails(LogsDetails logsDetails) {
        this.logsDetails = logsDetails;
    }
    
    
    public ResultSetTableModel getlogdetails(){
        return logsDetailsDaoImpl.getlogdetails();
    }
}
