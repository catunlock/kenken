/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

/**
 *
 * @author SuNLoCK
 */
public class CellKenken extends Cell{
    
    private int region = 0;
    private boolean visible = false;
    private boolean hinted = false;
    
    /**
     * Constructor copy of CellKenken.
     * @param ck The CellKenken which will be copied.
     */
    public CellKenken(CellKenken ck) {
        super(ck.getPosX(), ck.getPosY(), ck.isOriginal(), ck.getSolutionValue());
        
        this.setHinted(ck.isHinted());
        this.setRegion(ck.getRegion());
        this.setUserValue(ck.getUserValue());
        this.setVisible(ck.isVisible());
    }
    
    /**
     * Getter of hinted.
     * @return A boolean to true if the cell is hinted.
     */
    public boolean isHinted() {
        return hinted;
    }

    /**
     * Setter of hinted
     * @param hinted Sets this.hinted to hinted.
     */
    public void setHinted(boolean hinted) {
        this.hinted = hinted;
    }

    /**
     * Setter of visibility for the cell.
     * @param visible The visibility to set to the cellKenken.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Getter of visible.
     * @return A Boolean with the visibility info.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Constructor of CellKenken with 4 parameters.
     * @param posX The Column to set the cellKenken.
     * @param posY The Row to set the cellKenken.
     * @param original Tells us if we can modify this cell during a game.
     * @param solution The solutionValue for the Board.
     */
    public CellKenken(int posX, int posY, boolean original, int solution) {
        super(posX, posY, original, solution);
    }
    
    /**
     * Constructor of cellKenken with position and original.
     * @param x The Column to set the cellKenken.
     * @param y The Row to set the cellKenken.
     * @param original Tells us if we can modify this cell during a game.
     */
    public CellKenken(int x, int y, boolean original) {
        super(x,y,original);
    }
    
    /**
     * Getter of region.
     * @return An Integer with the region.
     */
    public int getRegion() {
        return region;
    }

    /**
     * Setter of region.
     * @param region the region parameter to be set.
     */
    public void setRegion(int region) {
        this.region = region;
    }
    
}
