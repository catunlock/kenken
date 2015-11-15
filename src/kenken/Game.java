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
 * @author Pol+Gerard
 */
public class Game implements Serializable{
    
    enum Mode{Normal,TimeAttack};
    
    private Duration time;
    private Mode mode;
    private Board board;
    private User user;

    /*
    Pre: mode = "normal" o "TimeAttack"
    Post: S'ha creat un nou Game amb duració = 0 i mode de joc = mode
    */
    public Game(String mode)
    {
        this.time = Duration.ZERO;
        this.mode = Mode.valueOf(mode);
        this.user = null;
        this.board = null;
    }
      
    /*
    Pre: cert
    Post: s'ha inicialitzat al game una board de nom "boardName" i retorna
    0 si s'ha inicialitzat amb èxit
    -1 si no s'ha carregat cap board
    */
    public void setBoard(Board board){
        this.board = board;
    }
    
    /*
    Pre: cert
    Post: this.user = user
    */
    public void setUser(User user){
        this.user = user;
    }
    
    /*
    Pre: time >= 0
    Post: this.time = this.time + time (en segons)
    */
    public void setTime(int time){
        this.time.plusSeconds(time);
    }
    
    /*
    Pre: cert
    Post: es retorna un temps (imagino que temps de joc pero no ho se)
    */
    public long getTime()
    {
        return System.nanoTime() - time.toNanos();
    }
    
    /*
    Pre: cert
    Post: es retorna el mode de joc del game
    */
    public String getMode()
    {
        return mode.toString();
    }
    
    /*
    Pre: cert
    Post: es retorna la board que s'està jugant al game
    */
    public Board getBoard()
    {
        return board;
    }
}
