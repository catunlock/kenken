/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;

/**
 *
 * @author Marc Ferré Monné
 */
public class Record implements Serializable{
    
    private String namePlayer;
    private Duration time;
    
    /**
     * Constructor of Record with nameplayer and time parameters.
     * @param namePlayer The name of the player who did the record.
     * @param time The amount of time lasted the player to complete the board.
     */
    public Record(String namePlayer, long time){
        this.namePlayer = namePlayer;
        this.time = Duration.ZERO;
        this.time = this.time.plusSeconds(time);
    }

    /**
     * Getter of namePlayer
     * @return A String with the name of the player.
     */
    public String getNamePlayer() {
        return namePlayer;
    }

    /**
     * Getter of Time.
     * @return An Object with the amount of time lasted the player to complete the board.
     */
    public Duration getTime() {
        return time;
    }
    
    /*
    public ArrayList<String> recordToString(){
        ArrayList<String> result = new ArrayList();
        result.add(this.namePlayer);
        long timeToLong = this.time.getSeconds();
        result.add(Long.toString(timeToLong));
        return result;
    }
    
    public static Record stringToRecord(ArrayList<String> arr){
        long time = Long.parseLong(arr.get(1));
        Record rec = new Record(arr.get(0), time);
        return rec;
    }
    */
    
}
