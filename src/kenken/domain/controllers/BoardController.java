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
import kenken.gui.InfoCell;
import kenken.persistance.controllers.BoardDBController;

/**
 *
 * @author joan.pol.alejandre
 */
public class BoardController {
    
    BoardDBController bDBc = new BoardDBController();
    
    /**
     * Default constructor of BoardController.
     */
    public BoardController(){
        
    }
    
    /**
     * Gets an ArrayList of the BoardInfo
     * @return The ArrayList mentioned.
     */
    public ArrayList<BoardInfo> getBoardsInfo(){
        return bDBc.getBoardsInfo();
    }
    
    /**
     * Gets an ArrayList of the BoardInfo to Strings.
     * @param boardname The boardname which will extract all the info.
     * @return An ArrayList with Strings of BoardInfo.
     */
    public ArrayList<String> getBoardInfoString(String boardname){
        return bDBc.getBoardInfoString(boardname);
    }
    
    /**
     * Calls the BoardDBController to get all the boardnames.
     * @return An Arraylist with the names of the boards.
     */
    public ArrayList<String> getBoardnames() {
        return bDBc.getBoardnames();
    }
    
    /**
     * Stores a board into the HDD.
     * @param boardname The Board to store into the HDD.
     * @param file File to be stored the board.
     */
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
    /**
     * Imports a Board from outside the game.
     * @param file The file wanted to import.
     * @return An Integer with the error code  0 : The Board was succesfully created. -1 : The Board already exists. -2 : Internal error.
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
    /**
     * Calls BoardDBController to load a board from the database
     * @param boardName the board to load.
     * @return A Board loaded, if it's NULL, means an error happened.
     */
    public Board loadBoard(String boardName) {
        return bDBc.loadBoard(boardName);
    }
    
    /* TODO: WTF? */
    public Board exportBoard(String boardName) {
        return bDBc.loadBoard(boardName);
    }
    
    /*
       Pre: boardName != null
       Post: retorna true si el nom de taula ja existeix, false altrament
    */
    /**
     * Checks if the board with boardname exists in the database.
     * @param boardName The boardname to check existance in database.
     * @return A boolean with the existance of the board.
     */
    public boolean existsBoard(String boardName){
        return bDBc.exists(boardName);
    }
    
    /**
     * Calls the BoardDController to delete the board with name boardname
     * @param boardname The board with boardname to be deleted.
     * @return An Integer with the error code  0 : The Board was succesfully deleted. -1 : The Board doesn't exist. -2 : Internal error.
     */
    public int deleteBoard(String boardname){
        return bDBc.deleteBoard(boardname);
    }
    
}
