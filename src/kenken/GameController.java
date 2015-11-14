/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author GERARD
 */
public class GameController {
    
    public Board newGame(String boardName){
        kenken.BoardDBController bdbc = new kenken.BoardDBController();
        Board b = bdbc.loadBoard(boardName);
        return b;
    }
    
    public int saveGame(Game game, String username){
        GameDBController gdbc = new GameDBController();
        return gdbc.saveGame(game, username);
    }
    
    public Game loadGame(String username, String id) throws IOException {
        GameDBController gdbc = new GameDBController();
        return gdbc.loadGame(username, id);
    }
    
}
