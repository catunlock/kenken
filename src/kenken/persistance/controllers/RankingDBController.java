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
    /**
     * Creates a new Ranking in the Database.
     * @param  newRanking Ranking to be stored in the database.
     * @return            Returns the error code  0 : Created Succesfully. -1 : The Ranking already exists. -2 : Internal error
     */
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

    /**
     * Gets a list of the Rankings in the database.
     * @return Returns an ArrayList with all the names of the Rankings.
     */
    public static ArrayList<String> getRankingBoardnames(){
        ArrayList<String> res = new ArrayList<>();
        String temp = "";
        File f = new File(Directory);
        File[] fs = f.listFiles();
        for(File f1 : fs){
            temp = f1.getName();
            temp = temp.replace(Directory, "");
            res.add(temp.replace(Extension, ""));
        }
        return res;
    }

    /**
     * Modify a selected Ranking.
     * @param  ranking The ranking to be modified.
     * @return         An Integer with error code  0 : Modified Succesfully -1 : The ranking to modify doesn't exist -2 : Internal error
     */
    public int modifyRanking(Ranking ranking){
        int result = -2;

        if (exists(ranking)){
            result = writeRanking(ranking, getPath(ranking));
        }
        else result = -1;

	return result;
    }

    /**
     * Deletes an existing ranking from the database.
     * @param  boardName The ranking to be deleted.
     * @return           An Integer with error code  0 : Deleted succesfully  -1 : The Ranking to delete doesn't exist  -2 : Internal error
     */
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

    /**
     * Gets a ranking from the database.
     * @param  boardName The name of the ranking to get.
     * @return           The ranking extracted from the database.
     */
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

    /**
     * A path getter of ranking in database.
     * @param  ranking The ranking to get the path.
     * @return  A String with the path.
     */
    private String getPath(Ranking ranking) {
        return getPath(ranking.getBoardName());
    }

    /**
     * A path getter of ranking in database.
     * @param  boardName The ranking boardname to get the path.
     * @return  A String with the path.
     */
    private String getPath(String boardName) {
        return Directory+boardName+Extension;
    }

    /**
     * A checker to see if exists the Ranking.
     * @param  ranking The ranking to check in the database.
     * @return  A boolean to see if exists the ranking.
     */
    private boolean exists(Ranking ranking) {
        return exists(ranking.getBoardName());
    }

    /**
     * A checker to see if exists the Ranking.
     * @param  boardName The ranking boardName to check in the database.
     * @return  A boolean to see if exists the ranking.
     */
    private boolean exists(String boardName) {
        return (new File(getPath(boardName)).isFile());
    }

    /**
     * Write into the database the given ranking.
     * @param   ranking The ranking to write into the database
     * @param   filepath The Filepath where the rankingFile goes.
     * @return  An Integer with error code  0 : Written succesfully -2 : Internal error
     */
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
