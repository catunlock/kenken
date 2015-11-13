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
                
                /* tamaño tablero, persona que lo ha creado, */
        
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
            if (resultInfo == -2 || resultObj == -2){
                result = -2;
            }
        }

        return result;
    }
    
    /*  Pre: boardName != NULL
    ** Post: Retorna un int el qual, segons el valor que tingui, indicarà si 
             sha eliminat de la base de dades el board amb id idBoard, o bé 
             si sha produït alguna excepció.
    Return:
         0 = board eliminat correctament
        -1 = board no existent
        -2 = error intern
    */
    public int deleteBoard(int idBoard){
        
        int result = -2;
        String path = getPath(String.valueOf(idBoard));
        String pathFisica = path+ExtensionFisica;
        String pathInfo = path+ExtensionInfo;
        
        //si no existeix el Board
        if ( !(new File(pathFisica).isFile()) || !(new File(pathInfo).isFile())){
            result = -1;
        }
        else{
            try{
                Files.delete(FileSystems.getDefault().getPath(pathFisica));
                Files.delete(FileSystems.getDefault().getPath(pathInfo));
                result = 0;
            }
            catch (IOException ex){
                result = -3;
            }
        }
        return result;
    }
    /*
    public Board loadBoard(String nameBoard) throws FileNotFoundException, IOException{
        
        FileInputStream fis;
        Board b = null;
        String path = getPath(String.valueOf(nameBoard));
        String pathFisica = path+ExtensionFisica;
        String pathInfo = path+ExtensionInfo;
        
        try {
            fis = new FileInputStream(pathInfo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<String> informacio = null;
            informacio = (ArrayList) ois.readObject();
            b.setDifficulty(informacio.get(1));
            b.setSizeX(Integer.parseInt(informacio.get(2)));
            b.setSizeY(Integer.parseInt(informacio.get(3)));
            fis.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
        */                
    private String getPath(Board board){
        return getPath(String.valueOf(board.getId()));
    }
    
    private String getPath(String boardId){
        return Directory+boardId;
    }

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
            //Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        } catch (IOException ex) {
            result = -2;
        }
                
        return result;
    }

    private int writeBoardObj(Board newBoard, String pathFisica) {
        int result;
        
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(pathFisica);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newBoard);
            fos.close();            
            result = 0;
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        } catch (IOException ex) {
            result = -2;
        }
                
        return result;
    }
    
}
