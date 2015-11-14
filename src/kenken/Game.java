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
 * @author Gerard
 */
public class Game {
    
    enum Mode{normal,TimeAttack};
    
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
    
    public void generateBoard(int size, String userName, String boardName, String dificultat){
        
        /* Generar una board de tamaño X, con userName, boardName, y dificultat */
        
        //comprovar antes de nada si podemos crear dicho board
        BoardController bc = new BoardController();
        bc.existsBoard(boardName);
        
        //si no existe el boardName, proceder a crearla
        board.setBoardName(boardName);
        
    }
    
    /*
    Pre: cert
    Post: s'ha inicialitzat al game una board de nom "boardName" i retorna
    0 si s'ha inicialitzat amb èxit
    -1 si no s'ha carregat cap board
    */
    public int setBoard(String boardName){
        GameController gc = new GameController();
        this.board = gc.newGame(boardName);
        if (this.board == null) return -1;
        else return 0;
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
    
    /*
    Pre: cert
    Post: es guarda a la DB el game actual i retorna
    0 si s'ha guardat amb èxit
    -1 si ja existeix
    -2 si hi ha errors interns
    */
    public int saveGame(){
        GameController gc = new GameController();
        return gc.saveGame(this, user.getUsername());
    }
}
