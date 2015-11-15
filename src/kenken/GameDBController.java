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
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
//import kenken.dominio;

/**
 *
 * @author GERARD
 */
public class GameDBController {
    
    private static final String Extension = ".gam";
    private static String Directory = "Games/";
    
    /*
    Pre: cert
    Post: s'ha guardat a la DB un game al que s'estava jugant una board amb nom
    boardName i la qual l'estava jugant el jugador username i retorna
    0 si s'ha guardat amb èxit
    -1 si ja existeix
    -2 si hi ha errors interns
    */
    public int saveGame(Game game, String username, String nompartida){
        int result;
        String filepath = getPath(boardName, username);
        System.out.println(filepath);
        if (new File(filepath).isFile()){
            result = -1;
        }
        else {
            result = writeGame(game, filepath);
        }
       
        return result;
    }
    
    /*
    Pre: cert
    Post: es retorna el game el qual estava jugant l'user username i la taula
    boardName que s'estava jugant
    */
    public Game loadGame(String username, String boardName){
        
        FileInputStream fis;
        Game game = null;
        String filepath = getPath(boardName, username);
        if (new File(filepath).exists()){
            try {
            fis = new FileInputStream(getPath(boardName, username));
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
            fis.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameDBController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(GameDBController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return game;
        }
        else {
            return null;
        }
    }
    
    /*
    Pre: cert
    Post: obté el path del fitxer que es vol guardar o carregar
    */
    private String getPath(String boardname, String username) {
        return Directory+username+boardname+Extension;
    }
    
    /*
    Pre: cert
    Post: es guarda a la DB el game i retorna:
    0 si s'ha fet amb èxit
    -2 si hi ha errors interns
    */
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
