/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import javax.swing.JOptionPane;
import kenken.domain.controllers.*;

/**
 *
 * @author GERARD
 */
public class OptionsPanel extends javax.swing.JPanel {

    private MainWindow mw;
    private UserController uc;
    /**
     * Creates new form OptionsPanel
     * @param mw
     * @param uc
     */
    public OptionsPanel(MainWindow mw, UserController uc) {
        initComponents();
        this.mw = mw;
        this.uc = uc;
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
        btnDeleteUser = new javax.swing.JButton();
        btnMusic = new javax.swing.JButton();

        btnBack.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDeleteUser.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnDeleteUser.setText("Delete this user");
        btnDeleteUser.setToolTipText("");
        btnDeleteUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDeleteUser.setMaximumSize(new java.awt.Dimension(159, 35));
        btnDeleteUser.setMinimumSize(new java.awt.Dimension(159, 35));
        btnDeleteUser.setPreferredSize(new java.awt.Dimension(159, 35));
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnMusic.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnMusic.setText("Music on");
        btnMusic.setToolTipText("");
        btnMusic.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMusic.setMaximumSize(new java.awt.Dimension(159, 35));
        btnMusic.setMinimumSize(new java.awt.Dimension(159, 35));
        btnMusic.setPreferredSize(new java.awt.Dimension(159, 35));
        btnMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        mw.setPanel(MainWindow.Panels.MainMenuPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure that you want to delete your user? This will erase all your data permanently.", "Warning", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            String pass = JOptionPane.showInputDialog("Please type your password");
            int error = uc.deleteUser(pass);
            if (error == 0) mw.setPanel(MainWindow.Panels.LoginPanel);
            else {
                JOptionPane.showMessageDialog(this, "Wrong password, unable to delete this user.");
            }
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMusicActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnMusic;
    // End of variables declaration//GEN-END:variables
}