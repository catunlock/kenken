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
    public Game(Mode mode, Board board)
    {
        this.time = Duration.ZERO;
        this.mode = (mode);
        this.board = board;
        this.hints = 3;
    }
     
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
    public void setBoard(Board board){
        this.board = board;
    }
    
    
    /*
    Pre: temps != null
    Post: this.time = this.time + time (en segons)
    */
    public void addTime(Duration temps){
        time = time.plus(temps);
    }
    
    /*
    Pre: cert
    Post: es retorna un temps (imagino que temps de joc pero no ho se)
    */
    public Duration getTime()
    {
        return time;
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
    
    public int getHint(Pos p) {
        hints--;
        return getBoard().getCell(p.f, p.c).getSolutionValue();
    }

    public int getHints() {
        return hints;
    }
    
    
}
