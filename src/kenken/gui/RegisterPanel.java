/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.awt.Color;
import java.util.Arrays;
import kenken.domain.controllers.UserController;
import kenken.domain.controllers.UserControllerKenken;

/**
 *
 * @author Marc
 */
public class RegisterPanel extends javax.swing.JPanel {

    private MainWindow mw;
    private UserControllerKenken uc;
    /**
     * Creates new form RegisterPanel
     * @param mw
     */
    public RegisterPanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
        this.uc = mw.getUserController();
    }

    public void clearTxt(){
        txtVerifyPassword.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtVerifyPassword.setBackground(Color.WHITE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblVerifyPassword = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblRegister = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtVerifyPassword = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        lblErrores = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        txtUsername.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N

        lblUsername.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblUsername.setText("Username:");

        lblPassword.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblPassword.setText("Password:");

        lblVerifyPassword.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblVerifyPassword.setText("Re-type password");

        btnSubmit.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblRegister.setFont(new java.awt.Font("Flubber", 0, 36)); // NOI18N
        lblRegister.setText("REGISTER");

        btnBack.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtVerifyPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVerifyPasswordKeyReleased(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        lblErrores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblErrores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblTitle.setFont(new java.awt.Font("Flubber", 0, 48)); // NOI18N
        lblTitle.setText("ALMAGEPO KENKEN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsername)
                            .addComponent(lblVerifyPassword)
                            .addComponent(lblPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtVerifyPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lblRegister)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVerifyPassword)
                    .addComponent(txtVerifyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(lblErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        if("".equals(txtUsername.getText())){
            lblErrores.setText("Please enter an username.");
        }else if (Arrays.equals(txtPassword.getPassword(), txtVerifyPassword.getPassword())){
            int result = uc.createUser(txtUsername.getText(), Arrays.toString(txtPassword.getPassword()));
            if (result == -1){
                lblErrores.setText("Username " + txtUsername.getText() + " already in use.");
            }else if (result == -2){
                lblErrores.setText("Internal Error.");
            }else{
                int errcode = uc.login(txtUsername.getText(), Arrays.toString(txtPassword.getPassword()));
                if (errcode == 0){
                    ((MainMenuPanel) mw.getPanel(MainWindow.Panels.MainMenuPanel)).setUser(txtUsername.getText());
                    mw.setPanel(MainWindow.Panels.MainMenuPanel);
                }
            }
        }else{
            lblErrores.setText("Passwords are not equal.");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ((LoginPanel) mw.getPanel(MainWindow.Panels.LoginPanel)).clearTxt();
        mw.setPanel(MainWindow.Panels.LoginPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtVerifyPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVerifyPasswordKeyReleased
        if (Arrays.equals(txtPassword.getPassword(), txtVerifyPassword.getPassword())){
            txtVerifyPassword.setBackground(Color.GREEN);
        }else{
            txtVerifyPassword.setBackground(Color.red);
        }        
    }//GEN-LAST:event_txtVerifyPasswordKeyReleased

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        ((LoginPanel) mw.getPanel(MainWindow.Panels.LoginPanel)).clearTxt();
        mw.setPanel(MainWindow.Panels.LoginPanel);
    }//GEN-LAST:event_btnBackMouseClicked

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if (Arrays.equals(txtPassword.getPassword(), txtVerifyPassword.getPassword())){
            txtVerifyPassword.setBackground(Color.GREEN);
        }else{
            txtVerifyPassword.setBackground(Color.red);
        }     
    }//GEN-LAST:event_txtPasswordKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblErrores;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVerifyPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtVerifyPassword;
    // End of variables declaration//GEN-END:variables
}
