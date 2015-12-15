/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

import java.io.Serializable;
import static java.lang.Integer.min;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import java.util.ArrayList;
import java.util.Iterator;

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
    
    public enum OperationType{Add, Subtract, Multiply, Divide, None};
    
    private ArrayList<CellKenken> cellList;
    private OperationType operationType;
    private int result;
    private boolean valid;
    private int id;

    public void addCell(CellKenken ck) {
        cellList.add(ck);
    }
    
    /**
     * The constructor of Region
     * @param id An integer eith the id.
     * @param cellList An ArrayList containing the cells in the region.
     * @param operationType Opereation given tu the region.
     * @param result The result of the combination of numbers and the operation.
     * @param valid boolean to warn if is valid or not the combination.
     */
    public Region(int id, ArrayList<CellKenken> cellList, OperationType operationType, int result, boolean valid) {
        this.operationType = operationType;
        this.result = result;
        this.valid = valid;
        this.id = id;
        setCellList(cellList);
    }

    /**
     * Getter of id
     * @return An Integer which indicate the id of the region.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter of the CellList
     * @return An ArrayList with the cellList of the region.
     */
    public ArrayList<CellKenken> getCellList() {
        return cellList;
    }

    /**
     * Getter of OperationType
     * @return An OperationType of the Region.
     */
    public OperationType getOperationType() {
        return operationType;
    }

    /**
     * Getter of result.
     * @return An Integer with the result of the Region.
     */
    public int getResult() {
        return result;
    }

    /**
     * Getter of valid
     * @return A boolean with valid.
     */
    public boolean isValid() {   
        boolean valid = false;
        
        if (this.getCurrentUserResult() == this.getResult()) {
                valid = true;
        }
       
        return valid;
    }
    
    /**
     * Go across all of the solution values to calculate and get the result.
     * @return An Integer with result of the combination of solutionValue.
     */
    public int getCurrentSolutionResult() {
        int result = 0;
        
        Region.OperationType op = this.getOperationType();
        Iterator<CellKenken> it = this.getCellList().iterator();

        if(it.hasNext()){
            CellKenken c = it.next();
            
            if (c.getSolutionValue() != -1) {
                result = c.getSolutionValue();
            }
            
            while (it.hasNext()) {
                c = it.next();
                
                if (c.getSolutionValue() != -1) {
                    
                    switch(op) {
                    case Add:
                        result += c.getSolutionValue();
                        break;
                    case Subtract:
                        result = abs(result - c.getSolutionValue());
                        break;
                    case Multiply:
                        result *= c.getSolutionValue();
                        break;
                    case Divide:
                        result = max(result,c.getSolutionValue())/ min(result,c.getSolutionValue());
                        break;                    
                    }

                    
                }
            }
        }
        
        return result;
    }
    
    /**
     * Go across all of the user values to calculate and get the result.
     * @return An Integer with result of the combination of userValue.
     */
    public int getCurrentUserResult() {
        int result = 0;
        
        Region.OperationType op = this.getOperationType();
        Iterator<CellKenken> it = this.getCellList().iterator();

        if(it.hasNext()){
            CellKenken c = it.next();
            
            if (c.getUserValue() != -1) {
                result = c.getUserValue();
            }
            
            while (it.hasNext()) {
                c = it.next();
                
                if (c.getUserValue() != -1) {
                    
                    switch(op) {
                    case Add:
                        result += c.getUserValue();
                        break;
                    case Subtract:
                        result = abs(result - c.getUserValue());
                        break;
                    case Multiply:
                        result *= c.getUserValue();
                        break;
                    case Divide:
                        result = max(result,c.getUserValue())/ min(result,c.getUserValue());
                        break;                    
                    }

                    
                }
            }
        }
        
        return result;
    }
    
    /**
     * Setter of CellList.
     * @param cellList Sets the this.cellList with another cellList.
     */
    public void setCellList(ArrayList<CellKenken> cellList) {
        this.cellList = cellList;
        Iterator<CellKenken> it = this.cellList.iterator();
        while(it.hasNext()) {
            it.next().setRegion(id);
        }
    }

    /**
     * Setter of OperationType.
     * @param operationType Sets this.operationType with another operationType.
     */
    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    /**
     * Setter of result.
     * @param result Sets this.result with another result.
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * Setter of result.
     * @param valid Sets this.valid with another valid boolean.
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    
}
