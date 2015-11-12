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
    
    public enum GameMode{Normal, TimeAttack};
    
    private String boardName;
    private ArrayList<Record> recordList;
    private GameMode gameMode;

    public Ranking(String boardName, GameMode gameMode) {
        this.boardName = boardName;
        this.gameMode = gameMode;
        this.recordList = new ArrayList(0);
    }

    public String getBoardName() {
        return boardName;
    }

    public ArrayList<Record> getRecordList() {
        return recordList;
    }
    
    public Record getRecordByPos(int pos){
        return this.recordList.get(pos);
    }

    public GameMode getGameMode() {
        return gameMode;
    }
    
    public void addRecord(Record record){
        if (recordList.size() < 10){
            recordList.add(record);
        }
    }
    
    public ArrayList<String> rankingToString(){
        ArrayList<String> arr = new ArrayList();
        arr.add(this.boardName);
        for (Record record : recordList) {
            arr.add(record.getNamePlayer());
            arr.add(Long.toString(record.getTime().getSeconds()));
        }
        arr.add(this.gameMode.toString());
        return arr;
    }
    
    public static Ranking stringToRanking(ArrayList<String> arr){
        Ranking ranking = new Ranking(arr.get(0), GameMode.valueOf(arr.get(arr.size() - 1)));
        for(int i = 1; i < arr.size() - 1; i += 2){
            //long time = Long.parseLong(arr.get(i + 1));
            Record temp = new Record(arr.get(i), Long.parseLong(arr.get(i + 1)));
            ranking.addRecord(temp);
        }
        return ranking;
    }
    
}
