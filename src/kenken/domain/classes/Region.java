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


    public Region(int id, ArrayList<CellKenken> cellList, OperationType operationType, int result, boolean valid) {
        this.operationType = operationType;
        this.result = result;
        this.valid = valid;
        this.id = id;
        setCellList(cellList);
    }

    public int getId() {
        return id;
    }


    public ArrayList<CellKenken> getCellList() {
        return cellList;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public int getResult() {
        return result;
    }

    public boolean isValid() {   
        boolean valid = false;
        
        if (this.getCurrentSolutionResult() == this.getResult()) {
                valid = true;
        }
       
        return valid;
    }
    
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
    
    public void setCellList(ArrayList<CellKenken> cellList) {
        this.cellList = cellList;
        Iterator<CellKenken> it = this.cellList.iterator();
        while(it.hasNext()) {
            it.next().setRegion(id);
        }
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
