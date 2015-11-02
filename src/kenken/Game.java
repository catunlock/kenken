/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author pol
 */
public class Game {
    
    enum Mode{normal,TimeAttack};
    
    private long time;
    private Mode mode;

    public Game(Mode mode)
    {
        time = System.nanoTime();
        this.mode = mode;
    }
    
    public long getTime()
    {
        return System.nanoTime() - time;
    }
    
    public Mode getMode()
    {
        return mode;
    }
}