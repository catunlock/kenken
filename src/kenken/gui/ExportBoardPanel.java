/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import kenken.domain.classes.Board;
import kenken.domain.classes.BoardInfo;

/**
 *
 * @author SuNLoCK
 */
public class ExportBoardPanel extends javax.swing.JPanel {
    private DefaultListModel listModel;
    
    private ArrayList<BoardInfo> infoBoard = new ArrayList<>();
    private Component modalToComponent;
        
    private MainWindow mw;
    /**
     * Creates new form ExportBoardPanel
     */
    public ExportBoardPanel(MainWindow mw) {
        initComponents();
        
        this.mw = mw;
    }

    ExportBoardPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Sets the Board list every time ExportBoardPanel is retrieved.
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

        lblShowTamany = new javax.swing.JLabel();
        lblSelectBoard = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        lblExport = new javax.swing.JLabel();
        scrllBoards = new javax.swing.JScrollPane();
        modelo=new DefaultListModel();
        lstBoards = new javax.swing.JList();
        lblCreador = new javax.swing.JLabel();
        lblTamany = new javax.swing.JLabel();
        lblShowCreador = new javax.swing.JLabel();

        lblShowTamany.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N

        lblSelectBoard.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblSelectBoard.setText("Select Board:");
        lblSelectBoard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblInfo.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        lblInfo.setText("Info:");
        lblInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnBack.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnExport.setFont(new java.awt.Font("Flubber", 0, 24)); // NOI18N
        btnExport.setText("EXPORT");
        btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });

        lblExport.setFont(new java.awt.Font("Flubber", 0, 48)); // NOI18N
        lblExport.setText("EXPORT BOARD");
        lblExport.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        scrllBoards.setToolTipText("");
        scrllBoards.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lstBoards.setFont(new java.awt.Font("Flubber", 0, 24));
        lstBoards.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstBoardsValueChanged(evt);
            }
        });
        scrllBoards.setViewportView(lstBoards);

        lblCreador.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblCreador.setText("Creador:");

        lblTamany.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblTamany.setText("Tamany:");

        lblShowCreador.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(417, 417, 417))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(scrllBoards, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSelectBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(lblInfo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblShowCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblShowTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(112, 112, 112))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(lblExport)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblExport, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(lblSelectBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(scrllBoards, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(lblInfo)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblShowCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblShowTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCreador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTamany, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Switches to Main Menu Panel when Back button is pressed.
     * @param evt Event trigger.
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        mw.setPanel(MainWindow.Panels.MainMenuPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Exports a Board when a board is selected from the list and export button is pressed.
     * @param evt 
     */
    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        BoardInfo bi = infoBoard.get(lstBoards.getSelectedIndex());
        fileChooser.setSelectedFile(new File(bi.getName()+".brd"));
        if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            if(file !=null){
                mw.getBoardController().saveBoard(bi.getName(), file);             
                JOptionPane.showMessageDialog(null,
                    "El archivo se a guardado Exitosamente",
                    "Información",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExportMouseClicked

    /**
     * Changes the info of the board selected displayed on the panel.
     * @param evt Event trigger.
     */
    private void lstBoardsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBoardsValueChanged
        BoardInfo bi = infoBoard.get(lstBoards.getSelectedIndex());
        lblShowCreador.setText(bi.getCreador());
        lblShowTamany.setText(bi.getSize());
    }//GEN-LAST:event_lstBoardsValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExport;
    private javax.swing.JLabel lblCreador;
    private javax.swing.JLabel lblExport;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblSelectBoard;
    private javax.swing.JLabel lblShowCreador;
    private javax.swing.JLabel lblShowTamany;
    private javax.swing.JLabel lblTamany;
    private javax.swing.JList lstBoards;
    private DefaultListModel modelo;
    private javax.swing.JScrollPane scrllBoards;
    // End of variables declaration//GEN-END:variables
}
