/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.persistance.controllers;
import kenken.domain.classes.Ranking;
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
 * @author Marc Ferré Monné
 */
public class RankingDBController {
    
    private static final String Directory = "Rankings/";
    private static final String Extension = ".rank";
    
    public int createRanking(Ranking newRanking){
        int result = 1;
        String filepath = getPath(newRanking);
        
        if (new File(filepath).isFile()){
            result = -1;
        }
        else {
            result = writeRanking(newRanking, filepath);
        }
       
        return result;
    }
    
    
    public int modifyRanking(Ranking ranking){
        int result = -2;
        
        if (exists(ranking)){
            result = writeRanking(ranking, getPath(ranking));
        }
        else result = -1;
        
	return result;
    }
    
    
    public int deleteRanking(String boardName){
        int result = -3;
        
        if(!exists(boardName)){
            result = -1;
        }else {
            try {
                Files.delete(FileSystems.getDefault().getPath(getPath(boardName)));
                result = 0;
            } catch (IOException ex) {
                Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
                result = -3;
            }
        }
        
        return result;
    }
    
    
    public Ranking getRanking(String boardName) {
        
        FileInputStream fis;
        Ranking ranking = null;
        
        if (exists(boardName)){
            try {
                fis = new FileInputStream(getPath(boardName));
                ObjectInputStream ois = new ObjectInputStream(fis);
                ranking = (Ranking) ois.readObject();
                fis.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex){
                Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ranking;
    }
    
    private String getPath(Ranking ranking) {
        return getPath(ranking.getBoardName());
    }
    
    private String getPath(String boardName) {
        return Directory+boardName+Extension;
    }
    
    private boolean exists(Ranking ranking) {
        return exists(ranking.getBoardName());
    }
    
    private boolean exists(String boardName) {
        return (new File(getPath(boardName)).isFile());
    }
    
    public int writeRanking(Ranking ranking, String filepath){
        int result = -2;
        
        FileOutputStream fos;
        try{
            fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ranking);
            fos.close();
            result = 0;
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        }
        catch (IOException ex){
            Logger.getLogger(UserDBController.class.getName()).log(Level.SEVERE, null, ex);
            result = -2;
        }
        return result;
    }
    
}
