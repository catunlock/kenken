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
        if (this.getLoggedUser() != null) this.getLoggedUser().incrementStartedGames();
    }
    
    /**
     * Increments the solved games.
     */
    public void incrementSolvedGames() {
        if (this.getLoggedUser() != null) this.getLoggedUser().incrementSolvedGames();
    }
    
    /**
     * Increments the total Created Boards.
     */
    public void incrementTotalCreatedBoards(){
        if (this.getLoggedUser() != null) this.getLoggedUser().incrementTotalCreatedBoards();
    }
    
    /**
     * Sums loggeduser.time and time.
     * @param time The time to be operated.
     */
    public void incrementTime(Duration time){
        if (this.getLoggedUser() != null) this.getLoggedUser().incrementTotalTimePlayed(time);
    }
            
 
}
