/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author Marc Ferré Monné
 */
public class Cell {
    private int value;
    private int region;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }
    
    public Cell() {
        value = 0;
        region = 0;
    }
}
