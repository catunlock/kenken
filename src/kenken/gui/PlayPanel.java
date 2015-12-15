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
import javax.swing.JOptionPane;
import javax.swing.Timer;
import kenken.domain.classes.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author SuNLoCK
 */
public class PlayPanel extends javax.swing.JPanel {
    private MainWindow mw;
    private Duration time;
    private String gamemode;
    private Timer timer;
    private int segThisGame, segTotal, segundos, minutos, horas;
    private boolean loadedGame = false;
    AudioPlayer ap = AudioPlayer.player;
    InputStream in;
    AudioStream audio;
    boolean musicOn = true;
    Game game;
    //Deberías poner aquí un Duration que cada segundo1 del Timer cambie, y que
    //cuando se produzca el evento suba un segundo al Duration, y que sea éste
    //el que aparezca en pantalla en el lblTime
    /**
     * Creates new form PlayPanel
     */
    public PlayPanel(MainWindow mw) {
        initComponents();
        this.mw = mw;     
        timer = new Timer(1000,updateClockAction);
        timer.setRepeats(true);
        boardPanel1.setGameController(mw.getGameController());
        
    }

    public void clearPanel() {
        btnHint.setEnabled(true);
        btnCheck.setEnabled(true);
        btnSurrender.setEnabled(true);
        boardPanel1.setSelectedCell(new Pos(-1,-1));
        
    }
    
    public void setNotLoaded(){
        loadedGame = false;
        mw.getGameController().resetHints();
    }
    
