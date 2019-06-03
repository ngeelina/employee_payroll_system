/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AttendanceController;
import Controller.Desig_SalaryController;
import Controller.EmployeesController;
import Controller.SalaryController;
import Controller.UsersController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sam
 */
public class PayslipGenerate extends javax.swing.JDialog{
    
    Desig_SalaryController dsc = new Desig_SalaryController();
    UsersController uc = new UsersController();
    AttendanceController ac = new AttendanceController();
    SalaryController sc = new SalaryController();
    EmployeesController ec = new EmployeesController();
    private static String User;
    
    private static String empID;
    String ID;
    
    String from = null;
    String to = null;
    String FromTo = null;
    
    
    String basic, da, hra, ta, gpf, it, gis, holdings, lic;
    int basic_am, da_am, hra_am, ta_am, gpf_am, it_am, gis_am, holdings_am, lic_am, total_am;
    
    String name = null;
    
    /**
     * Creates new form PayslipGenerate
     */
    public PayslipGenerate(java.awt.Frame parent, boolean modal, String emp, String user) {
        super();
        setDefaultLookAndFeelDecorated(false);
        setIconImage(new ImageIcon(MainAdmin.class.getResource("images/i16x16/PaySlip.png")).getImage());
        empID = emp;
        User = user;
        ac.getAttendance().setEmp_bar(emp);
        ArrayList<String> fromto = ac.getFromTo();
        if(fromto.get(0) == "no"){
            JOptionPane.showMessageDialog(null, "ID not found","Error",JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        else if(fromto.get(0) == "error"){
            JOptionPane.showMessageDialog(null, "Error in fetching data","Error",JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        else{
            from = fromto.get(0);
            to = fromto.get(1);
            FromTo = from + " to " + to;
        }
        ID = empID.substring(3, 7);
        
        ac.getAttendance().setEmp_bar(ID);
        String present = ac.present();
        
        String desig = fromto.get(2);
        
        dsc.getDesig_Salary().setDesignation(desig);
        dsc.setDesig_Salary(dsc.get_details());
        basic = dsc.getDesig_Salary().getBasic_pay();
        da = dsc.getDesig_Salary().getDA_allow();
        hra = dsc.getDesig_Salary().getHRA_allow();
        ta = dsc.getDesig_Salary().getTA_allow();
        gpf = dsc.getDesig_Salary().getGPF_dedu();
        it = dsc.getDesig_Salary().getIT_dedu();
        gis = dsc.getDesig_Salary().getGIS_dedu();
        holdings = dsc.getDesig_Salary().getHoldings();
        lic = dsc.getDesig_Salary().getLIC_dedu();
        
        basic_am = (StrToNum(basic)*StrToNum(present))/30;
        da_am = (StrToNum(da)*basic_am)/100;
        hra_am = (StrToNum(hra)*basic_am)/100;
        ta_am = (StrToNum(ta)*basic_am)/100;
        gpf_am = (StrToNum(gpf)*basic_am)/100;
        it_am = (StrToNum(it)*basic_am)/100;
        gis_am = (StrToNum(gis)*basic_am)/100;
        holdings_am = (StrToNum(holdings)*basic_am)/100;
        lic_am = (StrToNum(lic)*basic_am)/100;

        total_am = basic_am + (da_am + hra_am + ta_am) -(gpf_am + it_am + gis_am + holdings_am + lic_am) ;
        

        uc.getUsers().setUsername(User);
        User = uc.getuser();
        
        ec.getEmployees().setEmp_ID(ID);
        name = ec.name();
        
        initComponents();
    }
    
    public static int StrToNum(String str){
        return Integer.parseInt(str);
    }
    
    public static String NumToStr(int num){
        return String.valueOf(num);
    }
    
    public static String curr_dt(){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(dt);
        return currentDate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        title3 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        lbl_Date = new javax.swing.JLabel();
        lbl_emp_ID = new javax.swing.JLabel();
        lbl_Emp_ID = new javax.swing.JLabel();
        lbl_slip = new javax.swing.JLabel();
        lbl_Slip = new javax.swing.JLabel();
        lbl_salary = new javax.swing.JLabel();
        lbl_Salary = new javax.swing.JLabel();
        lbl_allow = new javax.swing.JLabel();
        lbl_dedu = new javax.swing.JLabel();
        lbl_da = new javax.swing.JLabel();
        lbl_DA = new javax.swing.JLabel();
        lbl_hra = new javax.swing.JLabel();
        lbl_HRA = new javax.swing.JLabel();
        lbl_ta = new javax.swing.JLabel();
        lbl_TA = new javax.swing.JLabel();
        lbl_gpf = new javax.swing.JLabel();
        lbl_GPF = new javax.swing.JLabel();
        lbl_it = new javax.swing.JLabel();
        lbl_IT = new javax.swing.JLabel();
        lbl_gis = new javax.swing.JLabel();
        lbl_GIS = new javax.swing.JLabel();
        lbl_holdings = new javax.swing.JLabel();
        lbl_Holdings = new javax.swing.JLabel();
        lbl_lic = new javax.swing.JLabel();
        lbl_LIC = new javax.swing.JLabel();
        lbl_net = new javax.swing.JLabel();
        lbl_Net = new javax.swing.JLabel();
        lbl_by = new javax.swing.JLabel();
        lbl_By = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        lbl_by1 = new javax.swing.JLabel();
        lbl_By1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PaySlip Generation");
        setLocationByPlatform(true);
        setModal(true);
        setResizable(false);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        title1.setText("Kantipur Engineering College");
        panel.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 13, -1, -1));

        title2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        title2.setText("Dhapakhel, Lalitpur");
        panel.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 39, -1, -1));

        title3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        title3.setText("Salary Payslip");
        panel.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 76, -1, -1));

        lbl_date.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_date.setText("Date :");
        panel.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        lbl_Date.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Date.setText(curr_dt());
        panel.add(lbl_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        lbl_emp_ID.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_emp_ID.setText("EmpID :");
        panel.add(lbl_emp_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 149, -1, -1));

        lbl_Emp_ID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Emp_ID.setText(ID);
        panel.add(lbl_Emp_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 149, -1, -1));

        lbl_slip.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_slip.setText("Salary Slip :");
        panel.add(lbl_slip, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 178, -1, -1));

        lbl_Slip.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Slip.setText(FromTo);
        panel.add(lbl_Slip, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 178, -1, -1));

        lbl_salary.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_salary.setText("Basic Salary :");
        panel.add(lbl_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 207, -1, -1));

        lbl_Salary.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Salary.setText(basic + "/month");
        panel.add(lbl_Salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 207, -1, -1));

        lbl_allow.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbl_allow.setText("ALLOWANCES");
        panel.add(lbl_allow, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 115, -1));

        lbl_dedu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbl_dedu.setText("DEDUCTIONS");
        panel.add(lbl_dedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 252, 103, -1));

        lbl_da.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_da.setText("DA :");
        panel.add(lbl_da, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        lbl_DA.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_DA.setText(NumToStr(da_am));
        panel.add(lbl_DA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        lbl_hra.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_hra.setText("HRA :");
        panel.add(lbl_hra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        lbl_HRA.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_HRA.setText(NumToStr(hra_am));
        panel.add(lbl_HRA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        lbl_ta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_ta.setText("TA :");
        panel.add(lbl_ta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        lbl_TA.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_TA.setText(NumToStr(ta_am));
        panel.add(lbl_TA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        lbl_gpf.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_gpf.setText("GPF :");
        panel.add(lbl_gpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 290, -1, -1));

        lbl_GPF.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_GPF.setText(NumToStr(gpf_am));
        panel.add(lbl_GPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 290, -1, -1));

        lbl_it.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_it.setText("IT :");
        panel.add(lbl_it, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 319, -1, -1));

        lbl_IT.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_IT.setText(NumToStr(it_am));
        panel.add(lbl_IT, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 319, -1, -1));

        lbl_gis.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_gis.setText("GIS :");
        panel.add(lbl_gis, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 348, -1, -1));

        lbl_GIS.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_GIS.setText(NumToStr(gis_am));
        panel.add(lbl_GIS, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 348, -1, -1));

        lbl_holdings.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_holdings.setText("Holdings :");
        panel.add(lbl_holdings, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 377, -1, -1));

        lbl_Holdings.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Holdings.setText(NumToStr(holdings_am));
        panel.add(lbl_Holdings, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 377, -1, -1));

        lbl_lic.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_lic.setText("LIC :");
        panel.add(lbl_lic, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 406, -1, -1));

        lbl_LIC.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_LIC.setText(NumToStr(lic_am));
        panel.add(lbl_LIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 406, -1, -1));

        lbl_net.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_net.setText("Net Salary :");
        panel.add(lbl_net, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        lbl_Net.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbl_Net.setText(NumToStr(total_am));
        panel.add(lbl_Net, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        lbl_by.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lbl_by.setText("Payslip Generated by :");
        panel.add(lbl_by, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        lbl_By.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lbl_By.setText(User);
        panel.add(lbl_By, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, -1));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/i16x16/prints.png"))); // NOI18N
        btn_print.setText("Print");
        btn_print.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/i16x16/prints_Hover.png"))); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panel.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, -1, -1));

        lbl_by1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lbl_by1.setText("Received by :");
        panel.add(lbl_by1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, -1, -1));

        lbl_By1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lbl_By1.setText(name);
        panel.add(lbl_By1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        int reply = JOptionPane.showConfirmDialog(this,"Really print payslip?","PaySlip printing",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (reply == JOptionPane.YES_OPTION){
            btn_print.setVisible(false);
            PrintUtilities.printComponent(this);
            //String ID = empID.substring(3, 7);
            sc.getSalary().setEmpID(empID);
            sc.getSalary().setEmpID(ID);
            sc.getSalary().setsal_From(from);
            sc.getSalary().setsal_To(to);
            sc.getSalary().setsal_Date(curr_dt());
            sc.getSalary().setHolding_amt(holdings);
            sc.setupdate();
            ac.getAttendance().setEmp_bar(ID);
            ac.setupdate();
        }
        dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_printActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PayslipGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayslipGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayslipGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayslipGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PayslipGenerate dialog = new PayslipGenerate(new javax.swing.JFrame(), true, empID, User);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JLabel lbl_By;
    private javax.swing.JLabel lbl_By1;
    private javax.swing.JLabel lbl_DA;
    private javax.swing.JLabel lbl_Date;
    private javax.swing.JLabel lbl_Emp_ID;
    private javax.swing.JLabel lbl_GIS;
    private javax.swing.JLabel lbl_GPF;
    private javax.swing.JLabel lbl_HRA;
    private javax.swing.JLabel lbl_Holdings;
    private javax.swing.JLabel lbl_IT;
    private javax.swing.JLabel lbl_LIC;
    private javax.swing.JLabel lbl_Net;
    private javax.swing.JLabel lbl_Salary;
    private javax.swing.JLabel lbl_Slip;
    private javax.swing.JLabel lbl_TA;
    private javax.swing.JLabel lbl_allow;
    private javax.swing.JLabel lbl_by;
    private javax.swing.JLabel lbl_by1;
    private javax.swing.JLabel lbl_da;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_dedu;
    private javax.swing.JLabel lbl_emp_ID;
    private javax.swing.JLabel lbl_gis;
    private javax.swing.JLabel lbl_gpf;
    private javax.swing.JLabel lbl_holdings;
    private javax.swing.JLabel lbl_hra;
    private javax.swing.JLabel lbl_it;
    private javax.swing.JLabel lbl_lic;
    private javax.swing.JLabel lbl_net;
    private javax.swing.JLabel lbl_salary;
    private javax.swing.JLabel lbl_slip;
    private javax.swing.JLabel lbl_ta;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    // End of variables declaration//GEN-END:variables
}