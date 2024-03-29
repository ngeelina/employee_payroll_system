/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DepartmentController;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sam
 */
public class ManageDept extends javax.swing.JDialog {
    
    DepartmentController dc = new DepartmentController();
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    
    /**
     * Creates new form DepartmentMenu
     */
    public ManageDept(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setIconImage(new ImageIcon(LogDetails.class.getResource("images/i16x16/Branch.png")).getImage());
        setDefaultLookAndFeelDecorated(false);
        setLocation(screen.width/4, screen.height/4);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_department = new javax.swing.JLabel();
        cmb_department = new javax.swing.JComboBox();
        lbl_deptID = new javax.swing.JLabel();
        txt_deptID = new javax.swing.JTextField();
        btn_cancel = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_department.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_department.setText("Department :");

        cmb_department.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_department.setModel(dept());
        cmb_department.addItem("Add new...");
        cmb_department.setSelectedItem(null);
        cmb_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departmentActionPerformed(evt);
            }
        });

        lbl_deptID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_deptID.setText("Department ID: ");

        txt_deptID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_department)
                        .addGap(35, 35, 35)
                        .addComponent(cmb_department, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_deptID)
                            .addComponent(btn_update))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_cancel))
                            .addComponent(txt_deptID, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_department)
                    .addComponent(cmb_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_deptID)
                    .addComponent(txt_deptID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_cancel))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departmentActionPerformed
        txt_deptID.setText(null);

        String dept = (String) cmb_department.getSelectedItem();
        if(dept=="Add new..."){
            String new_dept = JOptionPane.showInputDialog(this,"Enter new department","New Department",JOptionPane.PLAIN_MESSAGE);
            if(new_dept == null){
                dispose();
            }
            else{
                String new_id = JOptionPane.showInputDialog(this,"Enter new ID","Department ID",JOptionPane.PLAIN_MESSAGE);
                if(new_id == null){
                    dispose();
                }
                else{
                    dc.getDepartment().setDept_name(new_dept);
                    dc.getDepartment().setDept_no(new_id);
                    int i = dc.add();
                    if(i == 0){
                        JOptionPane.showMessageDialog(null, "Department/ID already exists","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(i == 1){
                        JOptionPane.showMessageDialog(null, "New Department added","Success",JOptionPane.PLAIN_MESSAGE);
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Database problem","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        else{
            dc.getDepartment().setDept_name(dept);
            txt_deptID.setText(dc.getID());

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_departmentActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,"Confirm Delete?","Delete Department",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (reply == JOptionPane.YES_OPTION){
            String dept = (String) cmb_department.getSelectedItem();
            dc.getDepartment().setDept_name(dept);
            int i = dc.delete();
            if(i == 0){
                JOptionPane.showMessageDialog(null, "Employees exist in given department."
                    + "\nDelete employee or change department first","Error",JOptionPane.ERROR_MESSAGE);
            }
            else if(i == 1){
                JOptionPane.showMessageDialog(null, "Department deleted","Success",JOptionPane.PLAIN_MESSAGE);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Deletion error","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(cmb_department.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null, "Select from list","Error",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String dept = (String) cmb_department.getSelectedItem();
            String no = txt_deptID.getText();

            dc.getDepartment().setDept_name(dept);
            dc.getDepartment().setDept_no(no);
            int i = dc.update();
            if(i == 1){
                JOptionPane.showMessageDialog(null, "Department updated","Success",JOptionPane.PLAIN_MESSAGE);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Update Error","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

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
            java.util.logging.Logger.getLogger(ManageDept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManageDept dialog = new ManageDept(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox cmb_department;
    private javax.swing.JLabel lbl_department;
    private javax.swing.JLabel lbl_deptID;
    private javax.swing.JTextField txt_deptID;
    // End of variables declaration//GEN-END:variables

    private ComboBoxModel dept() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(dc.get_dept().toArray());
        return model;
    }
}
