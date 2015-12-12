/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.controllers;

import java.util.ArrayList;
import kenken.domain.classes.Board;
import kenken.domain.classes.Game;
import kenken.persistance.controllers.GameDBController;
import kenken.domain.algorithms.Generator;
import kenken.domain.classes.CellKenken;
import kenken.domain.classes.Region;
import kenken.domain.classes.User;
import kenken.gui.InfoCell;

/**
 *
 * @author GERARD
 */
public class GameController {
    
    GameDBController gdbc = new GameDBController();
    BoardController boardController = new BoardController();
    Game game;
    
    /*
    Pre: 3 <= size => 9, dificultat != null
    Post: retorna una board generada amb el kenken de size = size
    */
    
    private class BoardParser {
        
        private ArrayList<ArrayList<InfoCell>> infoCells;
        
        private ArrayList<ArrayList<InfoCell>> initMatrix() {
            int nColumns = game.getBoard().size();
            ArrayList<ArrayList<InfoCell>> infoCells = new ArrayList<>(nColumns);

            for (int i = 0; i < nColumns; ++i) 
            {
                infoCells.add(new ArrayList<>(nColumns));

                for (int j = 0; j < nColumns; ++j) 
                {
                    InfoCell ic = new InfoCell();       
                    infoCells.get(i).add(ic);
                }
            }
            return infoCells;
        }
        
        private void detectVerticalLimits() {
            Board board = game.getBoard();
            
            for (int f = 0; f < infoCells.size(); ++f) {
                for (int c = 1; c < infoCells.size(); ++c) {
                    CellKenken ck1 = board.getCell(f, c-1);
                    CellKenken ck2 = board.getCell(f, c);
                    int prevRegion = ck1.getRegion();
                    int currentRegion = ck2.getRegion();

                    if (prevRegion  != currentRegion) {
                        infoCells.get(f).get(c).borderVertical = true;
                    }
                }
            }
        }
        
        private void detectHoritzontalLimits() {
            Board board = game.getBoard();
            
            for (int c = 0; c < infoCells.size(); ++c) {
                for (int f = 1; f < infoCells.size(); ++f) {
                    int prevRegion = board.getCell(f-1, c).getRegion();
                    int currentRegion = board.getCell(f, c).getRegion();

                    if (prevRegion  != currentRegion) {
                        infoCells.get(f).get(c).borderHoritzontal = true;
                    }
                }
            }
        }
        
        private void detectOperations() {
            Board board = game.getBoard();
            boolean[] detectats = new boolean[board.getRegions().size()];
            
            for (int f = 0; f < infoCells.size(); ++f) {
                for (int c = 0; c < infoCells.size(); ++c) {
                    CellKenken ck = board.getCell(f, c);
                    int currentRegion = ck.getRegion() - 1;

                    if (! detectats[currentRegion]) {
                        detectats[currentRegion] = true;
                        
                        Region r = board.getRegions().get(currentRegion);
                        infoCells.get(f).get(c).operation = convertOperation(r.getOperationType());
                        infoCells.get(f).get(c).result = String.valueOf(r.getResult());

                    }
                }
            }
        }
        
        private String convertOperation(Region.OperationType op) {
            switch(op) {
                case Add:
                    return "+";
                case Subtract:
                    return "-";
                case Multiply:
                    return "*";
                case Divide:
                    return "/";
                case None:
                    return "";
                default:
                    throw new AssertionError(op.name());
                
            }
        }
        
        public ArrayList<ArrayList<InfoCell>> getInfoBoard() {

            infoCells = initMatrix();

            detectVerticalLimits();
            detectHoritzontalLimits();

            detectOperations();
                       

            return infoCells;

        }
    }
    
    public void newGame(String boardName, String mode) {
        
        Board board = boardController.loadBoard(boardName);
        game = new Game(Game.Mode.valueOf(mode), board);
        game.setBoard(board);
        
    }
    
    public ArrayList<ArrayList<InfoCell>> getInfoBoard() {
        return new BoardParser().getInfoBoard();
    }
    
    public void newGameGenerateBoard(String mode, int size, float pfRegionSize, float pfOperation, long seed) {
        Generator generador = new Generator();
               
        Board generated = generador.generate(size, pfRegionSize, pfOperation, seed);
        
        game = new Game(Game.Mode.valueOf(mode), generated);
        game.setBoard(generated);
    }
    
    /*
    public Board createBoard(int size, String boardname){
        
    }
    */
    
    /*
    Pre: cert
    Post: es guarda a la DB el game actual i retorna
    0 si s'ha guardat amb èxit
    -1 si ja existeix
    -2 si hi ha errors interns
    */
    public int saveGame(Game game, String username, String nompartida){
        return gdbc.saveGame(game, username, nompartida);
    }
    
    public int deleteSavedGame(UserController user, String game){
        String username = user.getLoggedUser().getUsername();
        return gdbc.deleteGame(username, game);
    }
    
    /*
    Pre: username != null
    Post: retorna una llista de strings amb les partides guardades del jugador
    */
    public ArrayList<String> getSavedGames(String username) {
        return gdbc.getSavedGames(username);
    }
    
    public ArrayList<String> getSavedGames(UserController uc) {
        User logged = uc.getLoggedUser();
        String name = logged.getUsername();
        return getSavedGames(name);
    }
    
    /*
    Pre: cert
    Post: es retorna el game el qual estava jugant l'user username i la taula id
    que s'estava jugant
    */
    public Game loadGame(String username, String nompartida) {
        return gdbc.loadGame(username, nompartida);
    }
    
}
