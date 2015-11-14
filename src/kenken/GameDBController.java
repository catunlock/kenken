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
import java.util.logging.Level;
import java.util.logging.Logger;
//import kenken.dominio;

/**
 *
 * @author GERARD
 */
public class GameDBController {
    
    private static final String Directory = "Games/";
    private static final String Extension = ".obj";
    
    public int saveGame(Game game, String username){
        int result;
        Board b = game.getBoard();
        String boardName = b.getBoardName();
        String filepath = getPath(boardName, username);
        
        if (new File(filepath).isFile()){
            result = -1;
        }
        else {
            result = writeGame(game, filepath);
        }
       
        return result;
    }
    
    public Game loadGame(String username, String boardid) throws FileNotFoundException, IOException{
        
        FileInputStream fis;
        Game game = null;
        
        try {
            fis = new FileInputStream(getPath(boardid, username));
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
            fis.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return game;
    }
    
    private String getPath(String id, String username) {
        return Directory+id+username+Extension;
    }
    
    private int writeGame(Game game, String filepath) {
        int result;
        
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game);
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
