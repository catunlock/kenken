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
    private int editRegionNumber = -1;
    private String editRegionOperation = "";
    private String editRegionResult = "";
    private CreatorController cc;

    
    public EditorPanel() {
        this.setFocusable(true);
        this.addMouseListener(this);
    }
    
    public void setEditRegionResult(String editRegionResult) {
        this.editRegionResult = editRegionResult;
    }
    
    public void setEditRegionOperation(String editRegionOperation) {
        this.editRegionOperation = editRegionOperation;
    }
    
    public void setEditRegionMode(boolean editRegionMode) {
        this.editRegionMode = editRegionMode;
    }

    public void setEditRegionNumber(int editRegionNumber) {
        this.editRegionNumber = editRegionNumber;
        cc.setEditRegion(editRegionNumber);
    }
    
    public void setShowRegionNumber(boolean showRegionNumber) {
        this.showRegionNumber = showRegionNumber;
    }

    public void setCreatorController(CreatorController cc) {
        this.cc = cc;
    }
    
    

    @Override
    protected void drawCell(Graphics2D g2d, InfoCell ic, int posX, int posY) {
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (editRegionMode) {
            int f = e.getY() / padVer;
            int c = e.getX() / padHor;

            InfoCell ic = infoCells.get(f).get(c);
            ic.region = editRegionNumber;
            ic.operation = editRegionOperation;
            ic.result = editRegionResult;
            
            repaint();
        }
        
    }
    
    
    
}
