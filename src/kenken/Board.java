/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xaloc
 */
public class Board {
    ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();
    
    public Board(int size) {
        for (int i = 0; i < size; ++i){
            board.add(new ArrayList<Cell>(size));
            for (int j = 0; j < size; ++j) {
                board.get(i).add(new Cell(i,j,true));
            }
        }
    }
    
    public Cell getCell(int x, int y) {
        return board.get(x).get(y);
    }
    
    public int size() {
        return board.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int f = 0; f < board.size(); ++f) {
            for (int c = 0; c < board.size(); ++c) {
                sb.append(board.get(f).get(c).getSolutionValue());
            }
            sb.append('\n');
        }
        return sb.toString();
    }
    
    public static Board toBoard(String b){
        return null;
    }
    
    
}
