/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Marc Ferré Monné
 */
public class Region implements Serializable{
    
   /*
    Posible modificación: en vez de tener que modificar las Cells aquí y en el
    Board, se puede poner aquí una especie de ArrayList de posiciones, para que
    solo se tenga que consultar la posición.
    */
    
    enum OperationType{Add, Subtract, Multiply, Divide, None};
    
    private ArrayList<Cell> cellList;
    private OperationType operationType;
    private int result;
    private boolean valid;

    public Region(ArrayList<Cell> cellList, OperationType operationType, int result, boolean valid) {
        this.cellList = cellList;
        this.operationType = operationType;
        this.result = result;
        this.valid = valid;
    }

    

    public ArrayList<Cell> getCellList() {
        return cellList;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public int getResult() {
        return result;
    }

    public boolean isValid() {
        return valid;
    }

    public void setCellList(ArrayList<Cell> cellList) {
        this.cellList = cellList;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    
}
