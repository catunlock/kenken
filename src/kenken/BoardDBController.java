/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author joan.pol.alejandre
 */
public class BoardDBController {
    
    private static final String Directory = "Boards/";
    private static final String ExtensionFisica = ".brd";
    private static final String ExtensionInfo = ".inf";
    
    /* Pre:  cert
    ** Post: Retorna un int el qual, segons el valor que tingui, indicarà que
             s’ha creat a la base de dades una nova Board, o bé hi ha hagut algun problema.
        Return:
             0 = board creada correctament
            -1 = board existent
            -2 = error intern
    */
    
    public int createBoard(Board newBoard){
        int result = 1;
        String ubicacio = getPath(newBoard);
                
                /* tamaño tablero, persona que lo ha creado, */
        
        String fisica = ubicacio+ExtensionFisica;
        String info = ubicacio+ExtensionInfo;
        
        return result;
        
    }
                        
    private String getPath(Board board){
        return getPath(board.getBoardName());
    }
    
    private String getPath(String boardName){
        return Directory+boardName;
    }
    
}
