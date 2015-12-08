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
import java.util.ArrayList;
import java.util.Iterator;
import kenken.color.BoardColorator;

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
    
    private Untouchables untouchables;
    private UsedValues usedValues;
    private Board board = null;
    private ArrayList<CellKenken> cellsByRegion;
    
    public void escriure(Board b) {
		if (b.size() > 0) {
	            for (int i = 0; i < b.size(); ++i) {
	                for (int j = 0; j < b.size(); ++j) {
	                    System.out.print(b.getCell(i, j).getSolutionValue() + " ");
	                }
	                System.out.println();
	            }
		}
    }
    
    
    public void backtrack(int i) {
        
        if (i >= cellsByRegion.size()) { 
            if (board.isResolved()) {
                BoardColorator.print(board);
                System.out.println();
            }
            //escriure(board);
        }
        else if (untouchables.isUntouchable(cellsByRegion.get(i).getPosX(),
                cellsByRegion.get(i).getPosY())) {
            backtrack(i+1);
        }
        else {
            int f = cellsByRegion.get(i).getPosX();
            int c = cellsByRegion.get(i).getPosY();
            
            for (int j = 0; j < board.size(); ++j) {
                if (usedValues.isNotUsed(f, c, j)) 
                {    
                    board.getCell(f, c).setSolutionValue(j+1);
                    
                    usedValues.set(f, c, j);

                    backtrack(i+1);

                    usedValues.unset(f, c, j);
                }
            }
	}
    }

    

    
    public boolean resolve(Board b) {
        boolean result = false;
        
        board = b;
        usedValues = new UsedValues();
        untouchables = new Untouchables();

        for (Region r : b.getRegions()) {
            if (r.getOperationType() == Region.OperationType.None) {
                CellKenken c = r.getCellList().get(0);
                untouchables.set(c.getPosX(),c.getPosY());
                usedValues.set(c.getPosX(), c.getPosY(), c.getSolutionValue()-1);
            }
        }
        
        cellsByRegion = b.getAllCellsOrderedByRegion();
        
        backtrack(0);
        
        return result;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        /*File file = new File("output2.log"); 
        PrintStream printStream = new PrintStream(new FileOutputStream(file)); 
        System.setOut(printStream);*/
        
        Board b = new Board(4);
        
        ArrayList<CellKenken> aCells = new ArrayList<>(3);
        
        aCells.add(b.getCell(0,0));
        aCells.add(b.getCell(0,1));
        aCells.add(b.getCell(1,0));
        
        Region ra = new Region(1,aCells, Region.OperationType.Multiply, 6, false);
        
        ArrayList<CellKenken> bCells = new ArrayList<>(3);
        
        bCells.add(b.getCell(0,2));
        bCells.add(b.getCell(0,3));
        bCells.add(b.getCell(1,3));
        
        Region rb = new Region(2,bCells, Region.OperationType.Add, 9, false);
        
        ArrayList<CellKenken> cCells = new ArrayList<>(2);
        
        cCells.add(b.getCell(2,0));
        cCells.add(b.getCell(3,0));
        
        Region rc = new Region(3,cCells, Region.OperationType.Divide, 2, false);
        
        ArrayList<CellKenken> dCells = new ArrayList<>(3);
        
        dCells.add(b.getCell(1,1));
        dCells.add(b.getCell(2,1));
        dCells.add(b.getCell(3,1));
        
        Region rd = new Region(4,dCells, Region.OperationType.Multiply, 12, false);
        
        ArrayList<CellKenken> eCells = new ArrayList<>(2);
        
        eCells.add(b.getCell(1,2));
        eCells.add(b.getCell(2,2));
        
        Region re = new Region(5,eCells, Region.OperationType.Subtract, 1, false);
        
        ArrayList<CellKenken> fCells = new ArrayList<>(1);
        CellKenken fCell1 = b.getCell(3,2);
        fCell1.setSolutionValue(3);
        fCells.add(fCell1);
        Region rf = new Region(7,fCells, Region.OperationType.None, 3, false);
        
        ArrayList<CellKenken> gCells = new ArrayList<>(1);
        gCells.add(b.getCell(2,3));
        gCells.add(b.getCell(3,3));
        Region rg = new Region(6, gCells, Region.OperationType.Multiply, 6, false);        
        
        
        ArrayList<Region> regions = new ArrayList<>(7);
        regions.add(ra);
        regions.add(rb);
        regions.add(rc);
        regions.add(rd);
        regions.add(re);
        regions.add(rf);
        regions.add(rg);
        
        b.setRegions(regions);
        
        BoardColorator.print(b);
        BoardColorator.printRegions(b);
        
        Resolver r = new Resolver();
        if (r.resolve(b)) {
            System.out.println("The solution is: ");
            BoardColorator.print(b);
        }else {
            
        }
    }
}