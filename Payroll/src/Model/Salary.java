/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sam
 */
public class Salary {
    String empID;
    String sal_from;
    String sal_to;
    String sal_date;
    String holding_amt;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getsal_From() {
        return sal_from;
    }

    public void setsal_From(String from) {
        this.sal_from = from;
    }

    public String getsal_To() {
        return sal_to;
    }

    public void setsal_To(String to) {
        this.sal_to = to;
    }

    public String getsal_Date() {
        return sal_date;
    }

    public void setsal_Date(String date) {
        this.sal_date = date;
    }

    public String getHolding_amt() {
        return holding_amt;
    }

    public void setHolding_amt(String holding_amt) {
        this.holding_amt = holding_amt;
    }
    
}
