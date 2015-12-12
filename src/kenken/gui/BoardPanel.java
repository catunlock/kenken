/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    
    private final int WIDTH = 663;
    private final int HEIGHT = 663;
    private final int BORDER_SIZE = 4;
    private final int FONT_SIZE_VALUE = 58;
    private final int FONT_SIZE_OPERATION = 22;
    private Font fontValue = new Font("Consolas", Font.BOLD, FONT_SIZE_VALUE);
    private Font fontOperation = new Font("Consolas", Font.PLAIN, FONT_SIZE_OPERATION);
    
    private int nColumns = 4;
    private int padHor;
    private int padVer;
    private float fontScale = 1.0f;
   
    private ArrayList<ArrayList<InfoCell>> infoCells = new ArrayList<>();
    
    public BoardPanel() 
    {
        padHor = WIDTH / nColumns;
        padVer = HEIGHT / nColumns;
        
        setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
        
        infoCells = new ArrayList<>(nColumns);
        
        for (int i = 0; i < nColumns; ++i) 
        {
            infoCells.add(new ArrayList<>(nColumns));
            
            for (int j = 0; j < nColumns; ++j) 
            {
                InfoCell ic = new InfoCell();
                
                infoCells.get(i).add(ic);
            }
        }
        
        this.setOperation(1, 1, "", "3");
        this.setHoritzontalBorder(1, 1, true);
        this.setVerticalBorder(1, 1, true);
        this.setValue(1, 1, "3");
        
        this.setOperation(3, 3, "", "3");
        this.setHoritzontalBorder(3, 3, true);
        this.setVerticalBorder(3, 3, true);
        this.setValue(3, 3, "3");
        
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
    
    private void setSize(int size) {
        nColumns = size;
        padHor = WIDTH / nColumns;
        padVer = HEIGHT / nColumns;
        
        float fontSizeOperation = FONT_SIZE_OPERATION - nColumns;
        
        fontValue = new Font("Consolas", Font.BOLD, FONT_SIZE_VALUE);
        fontOperation = new Font("Consolas", Font.PLAIN, (int) fontSizeOperation);
    }
    
    public void setInfoCells(ArrayList<ArrayList<InfoCell>> matrix) {
        setSize(matrix.size());
        this.infoCells = matrix;
    }
    
    private void drawCell(Graphics2D g2d, InfoCell ic, int posX, int posY) 
    {
        // Operation
        g2d.setFont(fontOperation);
        int posOperationY = (int) (posY + (FONT_SIZE_OPERATION - nColumns/1.5));
        int posOperationX = (int) (posX + ((FONT_SIZE_OPERATION- nColumns)/2));
        g2d.drawString(ic.operation, posOperationX, posOperationY);

        // Result
        int posResultX = (int) (posOperationX + (FONT_SIZE_OPERATION - nColumns)/1.5);
        g2d.drawString(ic.result, posResultX, posOperationY);
    	
        // Value
    	g2d.setFont(fontValue);
    	int posValueY = posY + (HEIGHT/nColumns/2) + FONT_SIZE_VALUE/3;
    	int posValueX = posX + (WIDTH/nColumns/3);
    	g2d.drawString(ic.value, posValueX, posValueY);
        
    }
    
    private void drawCells(Graphics2D g2d) 
    {   
        if (infoCells.size() > 0){
            for (int i = 0; i < nColumns; ++i) {
                for (int j = 0; j < nColumns; ++j) {
                    InfoCell ic = infoCells.get(i).get(j);

                    drawCell(g2d, ic, j*padHor, i*padVer);

                    // Borders
                    if (ic.borderHoritzontal) {
                        drawBorderHoritzontal(g2d, i, j);
                    }

                    if (ic.borderVertical) {
                        drawBorderVertical(g2d, i, j);
                    }
                }
            }
        }
        
    }
    
    private void drawBorderVertical(Graphics g2d, int row, int column) {
    	int y = row*padVer;
    	int x = column*padHor;
    	
   	for (int i = x-(BORDER_SIZE/2) ; i < x+(BORDER_SIZE/2); ++i) {
    		g2d.drawLine(i , y, i, y+padVer);
    	}
    }
    
    private void drawBorderHoritzontal(Graphics g2d, int row, int column) {
    	int y = row*padVer;
    	int x = column*padHor;
    	
   	for (int i = y-(BORDER_SIZE/2) ; i < y+(BORDER_SIZE/2); ++i) {
    		g2d.drawLine(x , i, x+padHor, i);
    	}
    }
    
    public void setOperation(int row, int column, String op, String resultValue) {
        InfoCell ic = infoCells.get(row).get(column);
        ic.operation = op;
        ic.result = resultValue;
    }
    
    public void setVerticalBorder(int row, int column, boolean b) {
        InfoCell ic = infoCells.get(row).get(column);
        ic.borderVertical = b;
    }
    
    public void setHoritzontalBorder(int row, int column, boolean b) {
        InfoCell ic = infoCells.get(row).get(column);
        ic.borderHoritzontal = b;
    }
    
    public void setValue(int row, int column, String value) {
        InfoCell ic = infoCells.get(row).get(column);
        ic.value = value;
    } 
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);
        g2d.fillRect(0 , 0, WIDTH*1, HEIGHT-1);
        
        g2d.setPaint(Color.black);
        
        for (int i = 0; i < BORDER_SIZE; ++i) {
        	g2d.drawRect(0 + i , 0 + i, WIDTH - i*2, HEIGHT-1 - i*2);
        }
        
        g2d.setPaint(Color.black);
        drawColums(g2d);
        drawRows(g2d);
        
        drawCells(g2d);
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

