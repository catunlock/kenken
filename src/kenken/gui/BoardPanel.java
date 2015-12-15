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
   
    /**
     * Default Constructor of BoardPanel
     */
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

    /**
     * Sets a GameController for BoardPanel
     * @param gc The GameController to be set to the BoardPanel.
     */
    public void setGameController(GameController gc) {
        this.gc = gc;
    }
    
    /**
     * Getter of InfoCells.
     * @return An ArrayList of InfoCells contained in BoardPanel.
     */
    public ArrayList<ArrayList<InfoCell>> getInfoCells() {
        return infoCells;
    }
    
    /**
     * Getter of a InfoCell given a Position p.
     * @param p The position of the infoCell to retrieve.
     * @return The infoCell at the p Position.
     */
    public InfoCell getInfoCell(Pos p) {
        return infoCells.get(p.f).get(p.c);
    }
    

    /**
     * Draw the columns of the Board.
     * @param g2d The Graphic tool to draw in display.
     */
    private void drawColums(Graphics2D g2d) {
        int space = WIDTH / nColumns;
        for (int i = 0; i < nColumns; ++i) {
            g2d.drawLine(i*space, 0, i*space, WIDTH);
        }
    }
    
    /**
     * Draw the rows of the Board.
     * @param g2d The graphic tool to draw in display.
     */
    private void drawRows(Graphics2D g2d) {
        int space = HEIGHT / nColumns;
        for (int i = 0; i < nColumns; ++i) {
            g2d.drawLine(0, i*space, HEIGHT, i*space);
        }
    }
    
    /**
     * Setter of the size of the graphic Board.
     * @param size An Integer which contains the size x size measurements.
     */
    private void setSize(int size) {
        nColumns = size;
        padHor = WIDTH / nColumns;
        padVer = HEIGHT / nColumns;
        
        float fontSizeOperation = FONT_SIZE_OPERATION - nColumns;
        
        fontValue = new Font("Consolas", Font.BOLD, FONT_SIZE_VALUE);
        fontOperation = new Font("Consolas", Font.PLAIN, (int) fontSizeOperation);
    }
    
    /**
     * Sets a full matrix of infoCells
     * @param matrix The matrix which will set up this.infoCells
     */
    public void setInfoCells(ArrayList<ArrayList<InfoCell>> matrix) {
        setSize(matrix.size());
        this.infoCells = matrix;
        
        for (int f = 0; f < matrix.size(); ++f) {
            for (int c = 0; c < matrix.size(); ++c) {
                if (infoCells.get(f).get(c).value == "-1") {
                    infoCells.get(f).get(c).value = "";
                }
            }
        }
    }
    
    /**
     * Draws a Cell of the graphic Board.
     * @param g2d The graphic tool to draw in display.
     * @param ic The infocell which will be drawn.
     * @param posX The x position in the board where the Cell will be drawn.
     * @param posY The y position in the board where the Cell will be drawn.
     */
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
    
    /**
     * Draw all the cells in the graphic Board.
     * @param g2d The graphic tool to draw in display.
     */
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
    
    /**
     * Draws the vertical Border of the graphic Board.
     * @param g2d The graphic tool to draw in display.
     * @param row The row position of the Board.
     * @param column The column position of the Board.
     */
    private void drawBorderVertical(Graphics g2d, int row, int column) {
    	int y = row*padVer;
    	int x = column*padHor;
    	
   	for (int i = x-(BORDER_SIZE/2) ; i < x+(BORDER_SIZE/2); ++i) {
    		g2d.drawLine(i , y, i, y+padVer);
    	}
    }
    
    /**
     * Draws the Horitzontal border of the graphic Board.
     * @param g2d The graphic tool to draw in display.
     * @param row The row position of the Board.
     * @param column The column position of the Board.
     */
    private void drawBorderHoritzontal(Graphics g2d, int row, int column) {
    	int y = row*padVer;
    	int x = column*padHor;
    	
   	for (int i = y-(BORDER_SIZE/2) ; i < y+(BORDER_SIZE/2); ++i) {
    		g2d.drawLine(x , i, x+padHor, i);
    	}
    }
    
    /**
     * Sets an Operation into a Region of the graphic Board.
     * @param row The row position to set the operation.
     * @param column The column position to set the operation.
     * @param op The operation to set.
     * @param resultValue The result set to the infoCell.
     */
    public void setOperation(int row, int column, String op, String resultValue) {
        InfoCell ic = infoCells.get(row).get(column);
        ic.operation = op;
        ic.result = resultValue;
    }
    
    /**
     * Sets the Horitzontal to a InfoCell.
     * @param row The row position of the board.
     * @param column The column position of the board.
     * @param b The boolean which indicates if we have to draw the border.
     */
    public void setVerticalBorder(int row, int column, boolean b) {
        InfoCell ic = infoCells.get(row).get(column);
        ic.borderVertical = b;
    }
    
    /**
     * Sets the horitzontalBorder to a infoCell
     * @param row The row position of the board.
     * @param column The column position of the board.
     * @param b The boolean which indicates if we have to draw the border.
     */
    public void setHoritzontalBorder(int row, int column, boolean b) {
        InfoCell ic = infoCells.get(row).get(column);
        ic.borderHoritzontal = b;
    }
    
    /**
     * Sets a given value to a infoCell.
     * @param row The row position of the board.
     * @param column The column position of the board.
     * @param value The value to be set in the infoCell.
     */
    public void setValue(int row, int column, String value) {
        InfoCell ic = infoCells.get(row).get(column);
        ic.value = value;
    } 
    
    /**
     * This method does all the Drawing work.
     * @param g The graphic tool to draw in display.
     */
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
    
    /**
     * Draws a selected cell in display.
     * @param g2d The graphic tool to draw in display.
     */
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

    /**
     * Gets a copy of a selected position.
     * @return A copy of a pos in the board.
     */
    public Pos getSelectedPos() {
        return new Pos(selectedCell);
    }
    
    /**
     * Sets a Cell hinted and shows its value.
     * @param p The position to hint the value.
     * @param value The value hinted.
     */
    public void setHint(Pos p, String value) {
        infoCells.get(p.f).get(p.c).value = value;
        infoCells.get(p.f).get(p.c).hinted = true;
        
        repaint();
    }
    
    /**
     * Sets a selected cell by a pos.
     * @param p The position which will replace the old selectedCell
     */
    public void setSelectedCell(Pos p) {
        selectedCell.f = p.f;
        selectedCell.c = p.c;
    }
    
    /**
     * Paints a component to the panel.
     * @param g The graphic tool to draw in display.
     */
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

