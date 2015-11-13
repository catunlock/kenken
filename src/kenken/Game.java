/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author pol+Gerard
 */
public class Game {
    
    enum Mode{normal,TimeAttack};
    
    private long time;
    private Mode mode;
    private Board board;
    private User user;

    public Game(Mode mode)
    {
        time = System.nanoTime();
        this.mode = mode;
    }
    
    public int setBoard(String id){
        BoardDBController bdbc = new BoardDBController();
        ArrayList<String> taulerS = new ArrayList<String>();
        Board tauler = new Board();
        tauler.
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