/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.algorithms;

import kenken.domain.classes.Pos;
import kenken.domain.classes.CellKenken;
import kenken.domain.classes.Region;
import kenken.domain.classes.Board;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import static java.lang.Integer.min;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import kenken.color.BoardColorator;
import kenken.domain.classes.Cell;
import kenken.domain.controllers.BoardController;
import kenken.persistance.controllers.BoardDBController;

/**
 *
 * @author SuNLoCK
 */
public class Resolver {
    
    private class UsedValues {
        private ArrayList<ArrayList<Boolean>> numerosFila;
        private ArrayList<ArrayList<Boolean>> numerosColumna;
        
        public UsedValues() {
            numerosFila = new ArrayList<>();
            numerosColumna = new ArrayList<>();
            
            for (int i = 0; i < board.size(); ++i) {
                numerosFila.add(new ArrayList<>());
                numerosColumna.add(new ArrayList<>());
           
                for (int j = 0; j < board.size(); ++j) {
                    numerosFila.get(i).add(false);
                    numerosColumna.get(i).add(false);
            
                }
            }
        }
    
        public void set(int f, int c, int number) {
            numerosFila.get(f).set(number, true);
            numerosColumna.get(c).set(number, true);
        }
        
        public void unset(int f, int c, int number) {
            numerosFila.get(f).set(number, false);
            numerosColumna.get(c).set(number, false);
        }
        
        public boolean isNotUsed(int f, int c, int number) {
            return ! numerosFila.get(f).get(number) && ! numerosColumna.get(c).get(number);
        }
    }
    
    private class Untouchables {
        private ArrayList<ArrayList<Boolean>> untouchables;
        
        public Untouchables() {
            untouchables = new ArrayList<>();
        
            for (int i = 0; i < board.size(); ++i) {
                untouchables.add(new ArrayList<>());

                for (int j = 0; j < board.size(); ++j) {
                    untouchables.get(i).add(false);
                }
            }
        }
        
        public void set(int f, int c) {
            untouchables.get(f).set(c, true);
        }
        
        public void unset(int f, int c) {
            untouchables.get(f).set(c, false);
        }
        
        public boolean isUntouchable(int f, int c) {
            return untouchables.get(f).get(c);
        }
        
    }
    
    private HashMap<Integer, HashSet<Integer>> possibleValues;
    
    //private Untouchables untouchables;
    private UsedValues usedValues;
    private Board board = null;
    private ArrayList<CellKenken> cellsByRegion;
    private boolean trobat = false;
    
    public void escriure(Board b) {
		if (b.size() > 0) {
	            for (int i = 0; i < b.size(); ++i) {
	                for (int j = 0; j < b.size(); ++j) {
	                    System.out.print(b.getCell(i, j).getUserValue() + " ");
	                }
	                System.out.println();
	            }
		}
    }
    
    private boolean checkNotPass(int nRegion, int newValue) {
        Region r = board.getRegions().get(nRegion-1);
        
        int value = r.getCurrentUserResult();
        try {
            switch(r.getOperationType()) {
                case Add:
                    value += newValue;
                    break;
                case Subtract:
                    value = abs(value - newValue);
                    break;
                case Multiply:
                    value *= newValue;
                    break;
                case Divide:
                    value = max(value, newValue)/ min(value, newValue);
                    break;                    
                case None:
                    break;
                default:
                    throw new AssertionError(r.getOperationType().name());
            }
        }catch (ArithmeticException e) {
            
        }
        
        System.out.println(value + "<=" + r.getResult());
        return value <= r.getResult();
    }
    
    private boolean isMultiple(int region, int newValue) {
        Region r = board.getRegions().get(region);
        
        if (r.getOperationType() == Region.OperationType.Multiply && newValue != 1) {
            return board.getRegions().get(region).getResult() % newValue == 0;
        }
        
        if (r.getOperationType() == Region.OperationType.Divide && newValue != 1) {
            return newValue % board.getRegions().get(region).getResult() == 0;
        }
        
        return true;
    }
    
    private boolean isMultiple(Region r, int newValue) {
        
        if (r.getOperationType() == Region.OperationType.Multiply && newValue != 1) {
            return r.getResult() % newValue == 0;
        }
        
        if (r.getOperationType() == Region.OperationType.Divide && newValue != 1) {
            return newValue % r.getResult() == 0;
        }
        
        return true;
    }
    
