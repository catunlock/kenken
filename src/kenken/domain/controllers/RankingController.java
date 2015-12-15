/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.io.IOException;
import java.util.ArrayList;
import kenken.domain.classes.Game;
import kenken.domain.classes.Ranking;
import kenken.persistance.controllers.RankingDBController;
import kenken.domain.classes.Record;

/**
 *
 * @author Marc Ferré Monné
 */
public class RankingController {
    
    RankingDBController rkDBC = new RankingDBController();
    
    public RankingController(){
        
    }
    
    public int createRanking(String boardName, Game.Mode gameMode){
        Ranking newRanking = new Ranking(boardName, gameMode);
        int result = rkDBC.createRanking(newRanking);
        return result;
    }
    
    public Ranking getRanking(String boardName){
        Ranking ranking = rkDBC.getRanking(boardName);
        return ranking;
    }
    
    public ArrayList<String> showRanking(String boardName){
        Ranking ranking = rkDBC.getRanking(boardName);
        ArrayList<String> res = ranking.rankingToString();
        return res;
    }
    
    public ArrayList<String> getStringRanking(String boardName){
        return rkDBC.getRanking(boardName).rankingToString();
    }
    
    public int modifyRanking(Ranking ranking, Record record){
        ranking.addRecord(record);
        int result = rkDBC.modifyRanking(ranking);
        return result;
    }
    
    public void addRecord(String boardName, String username, Game.Mode mode, long score) {
        Record r = new Record(username,score);
        Ranking ranking = getRanking(boardName);
        if (ranking == null) {
            createRanking(boardName, mode);
            ranking = getRanking(boardName);            
        }      
        modifyRanking(ranking, r);    
    }
    
    public int deleteRanking(String boardName){
        return rkDBC.deleteRanking(boardName);
    }
    
    
}
