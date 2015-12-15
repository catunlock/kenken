/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
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
    
    public boolean isCorrect() {
        boolean correct = true;
        
        for (int f = 0; f < size() && correct; ++f){
            boolean[] repetits = new boolean[size()+1];
            
            for (int c = 0; c < size() && correct; ++c) {
                if (repetits[board[f][c].getUserValue()]) {
                    correct = false;
                }else {
                    repetits[board[f][c].getUserValue()] = true;
                }
                
            }
        }
        
        for (int c = 0; c < size() && correct; ++c)  {
            boolean[] repetits = new boolean[size()+1];
    
            for (int f = 0; f < size() && correct; ++f) {
                if (repetits[board[f][c].getUserValue()]) {
                    correct = false;
                }else {
                    repetits[board[f][c].getUserValue()] = true;
                }
                
            }
        }
        
        correct = correct && isResolved();

        return correct;
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
    
    public ArrayList<Region> getRegionsOrderedByOperation() {
        ArrayList<Region> result = new ArrayList<Region>(regions.size());
        
        HashSet<Region> multAndDiv = new HashSet<>();
        HashSet<Region> sumAndSub = new HashSet<>();
        HashSet<Region> none = new HashSet<>();
        
        for (Region r : regions) {
            switch (r.getOperationType()) {
                case Add:
                case Subtract: {
                    sumAndSub.add(r);
                }
                    break;
                case Multiply: 
                case Divide: {
                    multAndDiv.add(r);
                }
                    break;
                case None: {
                    none.add(r);
                }
                    break;
                default:
                    throw new AssertionError(r.getOperationType().name());
                
            }
        }
        
        result.addAll(none);
        result.addAll(multAndDiv);
        result.addAll(sumAndSub);

        
        return result;
    }
    
    public ArrayList<CellKenken> getAllCellsOrderedByOperation() {
        ArrayList<CellKenken> result = new ArrayList<>(size()*size());
        
        for(Region r : getRegionsOrderedByOperation() ) {
            for (CellKenken ck : r.getCellList()) {
                result.add(ck);
            }
        }
        
        return result;
    }
    /*
    public ArrayList<CellKenken> getAllCellsOrderedByRegion() {
        ArrayList<CellKenken> r = new ArrayList<>(size()*size());
        
        Iterator<CellKenken> it = this.iterator();
        
        while(it.hasNext()) {
            r.add(it.next());
        }
        
        return r;
    }
    */

}
