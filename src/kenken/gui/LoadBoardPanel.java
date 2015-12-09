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
    /**
     * Creates new form LoadBoardPanel
     * @param mw
     */
    public LoadBoardPanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
    }

    
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
        btnDelete = new javax.swing.JButton();
        lblLoadBoard = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblCreador = new javax.swing.JLabel();
        lblTamany = new javax.swing.JLabel();
        lblShowCreador = new javax.swing.JLabel();
        lblShowTamany = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scrllBoards = new javax.swing.JScrollPane();
        modelo=new DefaultListModel();
        lstBoards = new javax.swing.JList();

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

        jLabel4.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        jLabel4.setText("Select Board:");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        jLabel2.setText("Info:");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
                        .addGap(222, 222, 222)
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblLoadBoard))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrllBoards, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblShowCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblShowTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblLoadBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
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
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        BoardInfo bi = infoBoard.get(lstBoards.getSelectedIndex());
        int n = JOptionPane.showConfirmDialog(this, "Are you sure that you want to delete " + bi.getName() + " board?", "Warning", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            //eliminar la board
            int result = mw.getBoardController().deleteBoard(bi.getName());
            if (result == 0){
                JOptionPane.showMessageDialog(null,
                    "Board deleted.",
                    "Información",JOptionPane.INFORMATION_MESSAGE);
                updateList();
            }else{
                JOptionPane.showMessageDialog(null,
                    "Internal Error",
                    "Información",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        mw.setPanel(MainWindow.Panels.NewGamePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void lstBoardsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBoardsValueChanged
        BoardInfo bi = infoBoard.get(lstBoards.getSelectedIndex());
        lblShowCreador.setText(bi.getCreador());
        lblShowTamany.setText(bi.getSize());
    }//GEN-LAST:event_lstBoardsValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCreador;
    private javax.swing.JLabel lblLoadBoard;
    private javax.swing.JLabel lblShowCreador;
    private javax.swing.JLabel lblShowTamany;
    private javax.swing.JLabel lblTamany;
    private javax.swing.JList lstBoards;
    private DefaultListModel modelo;
    private javax.swing.JScrollPane scrllBoards;
    // End of variables declaration//GEN-END:variables
}