    private void backtrack(int i) {
        
        if (! trobat) {
            
            if (i >= cellsByRegion.size()) { 
                if (board.isResolved()) {
                    System.out.println("Resolver solution:");
                    BoardColorator.printUser(board);
                    System.out.println();
                    trobat = true;
                }
                //System.out.println("Intento realizado.");
                //BoardColorator.printSolution(board);
                //escriure(board);
            }
            
            else {
                CellKenken ck = cellsByRegion.get(i);

                int f = ck.getPosX();
                int c = ck.getPosY();
                
                HashSet<Integer> hs = possibleValues.get(getCellID(ck));
                
                if (hs.isEmpty()) {
                    backtrack(i+1);
                }else {
                    for (Integer z : hs) 
                    {                       
                        boolean condA = usedValues.isNotUsed(f, c, z-1);
                        if(condA) {
                            ck.setUserValue(z);

                            usedValues.set(f, c, z-1);
                            backtrack(i+1);
                            usedValues.unset(f, c, z-1);
                        }
                    }
                }

            }
        }
        
    }

    

    
    public boolean resolve(Board b) {
        
        board = b;
        usedValues = new UsedValues();
        possibleValues = new HashMap<>();
        trobat = false;
        
        // Init HashMap<Integer, HashSet<Integer>>
        for (Region r : b.getRegions()) {
            for (CellKenken ck : r.getCellList()) {
                int cellID = getCellID(ck);
                HashSet<Integer> hs = new HashSet<Integer>();
                possibleValues.put(cellID, hs);
                
            }
            
        }
  
        // 1. Marcar las celdas intocables, en los valores usados i en la lista de posibles valores.
        for (Region r : b.getRegions()) {
            Region.OperationType op = r.getOperationType();
            switch(op) {
                case Add:
                case Subtract: {
                    for (CellKenken c : r.getCellList()) {
                        for (int i = 1; i <= b.size(); ++i) {
                            possibleValues.get(getCellID(c)).add(i);
                        }
                    }
                }
                break;
                case Multiply:
                case Divide: {
                    for (CellKenken c : r.getCellList()) {
                        for (int i = 1; i <= b.size(); ++i) {
                            if (isMultiple(r, i)) {
                                possibleValues.get(getCellID(c)).add(i);
                            }
                        }
                    }
                }
                break;
                   
                case None: {
                    CellKenken c = r.getCellList().get(0);
                    int x = c.getPosX();
                    int y = c.getPosY();
                    int userValue = c.getUserValue();
                    
                    usedValues.set(x, y, userValue-1);
                    possibleValues.get(getCellID(c)).add(c.getUserValue());
                    
                    for (int i = 0; i < board.size(); ++i) {
                        CellKenken cFila = board.getCell(x, i);
                        CellKenken cColumna = board.getCell(i, y);
                        possibleValues.get(getCellID(cFila)).remove(userValue);
                        possibleValues.get(getCellID(cColumna)).remove(userValue);
                    }
                    
                    
                }
                    break;
                default:
                    throw new AssertionError(op.name());
                
            }
        }
        
        printPossibleValues();
              
        cellsByRegion = b.getAllCellsOrderedByOperation();
        
        backtrack(0);
        
        return trobat;
    }
    
    private void printPossibleValues() {
    
        Iterator<CellKenken> it = board.iterator();
        while (it.hasNext()) {
            CellKenken ck = it.next();
            
            int cellID = getCellID(ck);
            System.out.print("Cell:" + cellID + " -> ");
            
            for (Integer i : possibleValues.get(cellID)) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
        
    }

    private int getCellID(Cell c) {
        return c.getPosX() * 10 + c.getPosY();
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    public static void main(String[] args) {
        Generator g = new Generator();
        Board bGen = g.generate(4, 1f, 1.0f, System.nanoTime());
        
        Resolver r = new Resolver();
        
        long t1 = System.nanoTime();
        boolean resolved = r.resolve(bGen);
        long t2 = System.nanoTime();
        
        double milis = (t2-t1) / 1000000;
        
        System.out.println("Found the answer in: " + milis + "ms" );
        if (resolved) {
            BoardColorator.printSolution(bGen);
        }
    }
    
}