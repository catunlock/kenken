/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;

/**
 *
 * @author GERARD
 */
public class GameController {
    
    public Board newGame(String id){
        BoardDBController bdbc = new BoardDBController();
        Board b = new Board();
        b = bdbc.loadBoard(id);
        return b;
    }
    
    public int saveGame(Game game, String username){
        GameDBController gdbc = new GameDBController();
        int error = gdbc.saveGame(game, username);
        return error;
    }
    
    public Game loadGame(String username, String id) throws IOException {
        GameDBController gdbc = new GameDBController();
        return gdbc.loadGame(username, id);
    }
    
}
