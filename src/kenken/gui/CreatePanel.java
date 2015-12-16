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
import kenken.color.BoardColorator;
import kenken.domain.classes.Pos;
import kenken.domain.classes.Region;
import kenken.gui.MainWindow;
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
    private int size;
    
    //Deberias poner aqui un Duration que cada segundo1 del Timer cambie, y que
    //cuando se produzca el evento suba un segundo al Duration, y que sea �ste
    //el que aparezca en pantalla en el lblTime
    /**
     * Creates new form PlayPanel
     */
    public CreatePanel(MainWindow mw) {
        initComponents();
        this.mw = mw;
        spnRegion.setModel(new javax.swing.SpinnerNumberModel(1, 1, countregions, 1));
        cmbOperation.setModel(new javax.swing.DefaultComboBoxModel(Region.OperationType.values()));
        editorPanel1.setCreatorController(mw.getCreatorController());
    }
    
    /**
     * Initializes a Board.
     * @param size Indicates the size of the Board.
     */
    public void initBoard(int size) {
        this.size = size;
        countregions = 1;
        editing = false;
        spnRegion.setModel(new javax.swing.SpinnerNumberModel(1, 1, countregions, 1));
        cmbOperation.setModel(new javax.swing.DefaultComboBoxModel(Region.OperationType.values()));
        txtResult.setText("1");
        btnSaveBoard.setEnabled(false);
        btnCheckBoard.setEnabled(true);
        btnClear.setEnabled(true);
        txtResult.setEditable(true);
        
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

        btnClear = new javax.swing.JButton();
        btnCheckBoard = new javax.swing.JButton();
        lblShowStatus = new javax.swing.JLabel();
        editorPanel1 = new kenken.gui.EditorPanel();
        btnSaveBoard = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblResult = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();
        lblRegion = new javax.swing.JLabel();
        btnMakeRegion = new javax.swing.JButton();
        lblOperation = new javax.swing.JLabel();
        cmbOperation = new javax.swing.JComboBox();
        spnRegion = new javax.swing.JSpinner();
        btnExit = new javax.swing.JButton();
        lblCheking = new javax.swing.JLabel();

        btnClear.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.setToolTipText("");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCheckBoard.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnCheckBoard.setText("FIND SOLUTION");
        btnCheckBoard.setToolTipText("");
        btnCheckBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckBoardActionPerformed(evt);
            }
        });

        lblShowStatus.setFont(new java.awt.Font("Flubber", 0, 14)); // NOI18N

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

        btnHelp.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnHelp.setText("HELP");
        btnHelp.setToolTipText("");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit"));

        lblResult.setFont(new java.awt.Font("Flubber", 0, 14)); // NOI18N
        lblResult.setText("Result:");

        txtResult.setFont(new java.awt.Font("Flubber", 0, 14)); // NOI18N
        txtResult.setText("1");

        lblRegion.setFont(new java.awt.Font("Flubber", 0, 14)); // NOI18N
        lblRegion.setText("Region:");

        btnMakeRegion.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnMakeRegion.setText("Make Region");
        btnMakeRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeRegionActionPerformed(evt);
            }
        });

        lblOperation.setFont(new java.awt.Font("Flubber", 0, 14)); // NOI18N
        lblOperation.setText("Operation:");

        cmbOperation.setFont(new java.awt.Font("Flubber", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegion)
                .addGap(18, 18, 18)
                .addComponent(spnRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblOperation)
                .addGap(18, 18, 18)
                .addComponent(cmbOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResult)
                .addGap(18, 18, 18)
                .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMakeRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(spnRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblRegion)
                .addComponent(lblOperation)
                .addComponent(cmbOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblResult)
                .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnMakeRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnExit.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.setToolTipText("");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblShowStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnCheckBoard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnSaveBoard))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(editorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(lblCheking, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblShowStatus)
                .addGap(5, 5, 5)
                .addComponent(lblCheking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCheckBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Shows up a Confirmation Dialog and switches to Main Menu Panel.
     * @param evt Event trigger.
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit? All changes in board will be not saved.", "Warning", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            mw.setPanel(MainWindow.Panels.MainMenuPanel);
        }
    }                                       
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        mw.getCreatorController().initNewBoard(size);      
        initBoard(size);
        repaint();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * Checks if the Board have a solution.
     * @param evt Event trigger.
     */
    private void btnCheckBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckBoardActionPerformed
        Object[] options = {"OK"};
        btnCheckBoard.setEnabled(false);
        btnClear.setEnabled(false);
        boolean correct = mw.getCreatorController().resolve(editorPanel1.getInfoCells());
        lblCheking.setText("Checking... ");
       
        if (correct){
            ArrayList<ArrayList<Integer>> values = mw.getCreatorController().getUserValues();
            lblCheking.setText("");
            btnSaveBoard.setEnabled(true);
            JOptionPane.showOptionDialog(this,"This Board have a correct solution!.","Correct",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            
            ArrayList<ArrayList<InfoCell>> infoCells = editorPanel1.getInfoCells();
            
            for (int f = 0; f < infoCells.size(); ++f) {
                for (int c = 0; c < infoCells.size(); ++c) {
                    
                    infoCells.get(f).get(c).value = String.valueOf(values.get(f).get(c));
                }
            }  
            repaint();
        }else{
            lblCheking.setText("");
            btnCheckBoard.setEnabled(true);
            btnClear.setEnabled(true);
            JOptionPane.showOptionDialog(this,"This Board DO NOT have a correct solution.","Inorrect",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btnCheckBoardActionPerformed

    /**
     * Let us to a create a shape for a region.
     * @param evt Event trigger.
     */
    private void btnMakeRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeRegionActionPerformed
        
        if(!editing) {
            
            editorPanel1.setEditRegionMode(true);
            Integer regionNumber = (Integer) spnRegion.getValue();
            String operation = convertToSimbol((Region.OperationType)cmbOperation.getSelectedItem());
            String result = txtResult.getText();
            
            editorPanel1.setEditRegionNumber(regionNumber);
            editorPanel1.setEditRegionOperation(operation);
            editorPanel1.setEditRegionResult(result);
            btnMakeRegion.setText("End Region");
            
            spnRegion.setEnabled(false);
            cmbOperation.setEnabled(false);
            editing = true;
            txtResult.setEditable(false);
            
            if (!mw.getCreatorController().existRegion(regionNumber)) {
               Region.OperationType op =  convertToOperation(operation);
                              
               mw.getCreatorController().addRegion(regionNumber, op, Integer.parseInt(result), true);
            }
        }
        else {
            txtResult.setEditable(true);
            editorPanel1.setEditRegionMode(false);
            btnMakeRegion.setText("Make Region");
            
            spnRegion.setModel(new javax.swing.SpinnerNumberModel(1, 1, ++countregions, 1));
            spnRegion.setValue(countregions);
            
            spnRegion.setEnabled(true);
            cmbOperation.setEnabled(true);
            editing = false;
        }
        
    }//GEN-LAST:event_btnMakeRegionActionPerformed

    /**
     * Saves the Board if haves a solution.
     * @param evt 
     */
    private void btnSaveBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBoardActionPerformed
        Object[] options = {"OK"};
        int result = -1;
        String message = "Insert Board name:";
        while (result == -1){
            String boardname =  JOptionPane.showInputDialog(this, message, "Save",
                    JOptionPane.QUESTION_MESSAGE);    
            if (boardname != "") {
                result = mw.getCreatorController().saveBoard(boardname,mw.getUserController().getUsername());
                message = "Boardname in use. Please insert another Board name:";
            }else{
                message = "Please insert a Board name:";
            }     
        }
        if (result == 0){  
            JOptionPane.showOptionDialog(this,"Board saved.","Success",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            btnSaveBoard.setEnabled(false);
            mw.getUserController().incrementTotalCreatedBoards();
            ((MainMenuPanel) mw.getPanel(MainWindow.Panels.MainMenuPanel)).updateList();
            mw.setPanel(MainWindow.Panels.MainMenuPanel);
            mw.getUserController().updateUser();
        }else{
            JOptionPane.showOptionDialog(this,"Internal Error.","Error",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btnSaveBoardActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHelpActionPerformed

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
    
    /**
     * Converts a symbol of a region to a OperationType.
     * @param symbol Symbol wanted to convert.
     * @return An OperationType related to its symbol.
     */
    public Region.OperationType convertToOperation(String symbol){ 

        switch(symbol) {
            case "+":
                return Region.OperationType.Add;
            case "-":
                return Region.OperationType.Subtract;
            case "*":
                return Region.OperationType.Multiply;
            case "/":
                return Region.OperationType.Divide;
            case "":
                return Region.OperationType.None;
            default:
                throw new AssertionError("Simbolo desconocido.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckBoard;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnMakeRegion;
    private javax.swing.JButton btnSaveBoard;
    private javax.swing.JComboBox cmbOperation;
    private kenken.gui.EditorPanel editorPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCheking;
    private javax.swing.JLabel lblOperation;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblShowStatus;
    private javax.swing.JSpinner spnRegion;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
