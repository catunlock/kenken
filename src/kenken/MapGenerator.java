/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import kenken.color.BoardColorator;
import kenken.domain.algorithms.Resolver;
import kenken.domain.classes.Board;
import kenken.domain.classes.CellKenken;
import kenken.domain.classes.Region;
import kenken.persistance.controllers.BoardDBController;

/**
 *
 * @author SuNLoCK
 */
public class MapGenerator {
    
    public Board original4() {
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
        gCell1.setUserValue(3);
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
        
        b.setRegions(regions);
        b.setBoardName("Original 4x4");
        b.setUsername("SuNLoCK");
        b.setDifficult(Board.Difficult.Medium);
        

        
        BoardColorator.printSolution(b);
        BoardColorator.printRegions(b);

        return b;
    }
    
    public Board original7() {
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
        kCell1.setUserValue(4);
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
        
        b.setBoardName("Gerard 7x7");
        b.setUsername("Gerard");
        b.setDifficult(Board.Difficult.Hard);
                
        BoardColorator.printSolution(b);
        BoardColorator.printRegions(b);

        return b;
    }

    public static void main(String[] args) throws FileNotFoundException {
        MapGenerator mg = new MapGenerator();
        mg.original4();
        mg.original7();
        
        BoardDBController bdbc = new BoardDBController();
        bdbc.createBoard(mg.original4());
        bdbc.createBoard(mg.original7());
    }
    
}
