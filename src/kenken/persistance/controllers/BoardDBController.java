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

/**
 *
 * @author joan.pol.alejandre
 */
public class BoardDBController {
    
    private static final String DirectoryBoards  = "Boards/brd/";
    private static final String DirectoryInfo = "Boards/info/";
    private static final String ExtensionFisica = ".brd";
    private static final String ExtensionInfo = ".inf";
    
    
    public boolean exists(String boardName){
        String path = getPathInfo(boardName);
        String pathInfo = path+ExtensionInfo;
        return new File(pathInfo).isFile();
    }
    
    public ArrayList<String> getBoardnames(){
        ArrayList<String> boards = new ArrayList<>();
        File f = new File(DirectoryBoards);
        File[] ficheros = f.listFiles();
        for (int x=0;x<ficheros.length;x++){
            boards.add(ficheros[x].getName());
        }
        return boards;
    }
    
    /* Pre:  cert
    ** Post: Retorna un int el qual, segons el valor que tingui, indicarà que
             s'ha creat a la base de dades una nova Board, o bé hi ha hagut algun problema.
        Return:
             0 = board creada correctament
            -1 = board existent
            -2 = error intern
    */
    public int createBoard(Board newBoard){
        int result = 0;
        int resultInfo = 0;
        int resultObj = 0;
        String pathBrd = getPathBoard(newBoard);
        String pathInf = getPathInfo(newBoard);
        String pathFisica = pathBrd+ExtensionFisica;
        String pathInfo = pathInf+ExtensionInfo;
        
        if (new File(pathInfo).isFile() || new File(pathFisica).isFile()) {
            result = -1;
        }
        else{
            /* info de tablero contiene: nombre tablero, persona que lo ha creado, dificultad, tamX, tamY */
            /*ArrayList<String> infoBoard = new ArrayList<>();
            infoBoard.add(newBoard.getBoardName());
            infoBoard.add(newBoard.getUsername());
            infoBoard.add(String.valueOf(newBoard.size()));
            */
            
            BoardInfo infoBoard = new BoardInfo(newBoard.getBoardName(),newBoard.getUsername(),String.valueOf(newBoard.size()));
            //crear el fichero de info y fisico
            resultInfo = writeBoardInfo(infoBoard, pathInfo);
            resultObj = writeBoardObj(newBoard, pathFisica);
            
            //comprobar errores
            System.out.println("resultInfo: " + resultInfo);
            System.out.println("resultObj: " + resultObj);      
            if (resultInfo == -2 || resultObj == -2){
                result = -2;
            }
        }

        return result;
    }
    
    /*  Pre: boardName != NULL
    ** Post: Retorna un int el qual, segons el valor que tingui, indicarà si 
             sha eliminat de la base de dades el board amb nom boardName, o bé 
             si sha produït alguna excepció.
    Return:
         0 = board eliminat correctament
        -1 = board no existent
        -2 = error intern
    */
    public int deleteBoard(String boardName) {
        
        int result;
        //trobar el path
        String pathBrd = getPathBoard(boardName);
        String pathInf = getPathInfo(boardName);
        String pathFisica = pathBrd+ExtensionFisica;
        String pathInfo = pathInf+ExtensionInfo;
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
    public Board loadBoard(String boardName){
        
        FileInputStream fis;
        Board b = null;
        //generar el posible path
        String pathBrd = getPathBoard(boardName);
        String pathInf = getPathInfo(boardName);
        String pathFisica = pathBrd+ExtensionFisica;
        String pathInfo = pathInf+ExtensionInfo;
        
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
    
    /* 
    Pre: board != null
    Post: retorna un string amb el path en el que hauria de guardarse el board
    */
    private String getPathBoard(Board board){
        return getPathBoard(board.getBoardName());
    }
    
    private String getPathInfo(Board board){
        return getPathInfo(board.getBoardName());
    }
    
    /* 
    Pre: boardName != null
    Post: retorna un string amb el path en el que hauria de guardarse el board tenint en compte el directori
    */
    private String getPathBoard(String boardName){
        return DirectoryBoards+boardName;
    }
    
    private String getPathInfo(String boardName){
        return DirectoryInfo+boardName;
    }
    
    /* 
    Pre: infoBoard != null, infoPath es un path de un arxiu encara no existent
    Post: Escriu la informacio de board a l'arxiu <nomboard>.inf al path demanat
        Return:
            0:  Informacio de board guardada correctament
            -2: Error intern
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
    
}