    public void initTime(){
        if (!loadedGame){
            time = Duration.ZERO;
            segTotal = 0;
            segundos = 0;
            minutos = 0;
            horas = 0;
        }
        if (mw.getGameController().getHints() == 0) btnHint.setEnabled(false);
        lblHint.setText("Hints remaining: " + Integer.toString(mw.getGameController().getHints()));
        segThisGame = 0;
        timer.restart();
        try {
            in = new FileInputStream("Robocraft Theme.wav");
            audio = new AudioStream(in);
            ap.start(audio);
            musicOn = true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void initBoard(ArrayList<ArrayList<InfoCell>> matrix) {
        mw.getUserController().incrementStartedGames();
        btnSurrender.setEnabled(true);
        btnHint.setEnabled(true);
        btnCheck.setEnabled(true);
        btnSaveGame.setEnabled(true);
        lblCheck.setText("");
        boardPanel1.setInfoCells(matrix);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void setTime(int time){
        loadedGame = true;
        segTotal = time;
        horas = segTotal/3600;
        minutos = (segTotal/60)%60;
        segundos = segTotal%60;
    }
    
    public void setValues(ArrayList<Integer> data){
        int tamany = mw.getGameController().getInfoBoard().size();
        int x = 0, value;
        for (int i = 0; i < tamany; ++i){
            for (int j = 0; j < tamany; ++j){
                value = data.get(x);
                if (value != 0) {
                    boardPanel1.setValue(i, j, String.valueOf(value));
                }
                else boardPanel1.setValue(i, j, "");
                ++x;
            }
        }
    }
    
    private ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a custom component
            ++segThisGame;
            ++segundos;
            if (segundos == 60) {
                ++minutos;
                segundos = 0;
                if (minutos == 60){
                    ++horas;
                    minutos = 0;
                }
            }
            String horstr, minstr, segstr;
            if (horas < 10) horstr = "0" + Integer.toString(horas);
            else horstr = Integer.toString(horas);
            if (minutos < 10) minstr = "0" + Integer.toString(minutos);
            else minstr = Integer.toString(minutos);
            if (segundos < 10) segstr = "0" + Integer.toString(segundos);
            else segstr = Integer.toString(segundos);
            String timestring = horstr + ":" + minstr + ":" + segstr;
            lblTime.setText(timestring);
            timer.restart();
        }
    };

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
        btnSaveGame = new javax.swing.JButton();
        btnHint = new javax.swing.JButton();
        lblHint = new javax.swing.JLabel();
        boardPanel1 = new kenken.gui.BoardPanel();
        btnCheck = new javax.swing.JButton();
        btnSurrender = new javax.swing.JButton();
        lblCheck = new javax.swing.JLabel();

        btnMusic.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnMusic.setText("MUSIC OFF");
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

        javax.swing.GroupLayout boardPanel1Layout = new javax.swing.GroupLayout(boardPanel1);
        boardPanel1.setLayout(boardPanel1Layout);
        boardPanel1Layout.setHorizontalGroup(
            boardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );
        boardPanel1Layout.setVerticalGroup(
            boardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        btnCheck.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnCheck.setText("CHECK");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnSurrender.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        btnSurrender.setText("SURRENDER");
        btnSurrender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurrenderActionPerformed(evt);
            }
        });

        lblCheck.setFont(new java.awt.Font("Flubber", 0, 18)); // NOI18N
        lblCheck.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(lblHint))
                            .addComponent(btnHint, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(btnMusic)
                        .addGap(32, 32, 32)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSurrender, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveGame)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
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
                            .addComponent(btnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnSurrender, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnSaveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblCheck)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicActionPerformed
         if (musicOn) {
            ap.stop(audio);
            musicOn = false;
            btnMusic.setText("MUSIC ON");
        }
        else {
            ap.start(audio);
            musicOn = true;
            btnMusic.setText("MUSIC OFF");
        }
    }//GEN-LAST:event_btnMusicActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit the game?", "Warning", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            
            if (mw.getUserController().getUsername() == ""){
                ((LoginPanel) mw.getPanel(MainWindow.Panels.LoginPanel)).clearTxt();
                mw.setPanel(MainWindow.Panels.LoginPanel);
            }else{
                mw.setPanel(MainWindow.Panels.MainMenuPanel);
            }
            
            lblTime.setText("00:00:00");
            ap.stop(audio);
            timer.stop();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGameActionPerformed
        int segonsTotals = segTotal+segThisGame;
        String nompartida = JOptionPane.showInputDialog("Type the name of the game you want to save.");
        if (nompartida == null || "null".equals(nompartida) || "".equals(nompartida)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid name.");
        }
        else {
            String username = mw.getUserController().getLoggedUser().getUsername();
            ArrayList<String> data = new ArrayList<>();
            data.add(Integer.toString(segonsTotals));
            data.add(Integer.toString(mw.getGameController().getHints()));
            int tamany = mw.getGameController().getInfoBoard().size();
            for (int i = 0; i < tamany; ++i){
                for (int j = 0; j < tamany; ++j){
                    Pos p = new Pos(i,j);
                    data.add(boardPanel1.getInfoCell(p).value);
                }
            }
            int error = mw.getGameController().updateAndSave(data, username, nompartida);
            if (error == -1) JOptionPane.showMessageDialog(this, "There already is a game called " + nompartida + " in your saved games.");
            else{
                mw.setPanel(MainWindow.Panels.MainMenuPanel);
                lblTime.setText("00:00:00");
                ap.stop(audio);
                timer.stop();
            }
        }
    }//GEN-LAST:event_btnSaveGameActionPerformed

    private void btnHintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHintActionPerformed
         // TODO add your handling code here:
        Pos p = boardPanel1.getSelectedPos();
        int hints = mw.getGameController().getHints();
        
        if (p.f != -1 && p.c != -1 && hints > 0) {
            int hint = mw.getGameController().getHint(p);
            boardPanel1.setHint(p, String.valueOf(hint));
            
            hints = mw.getGameController().getHints();
            lblHint.setText("Hints Remaining: " + hints);
        }
        
        if ( hints == 0) {
            btnHint.setEnabled(false);
        }
    }//GEN-LAST:event_btnHintActionPerformed

    private void btnSurrenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurrenderActionPerformed
        // Mostrar el valor de todas las celdas, poner en rojo las que estan mal
        // en gris las que no estaban, i en verde las que estaban bien.
        
        ArrayList<ArrayList<Integer>> values = mw.getGameController().getSolutionValues();
        
        for (int f = 0; f < values.size(); ++f) {
            for (int c = 0; c < values.size(); ++c) {
                
                InfoCell ic = boardPanel1.getInfoCell(new Pos(f,c));
                int value = values.get(f).get(c);
                
                if (ic.value.equals("")) {
                    ic.value = String.valueOf(value);
                    ic.hinted = true;
                }
                else if (! ic.value.equals("")) {
                    ic.showIsCorrect = true;
                    
                    if (Integer.parseInt(ic.value) ==  value) {
                        ic.correct = true;
                    }else {
                        ic.value = String.valueOf(value);
                        ic.correct = false;
                    }
                }
                
            }
        }
        lblCheck.setText("Maybe next time...");
        ap.stop(audio);
        timer.stop();
        boardPanel1.repaint();
        btnCheck.setEnabled(false);
        btnSaveGame.setEnabled(false);
        btnSurrender.setEnabled(false);
        btnHint.setEnabled(false);
    }//GEN-LAST:event_btnSurrenderActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        lblCheck.setText("Checking...");
        
        // Cojer i comprobar casilla a casilla si los valores que ha introducido
        // el usuario son los que resuelven el kenken.
        boolean wrong = false;
        
        ArrayList<ArrayList<Integer>> values = mw.getGameController().getSolutionValues();     
        
        boolean solucio = mw.getGameController().isCorrect();
        
        if (!solucio) {
            lblCheck.setText("Solucion propuesta incorrecta.");
        }
        else {
            lblCheck.setText("CORRECTO!");
            Object[] options = {"OK"};
            long tiempo = horas*60*60+minutos*60+segundos;
            if(mw.getGameController().isGenerated()){
                ap.stop(audio);
                timer.stop();
                /*in = new FileInputStream("Robocraft Theme.wav");
                audio = new AudioStream(in);*/
                ap.start(audio);
                JOptionPane.showOptionDialog(this,"CONGRATULATIONS! YOU HAVE SUCCEED.\nYour Time: " + horas+ ":"+minutos+":"+segundos + "\nClick Continue","Congratulations!",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                mw.setPanel(MainWindow.Panels.MainMenuPanel);
            }else{
                JOptionPane.showOptionDialog(this,"CONGRATULATIONS! YOU HAVE SUCCEED. Click Continue","Congratulations!",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                mw.setPanel(MainWindow.Panels.EndGamePanel);
                ap.stop(audio);
                timer.stop();
                String boardname = mw.getGameController().getBoardName();
                mw.getRankingController().addRecord(boardname, mw.getUserController().getUsername(), Game.Mode.Normal, tiempo);
                ((EndGamePanel) mw.getPanel(MainWindow.Panels.EndGamePanel)).setBoardPlayed(boardname);
                ((EndGamePanel) mw.getPanel(MainWindow.Panels.EndGamePanel)).updateList();
                mw.setPanel(MainWindow.Panels.EndGamePanel);
            }
            Duration t = Duration.ofSeconds(tiempo);
            mw.getUserController().incrementTime(t);
            mw.getUserController().incrementSolvedGames();
        }
    }//GEN-LAST:event_btnCheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private kenken.gui.BoardPanel boardPanel1;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHint;
    private javax.swing.JButton btnMusic;
    private javax.swing.JButton btnSaveGame;
    private javax.swing.JButton btnSurrender;
    private javax.swing.JLabel lblCheck;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables

}
