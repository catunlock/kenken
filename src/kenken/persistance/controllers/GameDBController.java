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
 * @author Gerard Otero Martín
 */
public class GameDBController {
    
    private static final String Extension = ".gam";
    private static String Directory = "Games/";
    
    
    /**
     * Saves a started Game into the database.
     * @param game The game to be stored.
     * @param username The username relationed to the game.
     * @param nompartida The name of the Game to be identified.
     * @return An Integer with the error code  0 : Saved succesfully. -1 : The game already exists. -2 : Internal error.
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
    
    
    /**
     * Loads an existing game from the database.
     * @param username The username of the relationed game.
     * @param nompartida The name of the Game wanted to load.
     * @return A Game Object, if it's NULL, the game couldn't be loaded.
     */
    public Game loadGame(String username, String nompartida){
        
        FileInputStream fis;
        Game game;
        String filepath = "Users/"+username+"/"+Directory+nompartida;
        if (new File(filepath).exists()){
            try {
            fis = new FileInputStream(filepath);
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
    
    
    /**
     * Deletes a Game from the database.
     * @param username The username of the game wanted to delete.
     * @param game The game wanted to delete.
     * @return An Integer with the error code  0 : Deleted succesfully. -1 : The game doesn't exist. -3 : Internal error.
     */
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
    
   
    /**
     * Getter for all the name's Games.
     * @param username The name of the User to select the games.
     * @return An ArrayList of String with all of the games from the user.
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
    
    
    /**
     * Getter of the path where the game is.
     * @param nompartida The name of the game.
     * @param username The name of the User.
     * @return A String with the pathfile.
     */
    private String getPath(String nompartida, String username) {
        return "Users/"+username+"/"+Directory+nompartida+Extension;
    }
    
    
    /**
     * Writes the Game desired into the database.
     * @param game The Game to write into the database.
     * @param filepath The path where the file will go.
     * @return An Integer with the error code  0 : Written succesfully. -2 : Internal error.
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
