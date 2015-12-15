/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Arrays;
import kenken.domain.controllers.UserController;
import kenken.domain.controllers.UserControllerKenken;

/**
 *
 * @author Marc
 */
public class LoginPanel extends javax.swing.JPanel {

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = Toolkit.getDefaultToolkit().createImage("background.jpg");      
        g.drawImage(background, 0, 0, null);
    }
    
    private MainWindow mw;
    /**
     * Creates new form LoginPanel
     * @param mw Main Window Controller.
     */
    public LoginPanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
    }

    /**
     * Clears the text when from Login Panel textbox.
     */
    public void clearTxt(){
        lblErrorMessage.setText("");
        txtUser.setText("");
        txtPassword.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblHaveAcount = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnGuest = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();

        lblTitle.setFont(new java.awt.Font("Flubber", 0, 48)); // NOI18N
        lblTitle.setText("ALMAGEPO KENKEN");

        txtUser.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N

        lblUsername.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblUsername.setText("Username:");

        lblPassword.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblPassword.setText("Password:");

        btnLogin.setFont(new java.awt.Font("Flubber", 0, 36)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblHaveAcount.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblHaveAcount.setText("Don't have an account?");

        btnRegister.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.setActionCommand("Re");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });

        btnGuest.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnGuest.setText("Guest");
        btnGuest.setActionCommand("Re");
        btnGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuestActionPerformed(evt);
            }
        });

        lblErrorMessage.setFont(new java.awt.Font("Flubber", 0, 14)); // NOI18N
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnRegister)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblHaveAcount))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUsername)
                                .addGap(18, 18, 18)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addGap(18, 18, 18)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(lblHaveAcount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Login the user entered in the textbox and switches to MainMenuPanel if the user exist.
     * @param evt Event trigger.
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String username = txtUser.getText();
        String password = Arrays.toString(txtPassword.getPassword());

        UserControllerKenken uc = mw.getUserController();

        int errcode = uc.login(username, password);
        if(errcode == -1) {
            lblErrorMessage.setText("L'usuari no existeix.");
        }else if(errcode == -2){
            lblErrorMessage.setText("La contrasenya no es correcta.");
        }
        else if (errcode == -3) {
            lblErrorMessage.setText("Servei no disponible.");
        }else {
            ((MainMenuPanel) mw.getPanel(MainWindow.Panels.MainMenuPanel)).setUser(txtUser.getText());
            mw.setPanel(MainWindow.Panels.MainMenuPanel);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * Switches to GuestPanel when Guest button is pressed.
     * @param evt Event trigger.
     */
    private void btnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestActionPerformed
        mw.setPanel(MainWindow.Panels.GuestPanel);
    }//GEN-LAST:event_btnGuestActionPerformed

    /**
     * Switches to RegisterPanel when Register button is pressed.
     * @param evt Event trigger.
     */
    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        mw.setPanel(MainWindow.Panels.RegisterPanel);
        ((RegisterPanel) mw.getPanel(MainWindow.Panels.RegisterPanel)).clearTxt();
    }//GEN-LAST:event_btnRegisterMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuest;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblHaveAcount;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
