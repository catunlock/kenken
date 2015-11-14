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
    
    public Board generateBoard(int size, String userName, String boardName, String dificultat){
        
        Board newBoard = null;
        
        //comprovar antes de nada si podemos crear dicho board
        BoardController bc = new BoardController();
        if (!(bc.existsBoard(boardName))){
            
            Generator generador = new Generator();
            /* Generar una board de tamaño X, con userName, boardName, y dificultat */
            newBoard = new Board(size,size);
            newBoard.setBoardName(boardName);
            newBoard.setUsername(userName);
            newBoard.setDifficulty(dificultat);

            //AHORA SE TENDRIA QUE DAR CAÑA AL GENERADOR Y METER TODO EL ARRAYLIST DE CELLS
            
            /* Guardar el board */
            bc.importBoard(newBoard);
        }
        
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
    public Game loadGame(String username, String id) throws IOException {
        GameDBController gdbc = new GameDBController();
        return gdbc.loadGame(username, id);
    }
    
}
