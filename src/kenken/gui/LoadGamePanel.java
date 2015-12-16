/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import kenken.domain.controllers.*;

/**
 *
 * @author Marc
 */
public class LoadGamePanel extends javax.swing.JPanel {

    private MainWindow mw;
    private UserControllerKenken uc;
    private GameController gc;
    ArrayList<String> games;
    /**
     * Creates a form of LoadGamePanel.
     * @param mw Main Window Controller.
     */
    public LoadGamePanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
    }
    
    /**
     * Initializes the Panel.
     */
    public void initPanel(){
        uc = mw.getUserController();
        gc = new GameController();
        Vector gamesvec = new Vector();
        games = gc.getSavedGames(uc);
        for (int i = 0; i<games.size(); ++i){
            gamesvec.addElement(games.get(i));
        }
        lstGames.setListData(gamesvec);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrllGames = new javax.swing.JScrollPane();
        lstGames = new javax.swing.JList();
        lblSelectSavedGame = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblLoadGame = new javax.swing.JLabel();

        lstGames.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        scrllGames.setViewportView(lstGames);

        lblSelectSavedGame.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblSelectSavedGame.setText("Select Saved Game:");

        btnBack.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLoad.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnLoad.setText("LOAD");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblLoadGame.setFont(new java.awt.Font("Flubber", 0, 48)); // NOI18N
        lblLoadGame.setText("LOAD GAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(scrllGames, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(lblSelectSavedGame, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(lblLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(lblSelectSavedGame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrllGames, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Switches to Main Menu Panel when Back button is pressed.
     * @param evt Event trigger.
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        mw.setPanel(MainWindow.Panels.MainMenuPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Load the selected game from the list and switches to play panel.
     * @param evt Event trigger.
     */
    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        ArrayList<Integer> data = mw.getGameController().loadGame(mw.getUserController().getLoggedUser().getUsername(), (String) lstGames.getSelectedValue());
        int time = mw.getGameController().getTime();
        ((PlayPanel) mw.getPanel(MainWindow.Panels.PlayPanel)).clearPanel();
        ((PlayPanel) mw.getPanel(MainWindow.Panels.PlayPanel)).initBoard(mw.getGameController().getInfoBoard());
        ((PlayPanel) mw.getPanel(MainWindow.Panels.PlayPanel)).setTime(time);
        ((PlayPanel) mw.getPanel(MainWindow.Panels.PlayPanel)).setValues(data);
        //((PlayPanel) mw.getPanel(MainWindow.Panels.PlayPanel)).initTime();
        mw.setPanel(MainWindow.Panels.PlayPanel);
    }//GEN-LAST:event_btnLoadActionPerformed

    /**
     * Deletes the selected game from the list and shows up a confirm dialog to erase the game.
     * @param evt Event trigger.
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String gameToDelete = (String) lstGames.getSelectedValue();
        if (gameToDelete == null) JOptionPane.showMessageDialog(this, "Please select a game to delete", "Select a game", JOptionPane.WARNING_MESSAGE);
        else {
            int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this saved game?", "Delete game", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                gc.deleteSavedGame(uc, gameToDelete);
                this.initPanel();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JLabel lblLoadGame;
    private javax.swing.JLabel lblSelectSavedGame;
    private javax.swing.JList lstGames;
    private javax.swing.JScrollPane scrllGames;
    // End of variables declaration//GEN-END:variables
}
