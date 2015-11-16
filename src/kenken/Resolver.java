/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.ArrayList;
import kenken.color.BoardColorator;

/**
 *
 * @author SuNLoCK
 */
public class Resolver {
    
    Board board = null;
    private ArrayList<ArrayList<Boolean>> numerosFila;
    private ArrayList<ArrayList<Boolean>> numerosColumna;
    
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
    
    private Pos nextCell(Pos pos) {

        Pos r = new Pos(pos);
        
        if (r.c < board.size()-1) {
                r.c++;
        }
        else {
                r.c = 0;
                r.f++;
        }
        
        return r;
    }
    
    private boolean checkSolution() {
        boolean result = false;
        
        
        
        return result;
    }
    
    public void backtrack(Pos p) {
        
        if (p.f == board.size() && p.c == 0) { 
            BoardColorator.print(board);
            System.out.println();
        }
        else {
            for (int i = 0; i < board.size(); ++i) {
                if (! numerosFila.get(p.f).get(i) && ! numerosColumna.get(p.c).get(i)) 
                {    
                    board.getCell(p.f, p.c).setSolutionValue(i+1);
                                        
                    numerosFila.get(p.f).set(i, true);
                    numerosColumna.get(p.c).set(i, true);

                    backtrack(nextCell(p));

                    numerosFila.get(p.f).set(i, false);
                    numerosColumna.get(p.c).set(i, false);

                }
            }
        }
    }

    
    public boolean resolve(Board b) {
        boolean result = false;
        
        board = b;
        
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
        
        backtrack(new Pos(0,0));
        
        return result;
    }
    
    public static void main(String[] args) {
        Board b = new Board(4);
        
        ArrayList<Cell> aCells = new ArrayList<>(3);
        
        aCells.add(b.getCell(0,0));
        aCells.add(b.getCell(0,1));
        aCells.add(b.getCell(1,0));
        
        Region ra = new Region(1,aCells, Region.OperationType.Multiply, 6, false);
        
        ArrayList<Cell> bCells = new ArrayList<>(3);
        
        bCells.add(b.getCell(0,2));
        bCells.add(b.getCell(0,3));
        bCells.add(b.getCell(1,3));
        
        Region rb = new Region(2,bCells, Region.OperationType.Add, 9, false);
        
        ArrayList<Cell> cCells = new ArrayList<>(2);
        
        cCells.add(b.getCell(2,0));
        cCells.add(b.getCell(3,0));
        
        Region rc = new Region(3,cCells, Region.OperationType.Divide, 2, false);
        
        ArrayList<Cell> dCells = new ArrayList<>(3);
        
        dCells.add(b.getCell(1,1));
        dCells.add(b.getCell(2,1));
        dCells.add(b.getCell(3,1));
        
        Region rd = new Region(4,dCells, Region.OperationType.Multiply, 12, false);
        
        ArrayList<Cell> eCells = new ArrayList<>(2);
        
        eCells.add(b.getCell(1,2));
        eCells.add(b.getCell(2,2));
        
        Region re = new Region(5,eCells, Region.OperationType.Subtract, 1, false);
        
        ArrayList<Cell> fCells = new ArrayList<>(3);
        
        fCells.add(b.getCell(3,2));
        fCells.add(b.getCell(2,3));
        fCells.add(b.getCell(3,3));
        
        Region rf = new Region(6,fCells, Region.OperationType.Multiply, 18, false);
        
        ArrayList<Region> regions = new ArrayList<>(6);
        
        regions.add(ra);
        regions.add(rb);
        regions.add(rc);
        regions.add(rd);
        regions.add(re);
        regions.add(rf);
        
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
