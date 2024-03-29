/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.JOptionPane;
import kenken.domain.controllers.*;

/**
 *
 * @author GERARD
 */
public class OptionsPanel extends javax.swing.JPanel {

    private MainWindow mw;
    /**
     * Creates new form OptionsPanel
     * @param mw Main Window Controller.
     */
    public OptionsPanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
        txtVerifyPassword.setText("");
    }

    /**
     * Clears the Txtpassword field.
     */
    public void clearTxr(){
        txtVerifyPassword.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        btnChangePass = new javax.swing.JButton();
        txtVerifyPassword = new javax.swing.JPasswordField();
        lblTypePassword = new javax.swing.JLabel();
        lblTypePassword1 = new javax.swing.JLabel();
        lblTypePassword2 = new javax.swing.JLabel();
        lblTypePassword3 = new javax.swing.JLabel();
        txtPasswordDelete = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        lblTypePassword4 = new javax.swing.JLabel();
        lblTypePassword5 = new javax.swing.JLabel();
        txtPasswordOld = new javax.swing.JPasswordField();
        btnDeleteUser = new javax.swing.JButton();
        lblErrores = new javax.swing.JLabel();

        btnBack.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnChangePass.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnChangePass.setText("Change password");
        btnChangePass.setToolTipText("");
        btnChangePass.setMaximumSize(new java.awt.Dimension(159, 35));
        btnChangePass.setMinimumSize(new java.awt.Dimension(159, 35));
        btnChangePass.setPreferredSize(new java.awt.Dimension(159, 35));
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        txtVerifyPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVerifyPasswordActionPerformed(evt);
            }
        });
        txtVerifyPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVerifyPasswordKeyReleased(evt);
            }
        });

        lblTypePassword.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblTypePassword.setText("Change password:");

        lblTypePassword1.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblTypePassword1.setText("Type your password here:");

        lblTypePassword2.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblTypePassword2.setText("Delete user:");

        lblTypePassword3.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblTypePassword3.setText("Old password:");

        txtPasswordDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordDeleteActionPerformed(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        lblTypePassword4.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblTypePassword4.setText("Type your new password:");
        lblTypePassword4.setToolTipText("");

        lblTypePassword5.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblTypePassword5.setText("Re-type your password:");

        btnDeleteUser.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnDeleteUser.setText("Delete this user");
        btnDeleteUser.setToolTipText("");
        btnDeleteUser.setMaximumSize(new java.awt.Dimension(159, 35));
        btnDeleteUser.setMinimumSize(new java.awt.Dimension(159, 35));
        btnDeleteUser.setPreferredSize(new java.awt.Dimension(159, 35));
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(lblTypePassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPasswordDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTypePassword4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTypePassword3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(txtVerifyPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(txtPasswordOld, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(lblTypePassword5, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(lblErrores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(lblTypePassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(517, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblTypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(lblTypePassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txtPasswordDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblTypePassword4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTypePassword5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtVerifyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTypePassword3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPasswordOld, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(194, 194, 194)
                    .addComponent(lblTypePassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(591, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Switches to Main menu Panel when back button is pressed.
     * @param evt Event trigger.
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        mw.setPanel(MainWindow.Panels.MainMenuPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * When the password matches with the user password and the delete button is pressed a pop-up will show up and confirm the deletion.
     * @param evt Event trigger.
     */
    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
            if (Arrays.equals(txtPassword.getPassword(), txtVerifyPassword.getPassword())){
                int result = mw.getUserController().modifyPassword(Arrays.toString(txtPasswordOld.getPassword()), Arrays.toString(txtPassword.getPassword()));
                if (result == -1){
                    lblErrores.setText("Old password is wrong");
                }else if (result == -2){
                    lblErrores.setText("Internal Error.");
                }else{
                    lblErrores.setText("Password saved succesfully");
                }
            }
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your user? This will erase all your data permanently.", "Warning", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            String pass = Arrays.toString(txtPasswordDelete.getPassword());
            UserControllerKenken uc = mw.getUserController();
            String name = uc.getUsername();
            int error = uc.deleteUser(pass);
            if (error == 0) {
                GameController gc = new GameController();
                gc.deleteGames(name);
                ((LoginPanel) mw.getPanel(MainWindow.Panels.LoginPanel)).clearTxt();
                mw.setPanel(MainWindow.Panels.LoginPanel);
            }
            else {
                JOptionPane.showMessageDialog(this, "Wrong password, unable to delete this user.");
                txtPasswordDelete.setText("");
            }
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void txtVerifyPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVerifyPasswordKeyReleased
        if (Arrays.equals(txtVerifyPassword.getPassword(), txtVerifyPassword.getPassword())){
            txtVerifyPassword.setBackground(Color.GREEN);
        }else{
            txtVerifyPassword.setBackground(Color.red);
        } 
    }//GEN-LAST:event_txtVerifyPasswordKeyReleased

    private void txtVerifyPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVerifyPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVerifyPasswordActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if (Arrays.equals(txtPassword.getPassword(), txtVerifyPassword.getPassword())){
            txtVerifyPassword.setBackground(Color.GREEN);
        }else{
            txtVerifyPassword.setBackground(Color.red);
        }   
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtPasswordDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JLabel lblErrores;
    private javax.swing.JLabel lblTypePassword;
    private javax.swing.JLabel lblTypePassword1;
    private javax.swing.JLabel lblTypePassword2;
    private javax.swing.JLabel lblTypePassword3;
    private javax.swing.JLabel lblTypePassword4;
    private javax.swing.JLabel lblTypePassword5;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordDelete;
    private javax.swing.JPasswordField txtPasswordOld;
    private javax.swing.JPasswordField txtVerifyPassword;
    // End of variables declaration//GEN-END:variables
}
