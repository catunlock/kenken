/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.ArrayList;

/**
 *
 * @author marc
 */
public class Ranking {
    
    enum GameMode{Normal, TimeAttack};
    
    private String boardName;
    private Record record;
    private ArrayList<Record> recordList;
    private GameMode gameMode;

    public Ranking(String boardName, GameMode gameMode) {
        this.boardName = boardName;
        this.gameMode = gameMode;
    }

    

    public String getBoardName() {
        return boardName;
    }

    public ArrayList<Record> getRecordList() {
        return recordList;
    }

    public GameMode getGameMode() {
        return gameMode;
    }
    
    public void addRecord(Record record){
        recordList.add(record);
    }
    
}
