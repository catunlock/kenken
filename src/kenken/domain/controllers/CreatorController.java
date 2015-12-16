/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.util.ArrayList;
import java.util.Iterator;
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
    
    /**
     * Default constructor of CreatorController.
     */
    public CreatorController() {
        
    }
    
    /**
     * Initializes a new Board with a size.
     * @param size Size of the new Board.
     * @param difficult Difficult of the new Board.
     */
    public void initNewBoard(int size, String difficult) {
        board = new Board(size);
        board.setDifficult(Board.Difficult.valueOf(difficult));
        regions = new ArrayList<>();
    }
    
    /**
     * Checks existance of a Region.
     * @param nRegion The Region to be checked.
     * @return True if exists, otherwise false.
     */
    public boolean existRegion(int nRegion) {
        return regions.size() >= nRegion;
    }
    
    /**
     * Adds a Region into a Board to be created.
     * @param id The identification of the board.
     * @param op The operation of the region.
     * @param result The result of the region.
     * @param valid false.
     */
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
    
    /**
     * Tries to solve the board created.
     * @param infoCells The Board created by the user.
     * @return true if it can be resolved, false otherwise.
     */
    public boolean resolve(ArrayList<ArrayList<InfoCell>> infoCells){
        
        for (int f = 0; f < infoCells.size(); ++f) {
            for (int c = 0; c < infoCells.size(); ++c) {
                
                InfoCell ic = infoCells.get(f).get(c);
                CellKenken ck = board.getCell(f, c);         
                ck.setHinted(ic.hinted);
                ck.setRegion(ic.region);
                
                if(ic.operation.equals("")) {
                    ck.setSolutionValue(Integer.parseInt(ic.result));
                    ck.setUserValue(Integer.parseInt(ic.result));
                }
                regions.get(ic.region-1).addCell(ck);
            }
        }
        
        board.setRegions(regions);
        Resolver resolver = new Resolver();
            
        boolean resultat = resolver.resolve(board);
        if (resultat) this.board = resolver.getBoardSolved();
        
        return resultat;
    }
    
    /**
     * Get all the user values from the board.
     * @return A Matrix as the user values board.
     */
    public ArrayList<ArrayList<Integer>> getUserValues() {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(board.size());
       
        for(int f = 0; f < board.size(); ++f) {
            result.add(new ArrayList<>(board.size()));
            for (int c = 0; c < board.size(); ++c) {
                result.get(f).add(0);
            }
        }
        
        Iterator<CellKenken> it = board.iterator();
        while(it.hasNext()) {
            CellKenken ck = it.next();
            
            result.get(ck.getPosX()).set(ck.getPosY(), ck.getUserValue());
        }
        
        return result;
    }
    
    /**
     * Saves the board created by the user.
     * @param boardname The name of the new created Board.
     * @param username The username of the creator.
     * @return An Integer with the error code  0 : The Board was succesfully created. -1 : The Board already exists. -2 : Internal error.
     */
    public int saveBoard(String boardname, String username, String difficult){
        board.setBoardName(boardname);
        board.setUsername(username);
        board.setDifficult(Board.Difficult.valueOf(difficult));
        
        BoardController bc = new BoardController();
        
        for (int i = 0; i < board.size(); ++i){
            for (int j = 0; j < board.size(); ++j){
                board.getCell(i, j).setUserValue(-1);
            }
        }
        
        return bc.saveCreatedBoard(board);
    }
}
