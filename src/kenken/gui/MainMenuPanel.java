/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import kenken.domain.classes.BoardInfo;
import kenken.domain.classes.User;
import kenken.domain.controllers.BoardController;
import kenken.domain.controllers.UserController;
import kenken.persistance.controllers.RankingDBController;
import kenken.domain.controllers.UserDataGetter;

/**
 *
 * @author asus
 */
public class MainMenuPanel extends javax.swing.JPanel {

    
    private MainWindow mw;
    private String user;
    private UserController uc;
    private Component modalToComponent;
    private BoardController bc;
    
    /**
     * Creates new form MainMenuPanel
     * @param mw
     */
    public MainMenuPanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
        this.uc = this.mw.getUserController();
        this.bc = this.mw.getBoardController();
    }

    public void setUser(String user){
        ArrayList<String> userData = mw.getUserDataGetter().toString(uc) ;
        String solved, created, played;
        played = userData.get(0);
        created = userData.get(1);
        solved = userData.get(2);
        this.user = user;
        lblMainMenu.setText("Welcome, " + user);
        User temp = this.uc.getLoggedUser();
        lblBoardsCreatedTarget.setText(created);
        lblBoardsResolvedTarget.setText(solved);
        lblTimePlayedTarget.setText(played);
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
        lblCreatedBoards = new javax.swing.JLabel();
        lblResolvedBoards = new javax.swing.JLabel();
        lblTimePlayedTarget = new javax.swing.JLabel();
        lblBoardsCreatedTarget = new javax.swing.JLabel();
        lblBoardsResolvedTarget = new javax.swing.JLabel();
        lblMainMenu = new javax.swing.JLabel();
        btnLoadGame = new javax.swing.JButton();
        btnOptions = new javax.swing.JButton();
        btnDeleteBoard = new javax.swing.JButton();

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
        btnImportBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportBoardActionPerformed(evt);
            }
        });

        btnCreateBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnCreateBoard.setText("Create Board");
        btnCreateBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateBoardMouseClicked(evt);
            }
        });
        btnCreateBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBoardActionPerformed(evt);
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

        lblCreatedBoards.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblCreatedBoards.setText("Boards created: ");

        lblResolvedBoards.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblResolvedBoards.setText("Boards resolved:");

        lblTimePlayedTarget.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTimePlayedTarget.setText("-");

        lblBoardsCreatedTarget.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBoardsCreatedTarget.setText("-");

        lblBoardsResolvedTarget.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBoardsResolvedTarget.setText("-");

        javax.swing.GroupLayout pnlStatisticsLayout = new javax.swing.GroupLayout(pnlStatistics);
        pnlStatistics.setLayout(pnlStatisticsLayout);
        pnlStatisticsLayout.setHorizontalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblResolvedBoards)
                    .addComponent(lblCreatedBoards)
                    .addComponent(lblPlayedTime))
                .addGap(26, 26, 26)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTimePlayedTarget, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(lblBoardsResolvedTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBoardsCreatedTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        pnlStatisticsLayout.setVerticalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayedTime)
                    .addComponent(lblTimePlayedTarget))
                .addGap(18, 18, 18)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreatedBoards)
                    .addComponent(lblBoardsCreatedTarget))
                .addGap(18, 18, 18)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResolvedBoards)
                    .addComponent(lblBoardsResolvedTarget))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        lblMainMenu.setFont(new java.awt.Font("Flubber", 0, 48)); // NOI18N
        lblMainMenu.setText("Welcome back,  ");
        lblMainMenu.setToolTipText("");

        btnLoadGame.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnLoadGame.setText("Load Game");
        btnLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadGameActionPerformed(evt);
            }
        });

        btnOptions.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnOptions.setText("Delete account");
        btnOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsActionPerformed(evt);
            }
        });

        btnDeleteBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnDeleteBoard.setText("Delete Board");
        btnDeleteBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBoardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOptions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(lblMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDeleteBoard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreateBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(btnLoadGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnExportBoard)
                    .addComponent(btnImportBoard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnShowRanking)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblStatistics)
                        .addGap(236, 236, 236))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lblMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImportBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblStatistics)
                        .addGap(32, 32, 32)
                        .addComponent(pnlStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        mw.setPanel(MainWindow.Panels.NewGamePanel);
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnShowRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRankingActionPerformed
        ((ChooseRankingPanel) mw.getPanel(MainWindow.Panels.ChooseRankingPanel)).setRankingList();
        mw.setPanel(MainWindow.Panels.ChooseRankingPanel);
    }//GEN-LAST:event_btnShowRankingActionPerformed

    private void btnExportBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportBoardMouseClicked
        ((ExportBoardPanel) mw.getPanel(MainWindow.Panels.ExportBoardPanel)).updateList();
        mw.setPanel(MainWindow.Panels.ExportBoardPanel);
    }//GEN-LAST:event_btnExportBoardMouseClicked

    private void btnCreateBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateBoardMouseClicked
        mw.setPanel(MainWindow.Panels.CreateBoardPanel);
    }//GEN-LAST:event_btnCreateBoardMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            ((LoginPanel) mw.getPanel(MainWindow.Panels.LoginPanel)).clearTxt();
            mw.setPanel(MainWindow.Panels.LoginPanel);
        }
    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadGameActionPerformed
        ((LoadGamePanel) mw.getPanel(MainWindow.Panels.LoadGamePanel)).initPanel();
        mw.setPanel(MainWindow.Panels.LoadGamePanel);
        
    }//GEN-LAST:event_btnLoadGameActionPerformed

    private void btnOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsActionPerformed
        mw.setPanel(MainWindow.Panels.OptionsPanel);
    }//GEN-LAST:event_btnOptionsActionPerformed

    private void btnImportBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportBoardActionPerformed
        JFileChooser fileChoose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".brd", "brd");
        fileChoose.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChoose.setFileFilter(filter);
        if (fileChoose.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION){
            File file = fileChoose.getSelectedFile();
            if (file != null){
                int res = bc.importBoard(file);
                if (res == 0) JOptionPane.showMessageDialog(modalToComponent, "The Board has been imported.");
                else if (res == -1) JOptionPane.showMessageDialog(modalToComponent, "The Board was already in the database.");
                else JOptionPane.showMessageDialog(modalToComponent, "There was an internal error.");
            }
        }
    }//GEN-LAST:event_btnImportBoardActionPerformed

    private void btnCreateBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBoardActionPerformed
         mw.setPanel(MainWindow.Panels.CreateBoardPanel);
    }//GEN-LAST:event_btnCreateBoardActionPerformed

    private void btnDeleteBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBoardActionPerformed
        ((DeleteBoardPanel) mw.getPanel(MainWindow.Panels.DeleteBoardPanel)).updateList();
        mw.setPanel(MainWindow.Panels.DeleteBoardPanel);
    }//GEN-LAST:event_btnDeleteBoardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateBoard;
    private javax.swing.JButton btnDeleteBoard;
    private javax.swing.JButton btnExportBoard;
    private javax.swing.JButton btnImportBoard;
    private javax.swing.JButton btnLoadGame;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnShowRanking;
    private javax.swing.JLabel lblBoardsCreatedTarget;
    private javax.swing.JLabel lblBoardsResolvedTarget;
    private javax.swing.JLabel lblCreatedBoards;
    private javax.swing.JLabel lblMainMenu;
    private javax.swing.JLabel lblPlayedTime;
    private javax.swing.JLabel lblResolvedBoards;
    private javax.swing.JLabel lblStatistics;
    private javax.swing.JLabel lblTimePlayedTarget;
    private javax.swing.JPanel pnlStatistics;
    // End of variables declaration//GEN-END:variables
}
