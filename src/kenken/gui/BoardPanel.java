/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author alberto.lopez.sanchez
 */
public class BoardPanel extends JPanel implements ActionListener{
    
    private final int WIDTH = 417;
    private final int HEIGHT = 417;
    
    private int nColumns = 4;
    
    private class InfoCell {
        public String operation = "+";
        public String result = "0";
        public String value = "4";
    }

    ArrayList<ArrayList<InfoCell>> infoCells;
    
    public BoardPanel() {
        setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
        infoCells = new ArrayList<>(nColumns);
        
        for (int i = 0; i < nColumns; ++i) {
            infoCells.add(new ArrayList<>(nColumns));
            
            for (int j = 0; j < nColumns; ++j) {
                InfoCell ic = new InfoCell();
                ic.value = String.valueOf(i);
                ic.result = ic.value;
                infoCells.get(i).set(j, ic);
            }
        }
    }

    private void drawColums(Graphics2D g2d) {
        int space = WIDTH / nColumns;
        for (int i = 0; i < nColumns; ++i) {
            g2d.drawLine(i*space, 0, i*space, WIDTH);
        }
    }
    
    private void drawRows(Graphics2D g2d) {
        int space = HEIGHT / nColumns;
        for (int i = 0; i < nColumns; ++i) {
            g2d.drawLine(0, i*space, HEIGHT, i*space);
        }
    }
    
    private void drawCell(InfoCell ic, int posX, int posY) {
        
        
    }
    
    private void drawCells(Graphics2D g2d) {
        for (int i = 0; i < nColumns; ++i) {
            for (int j = 0; j < nColumns; ++j) {
                InfoCell ic = infoCells.get(i).get(j);
                
                drawCell(ic, j*HEIGHT, i*WIDTH);
            }
        }
    }
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.blue);
        
        g2d.drawString("Kenken Bitches.", 50, 50);
        g2d.drawRect(0 , 0, WIDTH*1, HEIGHT-1);
        
        drawColums(g2d);
        drawRows(g2d);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

