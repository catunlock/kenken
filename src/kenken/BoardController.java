/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.io.IOException;

/**
 *
 * @author joan.pol.alejandre
 */
public class BoardController {
    
    BoardDBController bDBc = new BoardDBController();
    
    public BoardController(){
        
    }
    
    /* Pre: board != null
       Post: retorna 0 si s'ha importat correctament, -1 si ja existeix la board, -2 error intern 
    */
    public int importBoard(Board board) {
        return bDBc.createBoard(board);    
    }
    
    /* Pre: boardName != null
       Post: retorna la board amb nom boardName, si no existeix, retorna null
    */
    public Board exportBoard(String boardName){
        return bDBc.loadBoard(boardName);
    }
    /*
       Pre: boardName != null
       Post: retorna true si el nom de taula ja existeix, false altrament
    */
    public boolean existsBoard(String boardName){
        return bDBc.exists(boardName);
    }   
    
}
