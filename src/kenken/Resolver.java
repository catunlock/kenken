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
    
    public boolean resolve(BoardKenken b) {
        boolean result = false;
        
        
        
        return result;
    }
    
    public static void main(String[] args) {
        BoardKenken b = new BoardKenken(4);
        
        ArrayList<Cell> aCells = new ArrayList<Cell>(3);
        
        aCells.add(b.getCell(0,0));
        aCells.add(b.getCell(0,1));
        aCells.add(b.getCell(1,0));
        
        Region ra = new Region(aCells, Region.OperationType.Multiply, 6, false);
        
        ArrayList<Cell> bCells = new ArrayList<Cell>(3);
        
        bCells.add(b.getCell(0,2));
        bCells.add(b.getCell(0,3));
        bCells.add(b.getCell(1,3));
        
        Region rb = new Region(bCells, Region.OperationType.Add, 9, false);
        
        ArrayList<Cell> cCells = new ArrayList<Cell>(2);
        
        cCells.add(b.getCell(2,0));
        cCells.add(b.getCell(3,0));
        
        Region rc = new Region(cCells, Region.OperationType.Divide, 2, false);
        
        ArrayList<Cell> dCells = new ArrayList<Cell>(3);
        
        dCells.add(b.getCell(1,1));
        dCells.add(b.getCell(2,1));
        dCells.add(b.getCell(3,1));
        
        Region rd = new Region(dCells, Region.OperationType.Multiply, 12, false);
        
        ArrayList<Cell> eCells = new ArrayList<Cell>(2);
        
        eCells.add(b.getCell(1,2));
        eCells.add(b.getCell(2,2));
        
        Region re = new Region(eCells, Region.OperationType.Subtract, 1, false);
        
        ArrayList<Cell> fCells = new ArrayList<Cell>(3);
        
        fCells.add(b.getCell(3,2));
        fCells.add(b.getCell(2,3));
        fCells.add(b.getCell(3,3));
        
        Region rf = new Region(fCells, Region.OperationType.Multiply, 18, false);
        
        ArrayList<Region> regions = new ArrayList<Region>(6);
        
        regions.add(ra);
        regions.add(rb);
        regions.add(rc);
        regions.add(rd);
        regions.add(re);
        regions.add(rf);
        
        b.setRegions(regions);
        
        
        Resolver r = new Resolver();
        if (r.resolve(b)) {
            System.out.println("The solution is: ");
            BoardColorator.print(b);
        }else {
            
        }
    }
}
