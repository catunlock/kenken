/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import kenken.domain.classes.Pos;
import kenken.domain.classes.Region;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author SuNLoCK
 */
public class CreatePanel extends javax.swing.JPanel {
    private MainWindow mw;
    private boolean editing = false;
    private int countregions = 1;
    
    //Deberías poner aquí un Duration que cada segundo1 del Timer cambie, y que
    //cuando se produzca el evento suba un segundo al Duration, y que sea éste
    //el que aparezca en pantalla en el lblTime
    /**
     * Creates new form PlayPanel
     */
    public CreatePanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
        spnRegion.setModel(new javax.swing.SpinnerNumberModel(1, 1, countregions, 1));
        cmbOperation.setModel(new javax.swing.DefaultComboBoxModel(Region.OperationType.values()));
    }
    
    public void initBoard(int size) {
        ArrayList<ArrayList<InfoCell>> infoCells = new ArrayList<>(size);
        
        for (int i = 0; i < size; ++i) 
        {
            infoCells.add(new ArrayList<>(size));
            for (int j = 0; j < size; ++j) 
            {
                infoCells.get(i).add(new InfoCell());
            }
        }
        editorPanel1.setInfoCells(infoCells);
        editorPanel1.setShowRegionNumber(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
       
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        btnCheckBoard = new javax.swing.JButton();
        btnMakeRegion = new javax.swing.JButton();
        spnRegion = new javax.swing.JSpinner();
        cmbOperation = new javax.swing.JComboBox();
        lblRegion = new javax.swing.JLabel();
        lblOperation = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblShowStatus = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();
        editorPanel1 = new kenken.gui.EditorPanel();
        btnSaveBoard = new javax.swing.JButton();

        btnExit.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.setToolTipText("");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCheckBoard.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnCheckBoard.setText("CHECK BOARD");
        btnCheckBoard.setToolTipText("");
        btnCheckBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckBoardActionPerformed(evt);
            }
        });

        btnMakeRegion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMakeRegion.setText("Make Region");
        btnMakeRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeRegionActionPerformed(evt);
            }
        });

        cmbOperation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblRegion.setText("Region:");

        lblOperation.setText("Operation:");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblStatus.setText("Status: ");

        lblShowStatus.setText("lblStatus");

        lblResult.setText("Result:");

        txtResult.setText("0");

        javax.swing.GroupLayout editorPanel1Layout = new javax.swing.GroupLayout(editorPanel1);
        editorPanel1.setLayout(editorPanel1Layout);
        editorPanel1Layout.setHorizontalGroup(
            editorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );
        editorPanel1Layout.setVerticalGroup(
            editorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        btnSaveBoard.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnSaveBoard.setText("SAVE BOARD");
        btnSaveBoard.setToolTipText("");
        btnSaveBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBoardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMakeRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRegion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblOperation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblShowStatus)
                .addGap(182, 182, 182)
                .addComponent(btnCheckBoard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveBoard)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMakeRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegion)
                    .addComponent(lblOperation)
                    .addComponent(lblResult)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(lblShowStatus)
                    .addComponent(btnSaveBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit? All changes in board will be not saved.", "Warning", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            mw.setPanel(MainWindow.Panels.MainMenuPanel);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCheckBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckBoardActionPerformed
        boolean correct = mw.getGameController().resolve();
        if (correct){
            JOptionPane.showConfirmDialog(this, "This Board have a correct solution.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showConfirmDialog(this, "This Board DO NOT have a correct solution.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCheckBoardActionPerformed

    private void btnMakeRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeRegionActionPerformed
        
        if(! editing) {

            editorPanel1.setEditRegionMode(true);
            Integer regionNumber = (Integer) spnRegion.getValue();
            String operation = convertToSimbol((Region.OperationType)cmbOperation.getSelectedItem());
            
            editorPanel1.setEditRegionNumber(regionNumber);
            editorPanel1.setEditRegionOperation(operation);
            btnMakeRegion.setText("End Region");
            
            spnRegion.setEnabled(false);
            cmbOperation.setEnabled(false);
            editing = true;
        }
        else {
            editorPanel1.setEditRegionMode(false);
            btnMakeRegion.setText("Make Region");
            
            spnRegion.setModel(new javax.swing.SpinnerNumberModel(1, 1, ++countregions, 1));
            spnRegion.setValue(countregions);
            
            spnRegion.setEnabled(true);
            cmbOperation.setEnabled(true);
            editing = false;
        }
        
    }//GEN-LAST:event_btnMakeRegionActionPerformed

    private void btnSaveBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBoardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveBoardActionPerformed

    private String convertToSimbol(Region.OperationType op) {
        switch(op) {
            case Add:
                return "+";
            case Subtract:
                return "-";
            case Multiply:
                return "*";
            case Divide:
                return "/";
            case None:
                return "";
            default:
                throw new AssertionError(op.name());

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckBoard;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMakeRegion;
    private javax.swing.JButton btnSaveBoard;
    private javax.swing.JComboBox cmbOperation;
    private kenken.gui.EditorPanel editorPanel1;
    private javax.swing.JLabel lblOperation;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblShowStatus;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JSpinner spnRegion;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
