/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;

/**
 *
 * @author Marc Ferré Monné
 */
public class RankingController {
    
    public RankingController(){
        
    }
    
    public int createRanking(String boardName, Ranking.GameMode gameMode){
        RankingDBController rkDBC = new RankingDBController();
        Ranking newRanking = new Ranking(boardName, gameMode);
        int result = rkDBC.createRanking(newRanking);
        return result;
    }
    
    public Ranking getRanking(String boardName){
        RankingDBController rkDBC = new RankingDBController();
        Ranking ranking = rkDBC.getRanking(boardName);
        return ranking;
    }
    
    public int modifyRanking(Ranking ranking, Record record){
        RankingDBController rkDBC = new RankingDBController();
        ranking.addRecord(record);
        int result = rkDBC.modifyRanking(ranking);
        return result;
    }
    
    public int deleteRanking(String boardName){
        RankingDBController rkDBC = new RankingDBController();
        return rkDBC.deleteRanking(boardName);
    }
    
    
}
