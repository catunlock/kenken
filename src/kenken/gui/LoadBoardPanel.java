/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import kenken.domain.classes.BoardInfo;

/**
 *
 * @author Marc
 */
public class LoadBoardPanel extends javax.swing.JPanel {

    private MainWindow mw;
    private DefaultListModel listModel;
    private ArrayList<BoardInfo> infoBoard = new ArrayList<>();
    private String boardNameSelected;
    private String modo = "Normal";
    
    /**
     * Creates new form LoadBoardPanel
     * @param mw Main Window Controller.
     */
    public LoadBoardPanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
    }

    /**
     * Sets the Boards list every time LoadBoardPanel is accessed.
     */
    public void updateList(){
        listModel = new DefaultListModel();
        
        infoBoard = mw.getBoardController().getBoardsInfo();
        if (infoBoard != null){
            for(BoardInfo bInf : infoBoard){
                listModel.addElement(bInf.getName());
            }
        }
        lstBoards.setModel(listModel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoad = new javax.swing.JButton();
        lblLoadBoard = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblCreador = new javax.swing.JLabel();
        lblTamany = new javax.swing.JLabel();
        lblShowCreador = new javax.swing.JLabel();
        lblShowTamany = new javax.swing.JLabel();
        lblSelectBoard = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        scrllBoards = new javax.swing.JScrollPane();
        modelo=new DefaultListModel();
        lstBoards = new javax.swing.JList();

        btnLoad.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnLoad.setText("PLAY");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        lblLoadBoard.setFont(new java.awt.Font("Flubber", 0, 48)); // NOI18N
        lblLoadBoard.setText("LOAD BOARD");

        btnBack.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblCreador.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblCreador.setText("Creador:");

        lblTamany.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblTamany.setText("Tamany:");

        lblShowCreador.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N

        lblShowTamany.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N

        lblSelectBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblSelectBoard.setText("Select Board:");
        lblSelectBoard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblInfo.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblInfo.setText("Info:");
        lblInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        scrllBoards.setToolTipText("");
        scrllBoards.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lstBoards.setFont(new java.awt.Font("Flubber", 0, 24));
        lstBoards.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstBoardsValueChanged(evt);
            }
        });
        scrllBoards.setViewportView(lstBoards);

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
                        .addGap(319, 319, 319)
                        .addComponent(lblLoadBoard))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrllBoards, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(lblSelectBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInfo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblShowCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblShowTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblLoadBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfo))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrllBoards, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblShowCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblShowTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Loads the selected board from the list and the game begins.
     * @param evt Event trigger.
     */
    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        PlayPanel pp = (PlayPanel) mw.getPanel(MainWindow.Panels.PlayPanel);
        
        mw.getGameController().newGame(boardNameSelected, modo);
        pp.initBoard(mw.getGameController().getInfoBoard());
        
        mw.setPanel(MainWindow.Panels.PlayPanel);
        ((PlayPanel) mw.getPanel(MainWindow.Panels.PlayPanel)).initTime();
    }//GEN-LAST:event_btnLoadActionPerformed

    /**
     * Switches to New Game Panel when Back button is pressed.
     * @param evt Event trigger.
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        mw.setPanel(MainWindow.Panels.NewGamePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Changes the information about the board displayed.
     * @param evt Event trigger.
     */
    private void lstBoardsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBoardsValueChanged
        BoardInfo bi = infoBoard.get(lstBoards.getSelectedIndex());
        lblShowCreador.setText(bi.getCreador());
        lblShowTamany.setText(bi.getSize());
        boardNameSelected = bi.getName();
    }//GEN-LAST:event_lstBoardsValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLoad;
    private javax.swing.JLabel lblCreador;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLoadBoard;
    private javax.swing.JLabel lblSelectBoard;
    private javax.swing.JLabel lblShowCreador;
    private javax.swing.JLabel lblShowTamany;
    private javax.swing.JLabel lblTamany;
    private javax.swing.JList lstBoards;
    private DefaultListModel modelo;
    private javax.swing.JScrollPane scrllBoards;
    // End of variables declaration//GEN-END:variables
}
