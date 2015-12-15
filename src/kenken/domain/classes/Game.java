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
 * @author Pol
 */
public class Game implements Serializable{
    
    public enum Mode{Normal,TimeAttack};
    
    private Duration time;
    private Mode mode;
    private Board board;
    private int hints;
    

    /*
    Pre: mode = "normal" o "TimeAttack"
    Post: S'ha creat un nou Game amb duració = 0 i mode de joc = mode
    */
    /**
     * Constructor of Game with mode and board parameters.
     * @param mode The mode of the game. Can be "Normal" or "TimeAttack".
     * @param board The board related to the game.
     */
    public Game(Mode mode, Board board)
    {
        this.time = Duration.ZERO;
        this.mode = (mode);
        this.board = board;
        this.hints = 3;
    }
     
    /**
     * Converts the game to a String.
     * @return A String of the info about the game.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(time.toString());
        sb.append(mode);
        sb.append(board.getBoardName());
        sb.append('\n');
        return sb.toString();
    }
    /*
    public Game stringToGame(){
        
    }
    */
    
    /*
    Pre: cert
    Post: s'ha inicialitzat al game una board de nom "boardName" i retorna
    0 si s'ha inicialitzat amb èxit
    -1 si no s'ha carregat cap board
    */
    /**
     * Setter of board.
     * @param board this.board will be replaced by board parameter.
     */
    public void setBoard(Board board){
        this.board = board;
    }
    
    
    /*
    Pre: temps != null
    Post: this.time = this.time + time (en segons)
    */
    /**
     * Adds time to the game time.
     * @param temps The Time to be added to this.time
     */
    public void addTime(Duration temps){
        time = time.plus(temps);
    }
    
    /*
    Pre: cert
    Post: es retorna un temps (imagino que temps de joc pero no ho se)
    */
    /**
     * Getter of the Time.
     * @return An Object Duration with the amount time played.
     */
    public Duration getTime()
    {
        return time;
    }
    
    /*
    Pre: cert
    Post: es retorna el mode de joc del game
    */
    /**
     * Getter of Game Mode.
     * @return A String with the game Mode.
     */
    public String getMode()
    {
        return mode.toString();
    }
    
    /*
    Pre: cert
    Post: es retorna la board que s'està jugant al game
    */
    /**
     * Getter of the board related to the Game.
     * @return An Object board from the game.
     */
    public Board getBoard()
    {
        return board;
    }
    
    /**
     * Get a hint while playing, which subtract 1 to the hints avaliable.
     * @param p The position given to have the hint.
     * @return AN Integer with the soultionValue.
     */
    public int getHint(Pos p) {
        hints--;
        return getBoard().getCell(p.f, p.c).getSolutionValue();
    }

    /**
     * Getter of the hints avaliable.
     * @return An Integer with the hints avaliable.
     */
    public int getHints() {
        return hints;
    }
    
    /**
     * Setter of the game's time.
     * @param temps Replace this. time with temps.
     */
   public void setTime(Duration temps) {
        time = temps;
    }

   /**
    * Setter of hints avliable.
    * @param x Number of hints to have.
    */
    public void setHints(int x) {
        hints = x;
    }
    
}
