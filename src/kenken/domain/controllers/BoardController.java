/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kenken.domain.classes.Board;
import kenken.domain.classes.BoardInfo;
import kenken.persistance.controllers.BoardDBController;

/**
 *
 * @author joan.pol.alejandre
 */
public class BoardController {
    
    BoardDBController bDBc = new BoardDBController();
    
    public BoardController(){
        
    }
    
    public ArrayList<BoardInfo> getBoardsInfo(){
        return bDBc.getBoardsInfo();
    }
    
    public ArrayList<String> getBoardInfoString(String boardname){
        return bDBc.getBoardInfoString(boardname);
    }
    
    public ArrayList<String> getBoardnames() {
        return bDBc.getBoardnames();
    }
    
    
    public void saveBoard(String boardname, File file){
        FileOutputStream fos;      
        Board newBoard = exportBoard(boardname);     
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(newBoard);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    /* Pre: board != null
       Post: retorna 0 si s'ha importat correctament, -1 si ja existeix la board, -2 error intern 
    */
    public int importBoard(File file) {
        Board board;
        try {
            FileInputStream fis = new FileInputStream(file.getPath());
            ObjectInputStream ois = new ObjectInputStream(fis);
            board = (Board) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, e);
            return -2;
        }
        System.out.println(board.getBoardName());
        return bDBc.createBoard(board);    
    }
    
    /* Pre: boardName != null
       Post: retorna la board amb nom boardName, si no existeix, retorna null
    */
    public Board exportBoard(String boardName){
        return bDBc.loadBoard(boardName);
    }
    /*
       Pre: boardName != null
       Post: retorna true si el nom de taula ja existeix, false altrament
    */
    public boolean existsBoard(String boardName){
        return bDBc.exists(boardName);
    }
    
    public int deleteBoard(String boardname){
        return bDBc.deleteBoard(boardname);
    }
    
}
