/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

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
    
    Board board = null;
    private ArrayList<ArrayList<Boolean>> numerosFila;
    private ArrayList<ArrayList<Boolean>> numerosColumna;
    
    private ArrayList<ArrayList<Boolean>> untouchables;
    
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
    
    private boolean checkRegion(Region r) {
        Region.OperationType op = r.getOperationType();
            
        boolean result = false;
        Iterator<Cell> it = r.getCellList().iterator();

        if(it.hasNext()){
            int resultValue = it.next().getSolutionValue();

            while (it.hasNext()) {
                Cell c = it.next();

                switch(op) {
                    case Add:
                        resultValue += c.getSolutionValue();
                        break;
                    case Subtract:
                        resultValue = abs(resultValue - c.getSolutionValue());
                        break;
                    case Multiply:
                        resultValue *= c.getSolutionValue();
                        break;
                    case Divide:
                        resultValue = max(resultValue,c.getSolutionValue())/ min(resultValue,c.getSolutionValue());
                        break;                    
                }
                
            }
            if (resultValue == r.getResult()) {
                    result = true;
            }
        }
        return result;
    }
    
    private boolean checkSolution() {
        ArrayList<Region> regions = board.getRegions();
        
        boolean correct = true;
        int i = 0;
        while (correct && i < regions.size()) {
            correct = checkRegion(regions.get(i));
            ++i;
        }
        
        return correct;
    }
    
    public void backtrack(Pos p) {
        
        if (p.f == board.size() && p.c == 0) { 
            if (checkSolution()) {
                BoardColorator.print(board);
                System.out.println();
            }
            //escriure(board);
        }
        else if (untouchables.get(p.f).get(p.c)) {
            backtrack(nextCell(p));
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
        untouchables = new ArrayList<>();
        
        for (int i = 0; i < board.size(); ++i) {
            numerosFila.add(new ArrayList<>());
            numerosColumna.add(new ArrayList<>());
            untouchables.add(new ArrayList<>());
            
            for (int j = 0; j < board.size(); ++j) {
                numerosFila.get(i).add(false);
                numerosColumna.get(i).add(false);
                untouchables.get(i).add(false);
            }
        }
        
        
        for (Region r : b.getRegions()) {
            if (r.getOperationType() == Region.OperationType.None) {
                Cell c = r.getCellList().get(0);
                untouchables.get(c.getPosX()).set(c.getPosY(), true);
                
                numerosFila.get(c.getPosX()).set(c.getSolutionValue() -1, true);
                numerosColumna.get(c.getPosY()).set(c.getSolutionValue() -1, true);
            }
        }
        
        backtrack(new Pos(0,0));
        
        return result;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        /*File file = new File("output2.log"); 
        PrintStream printStream = new PrintStream(new FileOutputStream(file)); 
        System.setOut(printStream);*/
        
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
        
        ArrayList<Cell> fCells = new ArrayList<>(1);
        Cell fCell1 = b.getCell(3,2);
        fCell1.setSolutionValue(3);
        fCells.add(fCell1);
        Region rf = new Region(7,fCells, Region.OperationType.None, 3, false);
        
        ArrayList<Cell> gCells = new ArrayList<>(1);
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
