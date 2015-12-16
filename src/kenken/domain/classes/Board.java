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
    public enum Difficult {
        Easy, Medium, Hard, Insane
    }
    
    private String name;
    private String username;
    private CellKenken[][] board;
    private ArrayList<Region> regions;
    private Difficult difficult;

    public Difficult getDifficult() {
        return difficult;
    }

    public void setDifficult(Difficult difficult) {
        this.difficult = difficult;
    }
    
      
    /**
     * Constructor of Board with size parameter.
     * @param size The size of the new Board.
     */
    public Board(int size) {
        board = new CellKenken[size][size];
        for (int i = 0; i < size; ++i){
            for (int j = 0; j < size; ++j) {
                board[i][j] = new CellKenken(i,j,true);
            }
        }
        
        regions = new ArrayList<>();
    }
    
    /**
     * Copy constructor of Board.
     * @param b Copy b and creates a new Board.
     */
    public Board(Board b) {
        this.name = b.name;
        this.username = b.username;
        this.board = new CellKenken[b.size()][b.size()];
        
        for (int f = 0; f < b.size(); ++f) {
            for (int c = 0; c < b.size(); ++c) {
                this.board[f][c] = new CellKenken(b.getCell(f, c));
            }
        }
        
        regions = new ArrayList<>();
        for (int i = 0; i < b.getRegions().size(); ++i) {
            Region r = b.getRegions().get(i);
            
            ArrayList<CellKenken> prevCells = r.getCellList();
            ArrayList<CellKenken> newCells = new ArrayList<>();
            for (int j = 0; j < prevCells.size(); ++j) {
                CellKenken prevCK = prevCells.get(j);
                
                newCells.add(this.board[prevCK.getPosX()][prevCK.getPosY()]);
                
            }
            
            regions.add(new Region(r.getId(),newCells, r.getOperationType(), r.getResult(), r.isValid()));
            
        }
    }
    
    /**
     * Getter of the Boardname.
     * @return A String with the BoardName.
     */
    public String getBoardName(){
        return name;
    }
      
    /**
     * Getter of the Username.
     * @return A String with the username.
     */
    public String getUsername(){
        return username;
    }
    
     /**
     * Setter of boardname.
     * @param boardname Replaces this.boardname by boardname.
     */
    public void setBoardName(String boardname){
        this.name = boardname;
    }
    
    /**
     * Setter of username.
     * @param username Sets this.username with username.
     */
    public void setUsername(String username){
        this.username = username;
    }
    
    /**
     * Getter of CellKenken from the Board.
     * @param x The row location of the cell.
     * @param y The column location of the cell.
     * @return A CellKenken at the pos (x,y)
     */
    public CellKenken getCell(int x, int y) {
        return board[x][y];
    }
    
    /**
     * Getter of board's size.
     * @return An Integer with the board's size.
     */
    public int size() {
        return board.length;
    }
    
    /**
     * Setter of CellKenken given a Position.
     * @param x  The row location of the cell.
     * @param y  The column location of the cell.
     * @param c The CellKenken which will replace the old CellKenken.
     */
    public void setCell(int x, int y, CellKenken c) {
        board[x][y] = c;
    }

    /**
     * Converts a Board into a String.
     * @return The Board changed to a String.
     */
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
    
    /**
     * Setter of Regions.
     * @param regions The new ArrayList which will set the region.
     */
    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }
    
    /**
     * Getter of Region.
     * @return Returns the Region as a copy.
     */
    public ArrayList<Region> getRegions() {
        return new ArrayList<Region>(regions);
    }
    
    /**
     * Converts the String into a Board.
     * @param b The String with al the board info.
     * @return The Object Board converted.
     */
    public static Board toBoard(String b){
        return null;
    }
    
    /**
     * Shows us if the Board is correct.
     * @return A boolean true if it is resolved, otherwise will be false.
     */
    public boolean isCorrect() {
        boolean correct = true;
        
        for (int f = 0; f < size() && correct; ++f){
            boolean[] repetits = new boolean[size()+1];
            
            for (int c = 0; c < size() && correct; ++c) {
                if (board[f][c].getUserValue() == -1) {
                    correct = false;
                }
                else if (repetits[board[f][c].getUserValue()]){
                    correct = false;
                }
                else {
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
    
    /**
     * Checks if the Board is resolved.
     * @return True if it's resolved, otherwise false.
     */
    public boolean isResolved() {
        boolean correct = true;

        int i = 0;
        while (correct && i < regions.size()) {
            correct = regions.get(i).isValid();
            ++i;
        }
        
        return correct;
    }

    
    /**
     * Creates an Iterator  to go through the regions.
     * @return A new Iterator to use it with regions.
     */
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
    
    /**
     * Gets an ArrayList of Regions ordered by operation.
     * @return An ArrayList of Regions ordered by operation.
     */
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
    
    /**
     * Gets an ArrayList of Cells ordered by operation.
     * @return An ArrayList of Cells ordered by operation.
     */
    public ArrayList<CellKenken> getAllCellsOrderedByOperation() {
        ArrayList<CellKenken> result = new ArrayList<>(size()*size());
        
        for(Region r : getRegionsOrderedByOperation() ) {
            for (CellKenken ck : r.getCellList()) {
                result.add(ck);
            }
        }
        
        return result;
    }
    
    /**
     * Getter of cells ordered by region.
     * @return An ArrayList of CellKenken which we'll have the cells ordered by region.
     */
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
