/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author Marc Ferré Monné
 */
public class RankingController {
    
    public RankingController(){
        
    }
    
    public int createRanking(String boardName, Ranking.GameMode gameMode){
        Ranking newRanking = new Ranking(boardName, gameMode);
        return 0;
    }
    
    public Ranking getRanking(){
        return null;
    }
    
    public int modifyRanking(Ranking ranking, Record record){
        return 0;
    }
    
    
}
