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
    
    public Ranking getRanking(String boardName) throws IOException{
        RankingDBController rkDBC = new RankingDBController();
        Ranking ranking = rkDBC.getRanking(boardName);
        return ranking;
    }
    
    public int modifyRanking(Ranking ranking, Record record){
        RankingDBController rkDBC = new RankingDBController();
        for(int i = 0; i < ranking.getRecordList().size(); i++){
            if (ranking.getRecordByPos(i).getTime().getSeconds() < record.getTime().getSeconds()){
                if (ranking.getRecordList().size() == 10){
                    ranking.setRecordByPos(i, record);
                    break;
                }
                else if (ranking.getRecordList().size() < 10){
                    ranking.addRecordAtPos(i, record);
                    break;
                }
            }
        }
        int result = rkDBC.modifyRanking(ranking);
        return result;
    }
    
    
}
