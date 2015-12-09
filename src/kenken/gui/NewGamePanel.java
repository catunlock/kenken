/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

/**
 *
 * @author Marc
 */
public class NewGamePanel extends javax.swing.JPanel {

    private MainWindow mw;
    /**
     * Creates new form NewGamePanel
     * @param mw
     */
    public NewGamePanel(MainWindow mw) {
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

        btnGenerateBoard = new javax.swing.JButton();
        btnCreateBoard = new javax.swing.JButton();
        btnLoadBoard = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblNewGame = new javax.swing.JLabel();

        btnGenerateBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnGenerateBoard.setText("Generate Board");
        btnGenerateBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBoardActionPerformed(evt);
            }
        });

        btnCreateBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnCreateBoard.setText("Create Board");
        btnCreateBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBoardActionPerformed(evt);
            }
        });

        btnLoadBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnLoadBoard.setText("Load Board");
        btnLoadBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadBoardActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblNewGame.setFont(new java.awt.Font("Flubber", 0, 48)); // NOI18N
        lblNewGame.setText("NEW GAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(lblNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnGenerateBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreateBoard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnGenerateBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreateBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoadBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBoardActionPerformed
        mw.setPanel(MainWindow.Panels.GenerateBoardPanel);
    }//GEN-LAST:event_btnGenerateBoardActionPerformed

    private void btnCreateBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBoardActionPerformed
        mw.setPanel(MainWindow.Panels.CreateBoardPanel);
    }//GEN-LAST:event_btnCreateBoardActionPerformed

    private void btnLoadBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadBoardActionPerformed
        ((LoadBoardPanel) (mw.getPanel(MainWindow.Panels.LoadBoardPanel))).updateList();
        mw.setPanel(MainWindow.Panels.LoadBoardPanel);
    }//GEN-LAST:event_btnLoadBoardActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        mw.setPanel(MainWindow.Panels.MainMenuPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateBoard;
    private javax.swing.JButton btnGenerateBoard;
    private javax.swing.JButton btnLoadBoard;
    private javax.swing.JLabel lblNewGame;
    // End of variables declaration//GEN-END:variables
}
