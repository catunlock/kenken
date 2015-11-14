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
 * @author GERARD+pol
 */
public class GameController {
    
    /*
    Pre: cert
    Post: es retorna una board per començar un nou joc
    si retorna null hi ha hagut algun error en la càrrega
    */
    public Board newGame(String boardName){
        kenken.BoardDBController bdbc = new kenken.BoardDBController();
        Board b = bdbc.loadBoard(boardName);
        return b;
    }
    
    public Board generateBoard(int size, String dificultat){
    
        Generator generador = new Generator();
        /*Board newBoard = generador.generate(size);
        newBoard.setDifficulty(dificultat);*/ 
        
        return newBoard;
    }
    
    /*
    Pre: cert
    Post: es guarda a la DB el game actual i retorna
    0 si s'ha guardat amb èxit
    -1 si ja existeix
    -2 si hi ha errors interns
    */
    public int saveGame(Game game, String username){
        GameDBController gdbc = new GameDBController();
        return gdbc.saveGame(game, game.getBoard().getBoardName(), username);
    }
    
    /*
    Pre: cert
    Post: es retorna el game el qual estava jugant l'user username i la taula id
    que s'estava jugant
    */
    public Game loadGame(String userName, String boardName){
        GameDBController gdbc = new GameDBController();
        return gdbc.loadGame(userName, boardName);
    }
    
}
