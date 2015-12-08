/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author xaloc
 */
public class Board implements Serializable {
    private String name;
    private String username;
    CellKenken[][] board;
    private ArrayList<Region> regions;
    
    public Board(int size) {
        board = new CellKenken[size][size];
        for (int i = 0; i < size; ++i){
            for (int j = 0; j < size; ++j) {
                board[i][j] = new CellKenken(i,j,true);
            }
        }
        
        regions = new ArrayList<>();
    }
    
    public String getBoardName(){
        return name;
    }
      
    public String getUsername(){
        return username;
    }
    
    public void setBoardName(String boardname){
        this.name = boardname;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public CellKenken getCell(int x, int y) {
        return board[x][y];
    }
    
    public int size() {
        return board.length;
    }
    
    public void setCell(int x, int y, CellKenken c) {
        board[x][y] = c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int f = 0; f < board.length; ++f) {
            for (int c = 0; c < board.length; ++c) {
                sb.append(board[f][c].getSolutionValue());
            }
            sb.append('\n');
        }
        return sb.toString();
    }
    
    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }
    
    public ArrayList<Region> getRegions() {
        return new ArrayList<Region>(regions);
    }
    
    public static Board toBoard(String b){
        return null;
    }
    
    public boolean isResolved() {
        boolean correct = true;
        
        int i = 0;
        while (correct && i < regions.size()) {
            correct = regions.get(i).isValid();
            ++i;
        }
        
        return correct;
    }

    
    
    public Iterator<CellKenken> iterator() {
        Iterator<CellKenken> it = new Iterator<CellKenken>() {
            
            private int nRegion = 0;
            private int nCell = 0;
            private boolean next = true;

            private int numberOfRegions = regions.size();;
            private int numberOfCellsInRegion = (numberOfRegions > 0)? regions.get(nRegion).getCellList().size() : 0;

            @Override
            public boolean hasNext() {
                return next && numberOfCellsInRegion > 0;
            }

            @Override
            public CellKenken next() {
                CellKenken c = regions.get(nRegion).getCellList().get(nCell);

                if (nCell < numberOfCellsInRegion - 1) {
                    nCell++;
                }
                else if (nCell >= numberOfCellsInRegion - 1 && nRegion < numberOfRegions - 1) {
                    nCell = 0;
                    nRegion++;
                    numberOfCellsInRegion = regions.get(nRegion).getCellList().size();
                }
                else {
                    next = false;
                }

                return c;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
    
    public ArrayList<CellKenken> getAllCellsOrderedByRegion() {
        ArrayList<CellKenken> r = new ArrayList<>(size()*size());
        
        Iterator<CellKenken> it = this.iterator();
        
        while(it.hasNext()) {
            r.add(it.next());
        }
        
        return r;
    }
    
    public static void main(String[] args) {
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
        
        
        ArrayList<CellKenken> cellsRegion = b.getAllCellsOrderedByRegion();
        
        for (CellKenken c : cellsRegion) {
            System.out.println("Region: " + c.getRegion() + ", POS: " + c.getPosX() + " " + c.getPosY());
        }
    }
}
