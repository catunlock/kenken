/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;

/**
 *
 * @author marc.ferre.monne
 */
public class User implements Serializable{
    
    private String username;
    private String password;
    private int solvedGames;
    private int startedGames;
    private Duration totalTimePlayed;
    private int totalCreatedBoards;
    private ArrayList<Board> createdBoards;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getSolvedGames(){
        return solvedGames;
    }
    
    public int getStartedGames(){
        return startedGames;
    }
    
    public Duration getTotalTimePlayed(){
        return totalTimePlayed;
    }
    
    public int getTotalCreatedBoards(){
        return totalCreatedBoards;
    }
    
    public ArrayList<Board> getCreatedBoards(){
        return createdBoards;
    }
    
    public Board getCreatedBoard(int pos){
        return createdBoards.get(pos);
    }
    
    public int getActualCreatedBoard(){
        return createdBoards.size();
    }
    
    public void incrementSolvedGames(){
        solvedGames++;
    }
    
    public void incrementStartedGames(){
        startedGames++;
    }
    
    public void incrementTotalTimePlayed(Duration time){
        totalTimePlayed.plus(time);
    }
    
    public void incrementTotalCreatedBoards(){
        totalCreatedBoards++;
    }
    
    public void addBoard(Board newBoard){
        createdBoards.add(newBoard);
    }
    
    public void deleteBoard(int pos){
        createdBoards.remove(pos);
    }
}
