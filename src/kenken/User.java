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
 * @author alberto.lopez.sanchez
 */
public class User implements Serializable{
    
    private String username;
    private String password;
    private int solvedGames;
    private int startedGames;
    private Duration totalTimePlayed;
    private int totalCreatedBoards;
    private ArrayList<Board> createdBoards;
    //TODO: Falta importar Board.
    
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
        /*
        Com que no hem importat Board, deixo la implementació d'aquesta per més
        endavant.
        */
        return null;
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
        createdBoards.add(0, newBoard);
    }
    
    public void deleteBoard(int pos){
        createdBoards.remove(pos);
        //No entenc perquè no em deixa posar el remove aqui...
    }
}
