/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.persistance.controllers;

import kenken.domain.classes.Board;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kenken.domain.classes.BoardInfo;
import kenken.domain.controllers.BoardController;

/**
 *
 * @author joan.pol.alejandre
 */
public class BoardDBController {
    
    private static final String DirectoryBoards  = "Boards/brd/";
    private static final String DirectoryInfo = "Boards/info/";
    private static final String ExtensionFisica = ".brd";
    private static final String ExtensionInfo = ".inf";
    
    /**
     * A checker to see if exists the board wanted.
     * @param boardName the Boardname to check its existance.
     * @return A boolean true if the board exists, otherwise returns false.
     */
    public boolean exists(String boardName){
        String path = getPathInfo(boardName);
        String pathInfo = path+ExtensionInfo;
        return new File(pathInfo).isFile();
    }
    
    /**
     * Getter of the Boardnames
     * @return An ArrayList of Strings which contains all the boardnames.
     */
    public ArrayList<String> getBoardnames(){
        ArrayList<String> boards = new ArrayList<>();
        
        File f = new File(DirectoryInfo);
        File[] ficheros = f.listFiles();
        
        for (int x=0;x<ficheros.length;x++){
            String fileName = ficheros[x].getName();
            String[] split = fileName.split("[.]");
            boards.add(split[0]);
        }
        return boards;
    }
    
    
    /**
     * Getter of the info from the board selected.
     * @param boardname The Boardname selected to show the info
     * @return An ArrayList of Strings with the info of the Board.
     */
    public ArrayList<String> getBoardInfoString(String boardname){
        ArrayList<String> info = new ArrayList<>();
        String pathInfo = getPathInfo(boardname);
        try{
            FileInputStream fis = new FileInputStream(pathInfo);   
            ObjectInputStream ois = new ObjectInputStream(fis);
            BoardInfo boardInfo = (BoardInfo) ois.readObject();
            info.add(boardInfo.getCreador());
            info.add(boardInfo.getSize());
            info.add(boardInfo.getDifficult());
            fis.close();
        }catch (ClassNotFoundException ex) {
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (IOException ex) {
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        return info;
    }
    
   
    /**
     * Creates a Board newBoard into the database.
     * @param newBoard The Board to be Created.
     * @return An Integer with the error code  0 : The Board was succesfully created. -1 : The Board already exists. -2 : Internal error.
     */
    public int createBoard(Board newBoard){
        int result = 0;
        int resultInfo = 0;
        int resultObj = 0;

        String pathFisica = getPathBoard(newBoard);
        String pathInfo = getPathInfo(newBoard);
        
        if (new File(pathInfo).isFile() || new File(pathFisica).isFile()) {
            result = -1;
        }
        else{
            
            BoardInfo infoBoard = new BoardInfo(newBoard.getBoardName(),newBoard.getUsername(),String.valueOf(newBoard.size()), newBoard.getDifficult().name());
            //crear el fichero de info y fisico
            resultInfo = writeBoardInfo(infoBoard, pathInfo);
            resultObj = writeBoardObj(newBoard, pathFisica);
                 
            if (resultInfo == -2 || resultObj == -2){
                result = -2;
            }
        }

        return result;
    }
    
    
    /**
     * Deletes a board from the database.
     * @param boardName The Boardname wanted to be deleted.
     * @return An Integer with the error code  0 : The Board was succesfully deleted. -1 : The Board doesn't exist. -2 : Internal error.
     */
    public int deleteBoard(String boardName) {
        
        int result;
        //trobar el path
        
        String pathFisica = getPathBoard(boardName);
        String pathInfo = getPathInfo(boardName);
        boolean Fisica = new File(pathFisica).isFile();
        //si no existeix el Board
        if(!(Fisica)){
            result = -1;
        }else{
            try{
                //eliminem els arxius
                Files.delete(FileSystems.getDefault().getPath(pathFisica));
                Files.delete(FileSystems.getDefault().getPath(pathInfo));
                result = 0;
            }
            catch (IOException ex){
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                result = -2;
            }
        }
        return result;
    }
    
    /*  
    Pre: boardName != NULL
    Post: Retorna el board seleccionat, si b = NULL, el board no existeix
    */
    /**
     * Loads a board from the database.
     * @param boardName The target board brought by its name.
     * @return The loaded Board, if it's NULL, means couldn't be loaded.
     */
    public Board loadBoard(String boardName){
        
        FileInputStream fis;
        Board b = null;
        //generar el posible path
        String pathFisica = getPathBoard(boardName);
        String pathInfo = getPathInfo(boardName);
        
        //nomes intentarem carregar si existeix el arxiu
        if ( (new File(pathInfo).isFile()) ){
            try {
                fis = new FileInputStream(pathFisica);
                ObjectInputStream ois = new ObjectInputStream(fis);
                b = (Board) ois.readObject();
                fis.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (IOException ex) {
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return b;
    }
    
    /**
     * Getter of all the info about all the Boards.
     * @return An ArrayList of BoardInfo containing all the info related.
     */
    public ArrayList<BoardInfo> getBoardsInfo(){
        ArrayList<BoardInfo> boards = new ArrayList<>();
        
        File f = new File("Boards/info");
        File[] ficheros = f.listFiles();
        for (int x=0;x<ficheros.length;x++){
            FileInputStream fis = null;
            BoardInfo boardInfo = null;
            try {
                fis = new FileInputStream("Boards/info/"+ficheros[x].getName());
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                try {
                    boardInfo = (BoardInfo) ois.readObject();
                    boards.add(boardInfo);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                }               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return boards;
    }
    
   
    /**
     * Getter of the filepath related to the Board.
     * @param board The board to get the filepath.
     * @return A String with the Filepath.
     */
    private String getPathBoard(Board board){
        return getPathBoard(board.getBoardName());
    }
    
    /**
     * Getter of the filepath related to the infoBoard.
     * @param board The board to get the filepath.
     * @return A String with the Filepath.
     */
    private String getPathInfo(Board board){
        return getPathInfo(board.getBoardName());
    }
    
    /* 
    Pre: boardName != null
    Post: retorna un string amb el path en el que hauria de guardarse el board tenint en compte el directori
    */
    /**
     * Getter of the filepath related to the Boardname.
     * @param boardName The board to get the filepath.
     * @return A String with the Filepath.
     */
    private String getPathBoard(String boardName){
        return DirectoryBoards+boardName+ExtensionFisica;
    }
    
    /**
     * Getter of the filepath related to the infoBoard.
     * @param boardName The board to get the filepath.
     * @return A String with the Filepath.
     */
    private String getPathInfo(String boardName){
        return DirectoryInfo+boardName+ExtensionInfo;
    }
    
    /* 
    Pre: infoBoard != null, infoPath es un path de un arxiu encara no existent
    Post: Escriu la informacio de board a l'arxiu <nomboard>.inf al path demanat
        Return:
            0:  Informacio de board guardada correctament
            -2: Error intern
    */
    /**
     * Writes the infoBoard into the database.
     * @param infoBoard The info from the previously selectec Board.
     * @param infoPath The path where the infoBoard goes.
     * @return An Integer with the error code  0 : The infoBoard was succesfully written. -2 : Internal error.
     */
    private int writeBoardInfo(BoardInfo infoBoard, String infoPath) {
        int result;
        
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(infoPath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(infoBoard);
            fos.close();            
            result = 0;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        } catch (IOException ex) {
            Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        }
                
        return result;
    }
    
     /* 
    Pre: newBoard != null, pathFisica es un path de un arxiu encara no existent
    Post: Escriu la informacio de board a l'arxiu <nomboard>.brd al path demanat
        Return:
            0:  Board guardada correctament
            -2: Error intern
    */
    /**
     * Write the Board into the database.
     * @param newBoard The board wanted to be written into the database.
     * @param pathFisica The path where the file will be stored.
     * @return An Integer with the error code  0 : The Board was succesfully written. -2 : Internal error.
     */
    private int writeBoardObj(Board newBoard, String pathFisica) {
        int result;
        
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(pathFisica);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newBoard);
            fos.close();            
            result = 0;
        }catch (FileNotFoundException ex) {
            Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        }catch (IOException ex) {
            Logger.getLogger(BoardDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        }
                
        return result;
    }
    
    /*
    Pre: boardname != null & file != null
    Post: guarda la board con boardname en el fichero file
    */  
    public void saveBoard(String boardname, File file){
        FileOutputStream fos;      
        Board newBoard = loadBoard(boardname);     
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
}
