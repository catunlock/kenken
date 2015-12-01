/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

/**
 *
 * @author asus
 */
public class MainMenuPanel extends javax.swing.JPanel {

    
    private MainWindow mw;
    /**
     * Creates new form MainMenuPanel
     */
    public MainMenuPanel(MainWindow mw) {
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

        btnExportBoard = new javax.swing.JButton();
        btnNewGame = new javax.swing.JButton();
        btnImportBoard = new javax.swing.JButton();
        btnCreateBoard = new javax.swing.JButton();
        btnShowRanking = new javax.swing.JButton();
        lblStatistics = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        pnlStatistics = new javax.swing.JPanel();
        lblPlayedTime = new javax.swing.JLabel();
        lblCreatedGames = new javax.swing.JLabel();
        lblResolvedGames = new javax.swing.JLabel();
        lblMainMenu = new javax.swing.JLabel();
        btnLoadGame = new javax.swing.JButton();
        btnOptions = new javax.swing.JButton();

        btnExportBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnExportBoard.setText("Export Board");
        btnExportBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportBoardMouseClicked(evt);
            }
        });

        btnNewGame.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnNewGame.setText("New Game");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        btnImportBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnImportBoard.setText("Import Board");

        btnCreateBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnCreateBoard.setText("Create Board");
        btnCreateBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateBoardMouseClicked(evt);
            }
        });

        btnShowRanking.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnShowRanking.setText("Show Ranking");
        btnShowRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRankingActionPerformed(evt);
            }
        });

        lblStatistics.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblStatistics.setText("User Statistics:");

        btnLogOut.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnLogOut.setText("Logout");
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });

        lblPlayedTime.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblPlayedTime.setText("Total Time Played: ");

        lblCreatedGames.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblCreatedGames.setText("Games created: ");

        lblResolvedGames.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblResolvedGames.setText("Games resolved:");

        javax.swing.GroupLayout pnlStatisticsLayout = new javax.swing.GroupLayout(pnlStatistics);
        pnlStatistics.setLayout(pnlStatisticsLayout);
        pnlStatisticsLayout.setHorizontalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblResolvedGames)
                    .addComponent(lblCreatedGames)
                    .addComponent(lblPlayedTime))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        pnlStatisticsLayout.setVerticalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblPlayedTime)
                .addGap(18, 18, 18)
                .addComponent(lblCreatedGames)
                .addGap(18, 18, 18)
                .addComponent(lblResolvedGames)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        lblMainMenu.setFont(new java.awt.Font("Flubber", 0, 48)); // NOI18N
        lblMainMenu.setText("Welcome Back, <UserName>");
        lblMainMenu.setToolTipText("");

        btnLoadGame.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnLoadGame.setText("Load Game");

        btnOptions.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnOptions.setText("Options");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreateBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImportBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblStatistics)
                                .addGap(138, 138, 138))
                            .addComponent(pnlStatistics, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnShowRanking)
                                .addGap(110, 110, 110))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(73, Short.MAX_VALUE)
                        .addComponent(lblMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatistics)
                        .addGap(18, 18, 18)
                        .addComponent(pnlStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreateBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImportBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExportBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnShowRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRankingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowRankingActionPerformed

    private void btnExportBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportBoardMouseClicked
        mw.setPanel(MainWindow.Panels.ExportBoardPanel);
    }//GEN-LAST:event_btnExportBoardMouseClicked

    private void btnCreateBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateBoardMouseClicked
        mw.setPanel(MainWindow.Panels.CreateBoardPanel);
    }//GEN-LAST:event_btnCreateBoardMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        mw.setPanel(MainWindow.Panels.EndGamePanel);
    }//GEN-LAST:event_btnLogOutMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateBoard;
    private javax.swing.JButton btnExportBoard;
    private javax.swing.JButton btnImportBoard;
    private javax.swing.JButton btnLoadGame;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnShowRanking;
    private javax.swing.JLabel lblCreatedGames;
    private javax.swing.JLabel lblMainMenu;
    private javax.swing.JLabel lblPlayedTime;
    private javax.swing.JLabel lblResolvedGames;
    private javax.swing.JLabel lblStatistics;
    private javax.swing.JPanel pnlStatistics;
    // End of variables declaration//GEN-END:variables
}
