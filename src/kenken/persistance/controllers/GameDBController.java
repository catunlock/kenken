/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.persistance.controllers;

import kenken.domain.classes.Game;
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
import java.util.ArrayList;
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
        String filepath = getPath(nompartida, username);
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
    public Game loadGame(String username, String nompartida){
        
        FileInputStream fis;
        Game game;
        String filepath = getPath(nompartida, username);
        if (new File(filepath).exists()){
            try {
            fis = new FileInputStream(getPath(nompartida, username));
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
    
    public int deleteGame(String username, String game){
        int result = -3;
        String filepath = "Users/"+username+"/"+Directory+game;
        if(new File(filepath).exists()){
            try{
                Files.delete(FileSystems.getDefault().getPath(filepath));
                result = 0;
            }
            catch(Exception e){}
        }else {
            result = -1;
        }
        
        return result;
    }
    
    /*
    Pre: cert
    Post: retorna un ArrayList amb els noms de totes les partides guardades de
    l'usuari username
    */
    public ArrayList<String> getSavedGames(String username){
        ArrayList<String> results = new ArrayList<>();
        File[] files = new File("Users/"+username+"/"+Directory).listFiles();
        if (files == null) return null;
        else {
            //If this pathname does not denote a directory, then listFiles() returns null.
            for (File file : files) {
                if (file.isFile()) {
                    results.add(file.getName());
                }
            }
            return results;
        }
    }
    
    /*
    Pre: cert
    Post: obté el path del fitxer que es vol guardar o carregar
    */
    private String getPath(String nompartida, String username) {
        return "Users/"+username+"/"+Directory+nompartida+Extension;
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
