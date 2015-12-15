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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import kenken.domain.classes.Pos;
import kenken.domain.controllers.GameController;

/**
 *
 * @author alberto.lopez.sanchez
 */
public class BoardPanel extends JPanel implements MouseListener, KeyListener{
    
    private final int WIDTH = 663;
    private final int HEIGHT = 663;
    private final int BORDER_SIZE = 4;
    private final int FONT_SIZE_VALUE = 58;
    protected final int FONT_SIZE_OPERATION = 22;
    protected Font fontValue = new Font("Consolas", Font.BOLD, FONT_SIZE_VALUE);
    protected Font fontOperation = new Font("Consolas", Font.PLAIN, FONT_SIZE_OPERATION);
    private GameController gc;
    
    protected int nColumns = 4;
    protected int padHor;
    protected int padVer;
    private float fontScale = 1.0f;

    protected ArrayList<ArrayList<InfoCell>> infoCells = new ArrayList<>();
    
    private Pos selectedCell = new Pos(-1, -1);
   
    
    public BoardPanel() 
    {
        padHor = WIDTH / nColumns;
        padVer = HEIGHT / nColumns;

        this.setFocusable(true);
        this.addMouseListener(this);
        this.addKeyListener(this);
        
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
        
     
        
    }

    public void setGameController(GameController gc) {
        this.gc = gc;
    }
    
    public ArrayList<ArrayList<InfoCell>> getInfoCells() {
        return infoCells;
    }
    
    public InfoCell getInfoCell(Pos p) {
        return infoCells.get(p.f).get(p.c);
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
    
    protected void drawCell(Graphics2D g2d, InfoCell ic, int posX, int posY) 
    {
        if (ic.hinted) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(posX, posY, padHor-1, padVer-1);
            
        }
        else if (ic.showIsCorrect) {
            if (ic.correct) {
                g2d.setColor(Color.GREEN);        
            }else {
                g2d.setColor(Color.RED);
            }
            g2d.fillRect(posX, posY, padHor-1, padVer-1);
        }
        g2d.setColor(Color.black);
        
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
        
        // Rows and columns
        g2d.setPaint(Color.black);
        drawColums(g2d);
        drawRows(g2d);
        
        // Cells
        drawCells(g2d);
        
        // Selected Cell
        drawSelectedCell(g2d);
    }
    
    private void drawSelectedCell(Graphics2D g2d) {
        
        if (selectedCell.f != -1 && selectedCell.c != -1) {
            int x = selectedCell.c*padHor;
            int y = selectedCell.f*padVer;

            g2d.setPaint(Color.blue);
            g2d.fillRect(x, y, padHor, padVer);

            g2d.setPaint(Color.white);
            InfoCell ic = infoCells.get(selectedCell.f).get(selectedCell.c);
            drawCell(g2d, ic, x, y);

            g2d.setPaint(Color.black);
        }
    }

    public Pos getSelectedPos() {
        return new Pos(selectedCell);
    }
    
    public void setHint(Pos p, String value) {
        infoCells.get(p.f).get(p.c).value = value;
        infoCells.get(p.f).get(p.c).hinted = true;
        
        repaint();
    }
    
    public void setSelectedCell(Pos p) {
        selectedCell.f = p.f;
        selectedCell.c = p.c;
    }
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int f = e.getY() / padVer;
        int c = e.getX() / padHor;
        
        if (! infoCells.get(f).get(c).hinted ) {
            System.out.println("Clicked at cell: " + selectedCell.f + " " + selectedCell.c);

            selectedCell.c = c;
            selectedCell.f = f;

            this.requestFocusInWindow();
            
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KEYTYPED: " + e.getKeyChar());
        if (selectedCell.f != -1 && selectedCell.c != -1) {
            try {
                int value = Integer.parseInt(String.valueOf(e.getKeyChar()));
                if (value > 0 && value <= nColumns) {
                    InfoCell ic = infoCells.get(selectedCell.f).get(selectedCell.c);
                    gc.updateValue(selectedCell.f, selectedCell.c, value);
                    ic.value = String.valueOf(value);

                    selectedCell.f = -1;
                    selectedCell.c = -1;

                    repaint();
                }
                
                
            } catch (java.lang.NumberFormatException ex) {
                // Si peta es que el usuario no ha introducido un numero.
            }
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("KEYPRESED: " + e.getKeyChar());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

