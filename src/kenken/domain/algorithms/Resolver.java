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
    
    private Untouchables untouchables;
    private UsedValues usedValues;
    private Board board = null;
    private ArrayList<CellKenken> cellsByRegion;
    private boolean trobat = false;
    
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
    
    private boolean checkNotPass(int nRegion, int newValue) {
        Region r = board.getRegions().get(nRegion-1);
        
        int value = r.getCurrentSolutionResult();
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
    
    public void backtrack(int i) {
        
        if (! trobat) {
            if (i >= cellsByRegion.size()) { 
                if (board.isResolved()) {
                    BoardColorator.print(board);
                    System.out.println();
                    trobat = true;
                }
                System.out.println("Intento realizado.");
                //escriure(board);
            }
            else if (untouchables.isUntouchable(cellsByRegion.get(i).getPosX(),
                    cellsByRegion.get(i).getPosY())) {
                backtrack(i+1);
            }
            else {
                CellKenken ck = cellsByRegion.get(i);

                int f = ck.getPosX();
                int c = ck.getPosY();

                for (int j = 0; j < board.size(); ++j) {
                    boolean condA = usedValues.isNotUsed(f, c, j);
                    boolean condB = isMultiple(ck.getRegion()-1, j+1);

                    if (condA && condB) 
                    {    
                        Region r = board.getRegions().get(ck.getRegion()-1);

                        ck.setSolutionValue(j+1);

                        usedValues.set(f, c, j);
                        backtrack(i+1);
                        usedValues.unset(f, c, j);
                    }
                }
            }
        }
        
    }

    

    
    public boolean resolve(Board b) {
        boolean result = false;
        
        board = b;
        usedValues = new UsedValues();
        untouchables = new Untouchables();
        trobat = false;

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
        /*
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
        
        ArrayList<CellKenken> fCells = new ArrayList<>(2);

        fCells.add(b.getCell(2,3));
        fCells.add(b.getCell(3,3));
        
        Region rf = new Region(6, fCells, Region.OperationType.Multiply, 6, false);        
        
        ArrayList<CellKenken> gCells = new ArrayList<>(1);
        CellKenken gCell1 = b.getCell(3,2);
        gCell1.setSolutionValue(3);
        gCells.add(gCell1);
        Region rg = new Region(7,gCells, Region.OperationType.None, 3, false);
        
        ArrayList<Region> regions = new ArrayList<>(7);
        regions.add(ra);
        regions.add(rb);
        regions.add(rc);
        regions.add(rd);
        regions.add(re);
        regions.add(rf);
        regions.add(rg);
        
        */
Board b = new Board(7);
       
        ArrayList<CellKenken> aCells = new ArrayList<>(2);
       
        aCells.add(b.getCell(0,0));
        aCells.add(b.getCell(0,1));
       
        Region ra = new Region(1,aCells, Region.OperationType.Add, 6, false);
       
        ArrayList<CellKenken> bCells = new ArrayList<>(3);
       
        bCells.add(b.getCell(0,2));
        bCells.add(b.getCell(0,3));
        bCells.add(b.getCell(1,3));
       
        Region rb = new Region(2,bCells, Region.OperationType.Multiply, 72, false);
       
        ArrayList<CellKenken> cCells = new ArrayList<>(2);
       
        cCells.add(b.getCell(0,4));
        cCells.add(b.getCell(0,5));
       
        Region rc = new Region(3,cCells, Region.OperationType.Subtract, 1, false);
       
        ArrayList<CellKenken> dCells = new ArrayList<>(4);
       
        dCells.add(b.getCell(0,6));
        dCells.add(b.getCell(1,6));
        dCells.add(b.getCell(2,5));
        dCells.add(b.getCell(2,6));
       
        Region rd = new Region(4,dCells, Region.OperationType.Multiply, 210, false);
       
        ArrayList<CellKenken> eCells = new ArrayList<>(2);
       
        eCells.add(b.getCell(1,4));
        eCells.add(b.getCell(1,5));
       
        Region re = new Region(5,eCells, Region.OperationType.Subtract, 6, false);
       
        ArrayList<CellKenken> fCells = new ArrayList<>(2);
       
        fCells.add(b.getCell(1,0));
        fCells.add(b.getCell(2,0));
       
        Region rf = new Region(6,fCells, Region.OperationType.Subtract, 2, false);
       
        ArrayList<CellKenken> gCells = new ArrayList<>(2);
       
        gCells.add(b.getCell(1,1));
        gCells.add(b.getCell(2,1));
       
        Region rg = new Region(7,gCells, Region.OperationType.Subtract, 1, false);
       
        ArrayList<CellKenken> hCells = new ArrayList<>(2);
       
        hCells.add(b.getCell(1,2));
        hCells.add(b.getCell(2,2));
       
        Region rh = new Region(8,hCells, Region.OperationType.Divide, 2, false);
       
        ArrayList<CellKenken> iCells = new ArrayList<>(3);
       
        iCells.add(b.getCell(2,3));
        iCells.add(b.getCell(3,3));
        iCells.add(b.getCell(4,3));
       
        Region ri = new Region(9,iCells, Region.OperationType.Multiply, 210, false);
       
        ArrayList<CellKenken> jCells = new ArrayList<>(2);
       
        jCells.add(b.getCell(2,4));
        jCells.add(b.getCell(3,4));
       
        Region rj = new Region(10,jCells, Region.OperationType.Subtract, 2, false);
       
        ArrayList<CellKenken> kCells = new ArrayList<>(1);
       
        CellKenken kCell1 = b.getCell(3,0);
        kCell1.setSolutionValue(4);
        kCells.add(kCell1);
       
        Region rk = new Region(11,kCells, Region.OperationType.None, 4, false);
       
        ArrayList<CellKenken> lCells = new ArrayList<>(2);
       
        lCells.add(b.getCell(3,1));
        lCells.add(b.getCell(4,1));
       
        Region rl = new Region(12,lCells, Region.OperationType.Add, 5, false);
       
        ArrayList<CellKenken> mCells = new ArrayList<>(2);
       
        mCells.add(b.getCell(3,2));
        mCells.add(b.getCell(4,2));
       
        Region rm = new Region(13,mCells, Region.OperationType.Subtract, 6, false);
       
        ArrayList<CellKenken> nCells = new ArrayList<>(2);
       
        nCells.add(b.getCell(3,5));
        nCells.add(b.getCell(3,6));
       
        Region rn = new Region(14,nCells, Region.OperationType.Subtract, 1, false);
       
        ArrayList<CellKenken> oCells = new ArrayList<>(2);
       
        oCells.add(b.getCell(4,0));
        oCells.add(b.getCell(5,0));
       
        Region ro = new Region(15,oCells, Region.OperationType.Subtract, 1, false);
       
        ArrayList<CellKenken> pCells = new ArrayList<>(3);
       
        pCells.add(b.getCell(4,4));
        pCells.add(b.getCell(4,5));
        pCells.add(b.getCell(4,6));
       
        Region rp = new Region(16,pCells, Region.OperationType.Add, 14, false);
       
        ArrayList<CellKenken> qCells = new ArrayList<>(2);
       
        qCells.add(b.getCell(5,1));
        qCells.add(b.getCell(5,2));
       
        Region rq = new Region(17,qCells, Region.OperationType.Subtract, 1, false);
       
        ArrayList<CellKenken> rCells = new ArrayList<>(2);
       
        rCells.add(b.getCell(5,3));
        rCells.add(b.getCell(5,4));
       
        Region rr = new Region(18,rCells, Region.OperationType.Add, 3, false);
       
        ArrayList<CellKenken> sCells = new ArrayList<>(2);
       
        sCells.add(b.getCell(5,5));
        sCells.add(b.getCell(5,6));
        sCells.add(b.getCell(6,6));
       
        Region rs = new Region(19,sCells, Region.OperationType.Add, 16, false);
       
        ArrayList<CellKenken> tCells = new ArrayList<>(2);
       
        tCells.add(b.getCell(6,0));
        tCells.add(b.getCell(6,1));
       
        Region rt = new Region(20,tCells, Region.OperationType.Add, 13, false);
       
        ArrayList<CellKenken> uCells = new ArrayList<>(2);
       
        uCells.add(b.getCell(6,2));
        uCells.add(b.getCell(6,3));
       
        Region ru = new Region(21,uCells, Region.OperationType.Add, 5, false);
       
        ArrayList<CellKenken> vCells = new ArrayList<>(2);
       
        vCells.add(b.getCell(6,4));
        vCells.add(b.getCell(6,5));
       
        Region rv = new Region(22,vCells, Region.OperationType.Subtract, 3, false);
       
        ArrayList<Region> regions = new ArrayList<>(22);
        regions.add(ra);
        regions.add(rb);
        regions.add(rc);
        regions.add(rd);
        regions.add(re);
        regions.add(rf);
        regions.add(rg);
        regions.add(rh);
        regions.add(ri);
        regions.add(rj);
        regions.add(rk);
        regions.add(rl);
        regions.add(rm);
        regions.add(rn);
        regions.add(ro);
        regions.add(rp);
        regions.add(rq);
        regions.add(rr);
        regions.add(rs);
        regions.add(rt);
        regions.add(ru);
        regions.add(rv);

        
        b.setRegions(regions);
        
        BoardColorator.print(b);
        BoardColorator.printRegions(b);
        
        b.setBoardName("Gerard 7x7");
        b.setUsername("Gerard");
        BoardDBController bdbc = new BoardDBController();
        bdbc.createBoard(b);
        
        Resolver r = new Resolver();
        if (r.resolve(b)) {
            System.out.println("The solution is: ");
            BoardColorator.print(b);
        }else {
            
        }
    }
}