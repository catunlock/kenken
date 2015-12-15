/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Marc Ferré Monné
 */
public class Ranking implements Serializable{
    
    public enum GameMode{Normal, TimeAttack};
    
    private String boardName;
    private ArrayList<Record> recordList;
    private GameMode gameMode;

    /**
     * Constuctor of Ranking with parameters boardName and gameMode.
     * @param boardName The BoardName related to the Ranking.
     * @param gameMode The GameMode related to the Ranking.
     */
    public Ranking(String boardName, GameMode gameMode) {
        this.boardName = boardName;
        this.gameMode = gameMode;
        this.recordList = new ArrayList(0);
    }

    /**
     * Getter of BoardName.
     * @return A String with the boardName.
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * Getter of RecordList.
     * @return An ArrayList of Record with all the records contained in the Ranking.
     */
    public ArrayList<Record> getRecordList() {
        return recordList;
    }
    
    /**
     * Getter of the size of RecordList.
     * @return An Integer with the number of Records contained in the Ranking.
     */
    public int getRecordListSize(){
        return this.recordList.size();
    }
    
    /**
     * Getter of Record given a Position.
     * @param pos The position of the Ranking to get the Record.
     * @return A Record selected by the parameter pos.
     */
    public Record getRecordByPos(int pos){
        return this.recordList.get(pos);
    }
    
    /**
     * Setter of Record by position.
     * @param pos The position of the Record to be replaced.
     * @param rec The new Record which will replace the old record.
     */
    public void setRecordByPos(int pos, Record rec){
        int i = this.recordList.size() - 1;
        while (pos != i){
            this.recordList.set(i, this.recordList.get(i - 1));
            i--;
        }
        this.recordList.set(pos, rec);
    }

    /**
     * Getter of GameMode.
     * @return An Enum type of GameMode.
     */
    public GameMode getGameMode() {
        return gameMode;
    }
    
    /**
     * Tries to add a new Record into the Ranking.
     * @param record The Record to add in the Ranking.
     */
    public void addRecord(Record record){
        if (this.recordList.size() == 0) this.recordList.add(record);
        else{
            int i;
            boolean added = false;
            for(i = 0; i < this.recordList.size(); i++){
                if (this.getRecordByPos(i).getTime().getSeconds() > record.getTime().getSeconds()){
                    if (this.getRecordList().size() == 10){
                        this.setRecordByPos(i, record);
                        added = true;
                        break;
                    }
                    else if (this.getRecordList().size() < 10){
                        this.addRecordAtPos(i, record);
                        added = true;
                        break;
                    }
                }
            }
            if (!added && this.recordList.size() != 10) this.recordList.add(record);
        }
    }
    
    /**
     * Tries to add a Record into a given position if the size of Ranking is lesser than 10.
     * @param pos The given position to add the Record.
     * @param record The Record to add into the Ranking.
     */
    public void addRecordAtPos(int pos, Record record){
        if (recordList.size() < 10){
            recordList.add(pos, record);
        }
    }
    
    /**
     * Converts the Ranking into an ArrayList of String.
     * @return An ArrayList of String with the Ranking info.
     */
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
    
    /**
     * Converts an ArrayList of String to a Ranking.
     * @param arr The ArrayList of String to convert into a Ranking.
     * @return The Ranking converted.
     */
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
