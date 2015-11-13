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
        totalTimePlayed = Duration.ZERO;
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
        totalTimePlayed = totalTimePlayed.plus(time);
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
    /*
    public ArrayList<String> userToString(){
        ArrayList<String> arr = new ArrayList();
        arr.add(this.username);
        arr.add(this.password);
        arr.add(Integer.toString(this.solvedGames));
        arr.add(Integer.toString(this.startedGames));
        arr.add(Long.toString(this.totalTimePlayed.getSeconds()));
        arr.add(Integer.toString(this.totalCreatedBoards));
        for (Board b : this.createdBoards){
            arr.add(b.toString());
        }
        return arr;
    }
    
    public static User stringToUser(ArrayList<String> arr){
        User user = new User(arr.get(0), arr.get(1));
        user.solvedGames = Integer.parseInt(arr.get(2));
        user.startedGames = Integer.parseInt(arr.get(3));
        Duration time = Duration.ZERO;
        user.totalTimePlayed = time.plusSeconds(Long.parseLong(arr.get(4)));
        for(int i = 5; i < arr.size(); i++){
            user.addBoard(Board.toBoard(arr.get(i)));
        }
        return user;
    }
    */
}
