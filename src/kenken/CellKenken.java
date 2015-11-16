/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author SuNLoCK
 */
public class CellKenken extends Cell{
    
    /* ATRIBUTO NO OFICIAL DE LA ESPECIFICACION*/
    private int region = 0;

    public CellKenken(int posX, int posY, boolean original, int solution) {
        super(posX, posY, original, solution);
    }
    
    public CellKenken(int x, int y, boolean original) {
        super(x,y,original);
    }
    
    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }
    
}
