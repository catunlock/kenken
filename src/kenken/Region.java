/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.ArrayList;

/**
 *
 * @author Marc Ferré Monné
 */
public class Region {
    
   
    
    enum OperationType{Add, Subtract, Multiply, Divide, None};
    
    private Cell cell;
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

    public Cell getCell() {
        return cell;
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

    public void setCell(Cell cell) {
        this.cell = cell;
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
