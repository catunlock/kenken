/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import kenken.dominio;

/**
 *
 * @author GERARD
 */
public class GameDBController {
    public int saveGame(Game game, String user){
        //Guardar los datos del juego y el usuario en la BD
        return 0;
    }
    
    public Game loadGame(int id){
        Game game = new Game();
        //Cargar el juego desde la BD
        return game;
    }
}
