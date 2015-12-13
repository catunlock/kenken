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
public class User implements Serializable{

    private String username;
    private String password;
    private int solvedGames;
    private int startedGames;
    private Duration totalTimePlayed;
    private int totalCreatedBoards;
    private ArrayList<Board> createdBoards;

    /**
     * Constructor of User.
     * @param   username The name of the user.
     * @param   password The password of the user.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        totalTimePlayed = Duration.ZERO;
        this.createdBoards = new ArrayList(0);
    }

    /**
     * Getter of the username from User.
     * @return A String with the username.
     */
    public String getUsername() {
        return username;
    }

   /**
    * Setter of the username.
    * @param username The new username of the User.
    */
    public void setUsername(String username) {
        this.username = username;
    }

   /**
    * Getter of the password.
    * @return A String with the password.
    */
    public String getPassword() {
        return password;
    }

   /**
    * Setter of the password.
    * @param password New password of the User.
    */
    public void setPassword(String password) {
        this.password = password;
    }

   /**
    * Getter of SolvedGames.
    * @return An Integer with the solvedGames.
    */
    public int getSolvedGames(){
        return solvedGames;
    }

   /**
    * Getter of StartedGames.
    * @return An Integer with the startedGames.
    */
    public int getStartedGames(){
        return startedGames;
    }

   /**
    * Getter of totalTimePlayed.
    * @return An object Duration with the totalTimePlayed.
    */
    public Duration getTotalTimePlayed(){
        return totalTimePlayed;
    }

   /**
    * Getter of totalCreatedBoards.
    * @return An Integer with the totalCreatedBoards.
    */
    public int getTotalCreatedBoards(){
        return totalCreatedBoards;
    }

    /*
    Pre: Cert
    Post: Ens retorna la ArrayList<Board> que conte els Boards creats per l'usuari.
    */
   /**
    * Getter of the createdBoards.
    * @return An ArrayList of Boards with the Boards creates of this user.
    */
    public ArrayList<Board> getCreatedBoards(){
        return createdBoards;
    }

    /*
    Pre: 0 >= pos < this.createdBoards.size()
    Post: Ens retorna la Board la qual esta a la posicio pos de createdBoard
    */
   /**
    * Getter of a createdBoard relative to the position.
    * @param  pos The position of wanted Board.
    * @return     Te Board relative to its position.
    */
    public Board getCreatedBoard(int pos){
        return createdBoards.get(pos);
    }

    /*
    Pre: Cert
    Post: Ens retorna els taulers que tenim creats actualment.
    */
   /**
    * Getter of ActualCreatedBoards
    * @return An Integer with all of the boards that we have stored in our ArrayList.
    */
    public int getActualCreatedBoard(){
        return createdBoards.size();
    }

    /*
    Pre: Cert
    Post: Incrementa en 1 els jocs solucionats de l'usuari.
    */
   /**
    * Increments the SolvedGames in 1.
    */
    public void incrementSolvedGames(){
        solvedGames++;
    }

    /*
    Pre: Cert
    Post: Incrementa en 1 els jocs comencats de l'usuari.
    */
   /**
    * Increments the StartedGames in 1.
    */
    public void incrementStartedGames(){
        startedGames++;
    }

    /*
    Pre: time != null
    Post: Suma el temps actual jugat amb el parametre time.
    */
   /**
    * Increments the totalTimePlayed in relation to the parameter time.
    * @param time A Duration time to be added to totalTimePlayed of the User.
    */
    public void incrementTotalTimePlayed(Duration time){
        totalTimePlayed = totalTimePlayed.plus(time);
    }

    /*
    Pre: Cert
    Post: Incrementa en 1 els taulers creats de l'usuari.
    */
   /**
    * IncrementsTotalCreatedBoards in 1.
    */
    public void incrementTotalCreatedBoards(){
        totalCreatedBoards++;
    }

    /*
    Pre: newBoard != null
    Post: Afegeix un nou Tauler al createdBoard de l'usuari.
    */
   /**
    * Adds a Board into the ArrayList of the User.
    * @param newBoard The new Board to be added.
    */
    public void addBoard(Board newBoard){
        createdBoards.add(newBoard);
    }

    /*
    Pre: 0 >= pos < createdBoards.size()
    Post: Esborra el tauler de la posicio passada per parametre.
    */
   /**
    * Deletes a Board from the ArrayList of the User.
    * @param pos The position of the board to be deleted.
    */
    public void deleteBoard(int pos){
        createdBoards.remove(pos);
    }

    /**
     * Converts a User to String, to send the ArrayList to the UI.
     * @return An ArrayList with all the info of the User.
     */
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

    /**
     * Converts an ArrayList of String to a User.
     * @param  arr Arraylist with the info of the User.
     * @return     the User with all the information parsed.
     */
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

}
