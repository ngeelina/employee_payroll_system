/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UsersController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Samir
 */
public class LoginScreen extends javax.swing.JFrame {

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    UsersController uc = new UsersController();

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
       /* 
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("C:/wamp/wampmanager.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Please check your wampserver", "Error Found", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
       */
        setLocation((screen.width - 500) / 2, ((screen.height - 300) / 2) - 70);
        setIconImage(new ImageIcon(LoginScreen.class.getResource("images/i16x16/Business.png")).getImage());
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

        txt_SysLgn = new javax.swing.JLabel();
        lbl_LogPic = new javax.swing.JLabel();
        LogBorder = new javax.swing.JPanel();
        lbl_Caption1 = new javax.swing.JLabel();
        lbl_Caption2 = new javax.swing.JLabel();
        lbl_Caption3 = new javax.swing.JLabel();
        lbl_UserName = new javax.swing.JLabel();
        txt_UserName = new javax.swing.JTextField();
        lbl_Password = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        lbl_LoginAs = new javax.swing.JLabel();
        cmb_LoginAs = new javax.swing.JComboBox();
        lbl_Note = new javax.swing.JLabel();
        btn_Login = new javax.swing.JButton();
        btn_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        txt_SysLgn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_SysLgn.setText("System Login");

        lbl_LogPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/login.png"))); // NOI18N

        LogBorder.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_Caption1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Caption1.setText("Please enter your correct username and password in the field");

        lbl_Caption2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Caption2.setText("provided below. If you for got your username or password");

        lbl_Caption3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Caption3.setText("please contact your administrator immediately.");

        lbl_UserName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_UserName.setText("Username");

        txt_UserName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl_Password.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Password.setText("Password");

        txt_Password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyPressed(evt);
            }
        });

        lbl_LoginAs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_LoginAs.setText("Login As");

        cmb_LoginAs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_LoginAs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User" }));
        cmb_LoginAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_LoginAsActionPerformed(evt);
            }
        });
        cmb_LoginAs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_LoginAsKeyPressed(evt);
            }
        });

        lbl_Note.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_Note.setForeground(new java.awt.Color(255, 0, 0));
        lbl_Note.setText("NOTE: UnAuthorized Person is not allowed.");

        javax.swing.GroupLayout LogBorderLayout = new javax.swing.GroupLayout(LogBorder);
        LogBorder.setLayout(LogBorderLayout);
        LogBorderLayout.setHorizontalGroup(
            LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogBorderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogBorderLayout.createSequentialGroup()
                        .addGroup(LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Caption3)
                            .addComponent(lbl_Caption2)
                            .addComponent(lbl_Caption1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogBorderLayout.createSequentialGroup()
                        .addGroup(LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LogBorderLayout.createSequentialGroup()
                                .addComponent(lbl_LoginAs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_LoginAs, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LogBorderLayout.createSequentialGroup()
                                .addGroup(LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Password)
                                    .addComponent(lbl_UserName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_Password)
                                    .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37))))
            .addGroup(LogBorderLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbl_Note)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        LogBorderLayout.setVerticalGroup(
            LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogBorderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Caption1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Caption2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Caption3)
                .addGap(18, 18, 18)
                .addGroup(LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_UserName)
                    .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Password)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LogBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_LoginAs)
                    .addComponent(cmb_LoginAs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(lbl_Note)
                .addGap(20, 20, 20))
        );

        LogBorderLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_Password, txt_UserName});

        LogBorderLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbl_Caption1, lbl_Caption2, lbl_Caption3});

        btn_Login.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/i16x16/ok.png"))); // NOI18N
        btn_Login.setText("Login");
        btn_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Login.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/i16x16/ok_Hover.png"))); // NOI18N
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });
        btn_Login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_LoginKeyPressed(evt);
            }
        });

        btn_Exit.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/i16x16/exit.png"))); // NOI18N
        btn_Exit.setText("Exit");
        btn_Exit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/i16x16/exit_Hover.png"))); // NOI18N
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });
        btn_Exit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_ExitKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lbl_LogPic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Login)
                        .addGap(106, 106, 106)
                        .addComponent(btn_Exit)
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LogBorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_SysLgn))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Exit, btn_Login});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txt_SysLgn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_LogPic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Login)
                    .addComponent(btn_Exit))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Exit, btn_Login});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            login();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordKeyPressed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        login();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void btn_LoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_LoginKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            login();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LoginKeyPressed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void btn_ExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_ExitKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            System.exit(0);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ExitKeyPressed

    private void cmb_LoginAsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_LoginAsKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            btn_Login.grabFocus();
            login();
        }
    }//GEN-LAST:event_cmb_LoginAsKeyPressed

    private void cmb_LoginAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_LoginAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_LoginAsActionPerformed

    private void login() {
        String user = txt_UserName.getText();
        String pass = txt_Password.getText();
        String type = (String) cmb_LoginAs.getSelectedItem();
        uc.getUsers().setUsername(user);
        uc.getUsers().setPassword(pass);
        uc.getUsers().setType(type);
        int i = uc.isValidUser();
        switch (i){
            case 0:
                JOptionPane.showMessageDialog(null, "Login Info Not Valid", 
                        "Error", JOptionPane.INFORMATION_MESSAGE);
                txt_Password.setText("");
                txt_UserName.grabFocus();
                txt_UserName.selectAll();
                cmb_LoginAs.setSelectedItem("Admin");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Welcome " + type);
                dispose();
                new MainAdmin(user, type).setVisible(true);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Welcome " + type);
                dispose();
                new MainUser(user, type).setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Server Connection Error", 
                        "Warning!!", JOptionPane.INFORMATION_MESSAGE);
                txt_Password.setText("");
                txt_UserName.grabFocus();
                txt_UserName.selectAll();
                cmb_LoginAs.setSelectedItem("Admin");
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        /*
         * Set the Metal look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Metal (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //setDefaultLookAndFeelDecorated(false);
        } 
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        // handle exception
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogBorder;
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_Login;
    private javax.swing.JComboBox cmb_LoginAs;
    private javax.swing.JLabel lbl_Caption1;
    private javax.swing.JLabel lbl_Caption2;
    private javax.swing.JLabel lbl_Caption3;
    private javax.swing.JLabel lbl_LogPic;
    private javax.swing.JLabel lbl_LoginAs;
    private javax.swing.JLabel lbl_Note;
    private javax.swing.JLabel lbl_Password;
    private javax.swing.JLabel lbl_UserName;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JLabel txt_SysLgn;
    private javax.swing.JTextField txt_UserName;
    // End of variables declaration//GEN-END:variables

}