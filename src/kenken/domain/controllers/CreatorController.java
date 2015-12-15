/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.util.ArrayList;
import kenken.color.BoardColorator;
import kenken.domain.algorithms.Resolver;
import kenken.domain.classes.Board;
import kenken.domain.classes.CellKenken;
import kenken.domain.classes.Region;
import kenken.gui.InfoCell;
import kenken.persistance.controllers.BoardDBController;

/**
 *
 * @author asus
 */
public class CreatorController {
    private Board board;
    private ArrayList<Region> regions;
    
    public CreatorController() {
        
    }
    
    public void initNewBoard(int size) {
        board = new Board(size);
        regions = new ArrayList<>();
    }
    
    public boolean existRegion(int nRegion) {
        return regions.size() >= nRegion;
    }
    
    public void addRegion(int id, Region.OperationType op, int result, boolean valid) 
    {
        regions.add(new Region(id,new ArrayList<>(),op,result,valid));
    }
    /*
    public void addCellRegion(int f, int c, InfoCell ic){
        CellKenken ck = board.getCell(f, c);
        ck.setHinted(ic.hinted);
        ck.setRegion(editRegion);
        
        regions.get(editRegion-1).getCellList().add(ck);
    }
    */
    
    public boolean resolve(ArrayList<ArrayList<InfoCell>> infoCells){
        
        for (int f = 0; f < infoCells.size(); ++f) {
            for (int c = 0; c < infoCells.size(); ++c) {
                
                InfoCell ic = infoCells.get(f).get(c);
                CellKenken ck = board.getCell(f, c);
                
                ck.setHinted(ic.hinted);
                ck.setRegion(ic.region);
                if(ic.operation.equals("")) {
                    ck.setSolutionValue(Integer.parseInt(ic.value));
                    ck.setUserValue(Integer.parseInt(ic.value));
                }
                regions.get(ic.region-1).addCell(ck);
            }
        }
        
        board.setRegions(regions);
        BoardColorator.printSolution(board);
        
        Resolver resolver = new Resolver();
        resolver.resolve(board);
        
        return resolver.resolve(board);
    }

    public ArrayList<ArrayList<Integer>> getSolutionValues() {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(board.size());
       
        for (int i = 0; i < board.size(); ++i) 
        {
            result.add(new ArrayList<>(board.size()));
            
            for (int j = 0; j < board.size(); ++j) 
            {
                result.get(i).add(board.getCell(i, j).getSolutionValue());
            }
        }
        
        return result;
    }
    
    public int saveBoard(String boardname, String username){
        board.setBoardName(boardname);
        board.setUsername(username);
        BoardController bc = new BoardController();
        return bc.saveCreatedBoard(board);
    }
}
