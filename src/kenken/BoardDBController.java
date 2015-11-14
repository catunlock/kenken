/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

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

/**
 *
 * @author joan.pol.alejandre
 */
public class BoardDBController {
    
    private static final String Directory = "Boards/";
    private static final String ExtensionFisica = ".brd";
    private static final String ExtensionInfo = ".inf";
    
    
    public boolean exists(String boardName){
        String path = getPath(boardName);
        String pathInfo = path+ExtensionInfo;
        return new File(pathInfo).isFile();
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
        String ubicacio = getPath(newBoard);
                
        /* info del tauler:
            Nom, User, */
        
        String pathFisica = ubicacio+ExtensionFisica;
        String pathInfo = ubicacio+ExtensionInfo;
        
        if (new File(pathInfo).isFile() || new File(pathFisica).isFile()) {
            result = -1;
        }
        else{
            /* info de tablero contiene: nombre tablero, persona que lo ha creado, dificultad, tamX, tamY */
            ArrayList<String> infoBoard = new ArrayList<String>();
            infoBoard.add(newBoard.getBoardName());
            infoBoard.add(newBoard.getUsername());
            infoBoard.add(newBoard.getDifficulty());
            infoBoard.add(String.valueOf(newBoard.getSizeX()));
            infoBoard.add(String.valueOf(newBoard.getSizeY()));
            
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
        String path = getPath(boardName);
        String pathFisica = path+ExtensionFisica;
        String pathInfo = path+ExtensionInfo;
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
    
    /*  Pre: boardName != NULL
    ** Post: Retorna el board seleccionat, si b = NULL, el board no existeix
    */
    public Board loadBoard(String nameBoard){
        
        FileInputStream fis;
        Board b = null;
        //generar el posible path
        String path = getPath(nameBoard);
        String pathFisica = path+ExtensionFisica;
        String pathInfo = path+ExtensionInfo;
        
        //nomes intentarem carregar si existeix el arxiu
        if ( (new File(pathInfo).isFile()) ){
            try {
                fis = new FileInputStream(pathFisica);
                System.out.println(pathFisica);
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
           
    private String getPath(Board board){
        return getPath(board.getBoardName());
    }
    
    private String getPath(String boardName){
        return Directory+boardName;
    }
    
    /* Escriu la informacio de board a l'arxiu <nombard>.inf al path demanat */
    private int writeBoardInfo(ArrayList<String> infoBoard, String infoPath) {
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
    
    /* Escriu el objecte board al path demanat */
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
