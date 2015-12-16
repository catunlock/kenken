/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.gui;

import kenken.domain.controllers.CreatorController;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 *
 * @author SuNLoCK
 */
public class EditorPanel extends BoardPanel{
    
    private boolean showRegionNumber = false;
    private boolean editRegionMode = false;
    private boolean added = false;
    private int editRegionNumber = -1;
    private String editRegionOperation = "";
    private String editRegionResult = "";
    private CreatorController cc;
    private Color editRegionColor = Color.WHITE;

    public Color getEditRegionColor() {
        return editRegionColor;
    }

    public void setEditRegionColor(Color editRegionColor) {
        this.editRegionColor = editRegionColor;
    }
    
    
    
    /**
     * Default constructor of EditorPanel.
     */
    public EditorPanel() {
        this.setFocusable(true);
        this.addMouseListener(this);
    }
    
    /**
     * Setter of editRegionResult.
     * @param editRegionResult Replaces this.editRegionResult with editRegionResult.
     */
    public void setEditRegionResult(String editRegionResult) {
        this.editRegionResult = editRegionResult;
    }
    
    /**
     * Setter of editRegionOperation.
     * @param editRegionOperation Replaces this.editRegionOperation with editRegionOperation.
     */
    public void setEditRegionOperation(String editRegionOperation) {
        this.editRegionOperation = editRegionOperation;
    }
    
    /**
     * Setter of editRegionMode.
     * @param editRegionMode Replaces this.editRegionMode with editRegionMode.
     */
    public void setEditRegionMode(boolean editRegionMode) {
        this.editRegionMode = editRegionMode;
    }

    /**
     * Setter of editRegionNumber.
     * @param editRegionNumber Replaces this.editRegionNumber with editRegionNumber.
     */
    public void setEditRegionNumber(int editRegionNumber) {
        this.editRegionNumber = editRegionNumber;
       
    }
    
    /**
     * Setter of ShowRegionNumber.
     * @param showRegionNumber Replaces this.showRegionNumber with showRegionNumber.
     */
    public void setShowRegionNumber(boolean showRegionNumber) {
        this.showRegionNumber = showRegionNumber;
    }

    /**
     * Sets the creatorController to the editorPanel.
     * @param cc The CreatorController which will be placed.
     */
    public void setCreatorController(CreatorController cc) {
        this.cc = cc;
    }
    
    public void setStartEditing(){
        added = false;
    }

    /**
     * Draws a Cell to the editor Panel.
     * @param g2d The Graphic tool to draw in display.
     * @param ic The infoCell to be drawn.
     * @param posX Position x to draw.
     * @param posY Position y to draw.
     */
    @Override
    protected void drawCell(Graphics2D g2d, InfoCell ic, int posX, int posY) {
        
        g2d.setColor(ic.backgroundColor);
        g2d.fillRect(posX+1, posY+1, padHor-2, padVer-2);
        
        super.drawCell(g2d, ic, posX, posY);
        
        if (showRegionNumber) {
            g2d.setColor(Color.MAGENTA);
            
            g2d.setFont(fontOperation);
            int posRegionY = (int) (posY + (FONT_SIZE_OPERATION - nColumns/1.5));
            int posRegionX = (int) (posX + padHor - (FONT_SIZE_OPERATION*1.2));
            g2d.drawString(String.valueOf(ic.region), posRegionX, posRegionY);
            
            g2d.setColor(Color.black);
        }
    }

    /**
     * If is editing the regions, creates a region when clicks to a cell.
     * @param e Event trigger.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (editRegionMode) {
            added = true;
            int f = e.getY() / padVer;
            int c = e.getX() / padHor;

            InfoCell ic = infoCells.get(f).get(c);
            ic.region = editRegionNumber;
            ic.operation = editRegionOperation;
            ic.result = editRegionResult;
            ic.backgroundColor = editRegionColor;
            
            repaint();
        }
        
    }
    
    public boolean getEdited(){
        return added;
    }
    
}
