/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author xaloc
 */
public class Board implements Serializable{
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
}
