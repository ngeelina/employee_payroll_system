/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DaoImpl.LogDetailsDaoImpl;
import Model.LogDetails;
//import model.Users;

/**
 *
 * @author Samir
 */
public class LogDetailsController {
    LogDetails logDetails = new LogDetails();
    LogDetailsDaoImpl logDetailsDaoImpl = new LogDetailsDaoImpl();

    public LogDetails getLogDetails() {
        return logDetails;
    }

    public void setLogDetails(LogDetails logDetails) {
        this.logDetails = logDetails;
    }
    
    //Employees employees = new Employees();
    //Users users = new Users(); 
    
    
    public void setlogin(){
        logDetailsDaoImpl.setlogin(logDetails.getUsername());
    }
    
    public void setlogout(){
        logDetailsDaoImpl.setlogout(logDetails.getLogout());
    }
    
}

