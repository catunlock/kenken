/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import kenken.persistencia;

/**
 *
 * @author GERARD
 */
public class GameController {
    
    Game g;
    String user;
    
    public Board newGame(String id){
        BoardDBController bdbc = new BoardDBController();
        Board b = new Board();
        b = bdbc.loadBoard(id);
        return b;
    }
    
    public int saveGame(Game game){
        GameDBController gdbc = new GameDBController();
        int error = gdbc.saveGame(game, user);
        //llevar a la bd de partidas guardadas el juego
        return error;
    }
    
    public int loadGame(){
        //traer de la BD de partidas guardadas el Game
        return 0;
    }
    
}
