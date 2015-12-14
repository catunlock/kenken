/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.util.ArrayList;
import kenken.domain.classes.Board;
import kenken.domain.classes.CellKenken;
import kenken.domain.classes.Region;
import kenken.gui.InfoCell;

/**
 *
 * @author SuNLoCK
 */
public class BoardParser {
        
        private ArrayList<ArrayList<InfoCell>> infoCells;
        private Board board;
        
        public BoardParser(ArrayList<ArrayList<InfoCell>> infoCells){
            this.infoCells = infoCells;
        }
        
        public BoardParser(Board board) {
            this.board = board;
        }
        
        public BoardParser(){
            
        }
        
        private void initMatrix() {
            int size = board.size();
            infoCells = new ArrayList<>(size);

            for (int i = 0; i < size; ++i) 
            {
                infoCells.add(new ArrayList<>(size));

                for (int j = 0; j < size; ++j) 
                {
                    CellKenken ck = board.getCell(i, j);
                    InfoCell ic = new InfoCell();       
                    ic.hinted = ck.isHinted();
                    
                    if (ck.getUserValue() != -1 ) {
                        ic.value = String.valueOf(ck.getUserValue());
                    }
                    
                    infoCells.get(i).add(ic);
                }
            }
        }
        
        private void detectVerticalLimits() {
            
            for (int f = 0; f < infoCells.size(); ++f) {
                for (int c = 1; c < infoCells.size(); ++c) {
                    CellKenken ck1 = board.getCell(f, c-1);
                    CellKenken ck2 = board.getCell(f, c);
                    int prevRegion = ck1.getRegion();
                    int currentRegion = ck2.getRegion();

                    if (prevRegion  != currentRegion) {
                        infoCells.get(f).get(c).borderVertical = true;
                    }
                }
            }
        }
        
        private void detectHoritzontalLimits() {
            
            for (int c = 0; c < infoCells.size(); ++c) {
                for (int f = 1; f < infoCells.size(); ++f) {
                    int prevRegion = board.getCell(f-1, c).getRegion();
                    int currentRegion = board.getCell(f, c).getRegion();

                    if (prevRegion  != currentRegion) {
                        infoCells.get(f).get(c).borderHoritzontal = true;
                    }
                }
            }
        }
        
        private void detectOperations() {
            boolean[] detectats = new boolean[board.getRegions().size()+1];
            
            for (int f = 0; f < infoCells.size(); ++f) {
                for (int c = 0; c < infoCells.size(); ++c) {
                    CellKenken ck = board.getCell(f, c);
                    int currentRegion = ck.getRegion() - 1;

                    if (! detectats[currentRegion]) {
                        detectats[currentRegion] = true;
                        
                        Region r = board.getRegions().get(currentRegion);
                        infoCells.get(f).get(c).operation = convertToSimbol(r.getOperationType());
                        infoCells.get(f).get(c).result = String.valueOf(r.getResult());

                    }
                }
            }
        }
        
        private String convertToSimbol(Region.OperationType op) {
            switch(op) {
                case Add:
                    return "+";
                case Subtract:
                    return "-";
                case Multiply:
                    return "*";
                case Divide:
                    return "/";
                case None:
                    return "";
                default:
                    throw new AssertionError(op.name());
                
            }
        }
        
        public ArrayList<ArrayList<InfoCell>> getInfoBoard() {

            initMatrix();

            detectVerticalLimits();
            detectHoritzontalLimits();

            detectOperations();
                       

            return infoCells;

        }
        
         public Board parseInfoCell(){
            ArrayList<Region> regions = new ArrayList<>();
            Board b = new Board(infoCells.size());
            int size = infoCells.size();
            int region;       
            for (int i = 0; i < size; ++i){
                for (int j = 0; j < size; ++j){
                    String operation;
                    InfoCell ic = infoCells.get(i).get(j);
                    if ("-".equals(ic.operation)){
                        operation = "Subtract";
                    }else if("+".equals(ic.operation)){
                        operation = "Add";
                    }else if("*".equals(ic.operation)){
                        operation = "Multiply";
                    }else if("/".equals(ic.operation)){
                        operation = "Divide";                        
                    }else{
                        operation = "None";
                    }
                    region = ic.region;
                    CellKenken ck = new CellKenken(i,j,false);
                    ck.setHinted(ic.hinted);
                    ck.setRegion(region);
                    ck.setUserValue(Integer.parseInt(ic.value));
                    b.setCell(j, j, ck);
                    boolean trobat = false;
                    int numreg = -1;
                    for (int z = 0; z < regions.size() && numreg == -1; ++z){
                        if (regions.get(z).getId() == region) numreg = z;
                    }
                    if (numreg == -1){
                        ArrayList<CellKenken> ack = new ArrayList<>();
                        ack.add(ck);
                        System.out.println(operation);
                        Region r = new Region(region, ack, Region.OperationType.valueOf(operation), Integer.parseInt(ic.result), ic.correct);
                        regions.add(r);
                    }
                    else{
                        ArrayList<CellKenken> ack = regions.get(numreg).getCellList();
                        ack.add(ck);
                        regions.get(numreg).setCellList(ack);
                    }    
                }
            }   
            b.setRegions(regions);
            return b;
         }
    }