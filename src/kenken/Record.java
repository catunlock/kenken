/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.time.Duration;

/**
 *
 * @author Marc Ferré Monné
 */
public class Record {
    
    private String namePlayer;
    private Duration time;
    
    public Record(String namePlayer, long time){
        this.namePlayer = namePlayer;
        this.time = Duration.ZERO;
        this.time = this.time.plusSeconds(time);
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public Duration getTime() {
        return time;
    }
    
    public String getTimeAsString(){
        long timeToLong = this.time.getSeconds();
        String timeToString = Long.toString(timeToLong);
        return timeToString;
    }
    
}
