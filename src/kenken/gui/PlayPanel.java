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
import kenken.domain.classes.Pos;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author SuNLoCK
 */
public class PlayPanel extends javax.swing.JPanel {
    private MainWindow mw;
    private Duration time;
    private String a;
    private Timer timer;
    private int segundos, minutos, horas;
    AudioPlayer ap = AudioPlayer.player;
    InputStream in;
    AudioStream audio;
    boolean musicOn = true;
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
        
    }

    public void initTime(){
        time = Duration.ZERO;
        segundos = 0;
        minutos = 0;
        horas = 0;
        timer.restart();
        try {
            in = new FileInputStream("Robocraft Theme.wav");
            audio = new AudioStream(in);
            ap.start(audio);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void initBoard(ArrayList<ArrayList<InfoCell>> matrix) {
        boardPanel1.setInfoCells(matrix);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
       
    private ActionListener updateClockAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a custom component
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
            // OR
            // Assumes clock is a JLabel
            //lblTime.setText(new Date().toString()); 
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHint, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                        .addComponent(btnMusic)
                        .addGap(67, 67, 67)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveGame)
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                            .addComponent(btnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(boardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
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
            mw.setPanel(MainWindow.Panels.MainMenuPanel);
            lblTime.setText("00:00:00");
            ap.stop(audio);
            timer.stop();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveGameActionPerformed
        // TODO add your handling code here:
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private kenken.gui.BoardPanel boardPanel1;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHint;
    private javax.swing.JButton btnMusic;
    private javax.swing.JButton btnSaveGame;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
