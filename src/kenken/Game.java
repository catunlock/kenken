/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.time.Duration;
import java.util.ArrayList;

/**
 *
 * @author pol+Gerard
 */
public class Game {
    
    enum Mode{normal,TimeAttack};
    
    private Duration time;
    private Mode mode;
    private Board board;
    private User user;

    public Game(String mode)
    {
        this.time = Duration.ZERO;
        this.mode = Mode.valueOf(mode);
        this.user = null;
        this.board = null;
    }
    
    public void generateBoard(){
        
    }
    
    public int setBoard(String boardName){
        GameController gc = new GameController();
        this.board = gc.newGame(boardName);
        if (this.board == null) return -1;
        else return 0;
    }
    
    public long getTime()
    {
        return System.nanoTime() - time.toNanos();
    }
    
    public Mode getMode()
    {
        return mode;
    }
    
    public Board getBoard()
    {
        return board;
    }
    
    public int saveGame(){
        GameController gc = new GameController();
        return gc.saveGame(this, user.getUsername());
    }
}