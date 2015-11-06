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
/**
 *
 * @author Marc Ferré Monné
 */
public class RankingDBController {
    
    private static final String Directory = "Rankings/";
    private static final String Extension = ".rank";
    
    public int createRanking(String boardName){
        int result = -2;
        return result;
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
