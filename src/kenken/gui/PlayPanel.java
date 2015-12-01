/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import javax.swing.JOptionPane;

/**
 *
 * @author Marc
 */
public class PlayPanel extends javax.swing.JPanel {

    private MainWindow mw;
    /**
     * Creates new form PlayPanel
     */
    public PlayPanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMusic = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnSurrender = new javax.swing.JButton();
        btnSaveGame = new javax.swing.JButton();
        btnHint = new javax.swing.JButton();
        lblHint = new javax.swing.JLabel();

        btnMusic.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnMusic.setText("MUSIC ON/OFF");
        btnMusic.setToolTipText("");
        btnMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Flubber", 1, 36)); // NOI18N
        lblTime.setText("00:00:00");

        btnExit.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.setToolTipText("");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnSurrender.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnSurrender.setText("SURRENDER");
        btnSurrender.setToolTipText("");
        btnSurrender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurrenderActionPerformed(evt);
            }
        });

        btnSaveGame.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnSaveGame.setText("SAVE GAME");
        btnSaveGame.setToolTipText("");
        btnSaveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveGameActionPerformed(evt);
            }
        });

        btnHint.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnHint.setText("HINT");
        btnHint.setToolTipText("");
        btnHint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHintActionPerformed(evt);
            }
        });

        lblHint.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblHint.setText("Hints remaining: 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveGame)
                        .addGap(178, 178, 178)
                        .addComponent(btnSurrender)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHint, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(btnMusic)
                        .addGap(67, 67, 67)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHint)
                            .addComponent(btnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSurrender, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMusicActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure that you want to quit the game?", "Warning", JOptionPane.YES_NO_OPTION);
        if (n == 0) mw.setPanel(MainWindow.Panels.MainMenuPanel);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSurrenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurrenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSurrenderActionPerformed

    private void btnSaveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveGameActionPerformed

    private void btnHintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHint;
    private javax.swing.JButton btnMusic;
    private javax.swing.JButton btnSaveGame;
    private javax.swing.JButton btnSurrender;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
