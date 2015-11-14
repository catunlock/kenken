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

    public Game(Mode mode)
    {
        this.time = Duration.ZERO;
        this.mode = mode;
        this.board = null;
        this.user = null;      
    }
    
    public void generateBoard(){
        
    }
    
    public int setBoard(String boardName){
        BoardDBController bDBc = new BoardDBController();
        //ArrayList<String> taulerS = new ArrayList<String>();
        this.board = bdbc.loadBoard(boardName);
    }
    
    public long getTime()
    {
        return System.nanoTime() - time;
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