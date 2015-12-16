/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.time.Duration;

/**
 *
 * @author asus
 */
public class UserControllerKenken extends UserController{
    
    /**
     * Get the users name.
     * @return A string with the name of the user.
     */
    public String getUsername() {
        if (this.getLoggedUser() == null) return "";
        else return this.getLoggedUser().getUsername();
    }
    
    /**
     * Increments the started games.
     */
    public void incrementStartedGames(){
        this.getLoggedUser().incrementStartedGames();
    }
    
    /**
     * Increments the solved games.
     */
    public void incrementSolvedGames() {
        this.getLoggedUser().incrementSolvedGames();
    }
    
    /**
     * Increments the total Created Boards.
     */
    public void incrementTotalCreatedBoards(){
        this.getLoggedUser().incrementTotalCreatedBoards();
    }
    
    /**
     * Sums loggeduser.time and time.
     * @param time The time to be operated.
     */
    public void incrementTime(Duration time){
        this.getLoggedUser().incrementTotalTimePlayed(time);
    }
            
 
}
