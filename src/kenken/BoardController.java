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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GERARD
 */
public class BoardController {
    private static final String Directory = "Boards/";
    private static final String Extension = ".obj";
    
    public int saveBoard(Board board, String username){
        int result;
        String id = board.getId();
        String filepath = getPath(id);
        
        if (new File(filepath).isFile()){
            result = -1;
        }
        else {
            result = writeBoard(username, board, filepath);
        }
       
        return result;
    }
    
    public Board loadBoard(String id) throws FileNotFoundException, IOException{
        
        FileInputStream fis;
        Board b = null;
        
        try {
            fis = new FileInputStream(getPath(id));
            ObjectInputStream ois = new ObjectInputStream(fis);
            b = (Board) ois.readObject();
            fis.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
    private String getPath(String id) {
        return Directory+id+Extension;
    }
    
    private int writeBoard(String username, Board b, String filepath) {
        int result;
        
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(username+b);
            fos.close();
            result = 0;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        } catch (IOException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        }        
        
        return result;
    }
}
