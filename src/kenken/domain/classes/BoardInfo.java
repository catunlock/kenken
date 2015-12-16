/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

import java.io.Serializable;

/**
 *
 * @author asus
 */
public class BoardInfo implements Serializable{
    private String name;
    private String creador;
    private String size;
    private String difficult;

    /**
     * Constructor of BoardInfo with the name of the board, with the creator and the size of the board.
     * @param name The name of the Board.
     * @param creador The name of the player who made it.
     * @param size The size of the board.
     * @param difficult The difficult of the board.
     */
    public BoardInfo(String name, String creador, String size, String difficult) {
        this.name = name;
        this.creador = creador;
        this.size = size;
        this.difficult = difficult;
    }

    public String getDifficult() {
        return difficult;
    }
    
    

    /**
     * Getter of the name of the Board.
     * @return A String with the Board name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the Creator's name.
     * @return A String with the creator's name.
     */
    public String getCreador() {
        return creador;
    }

    /**
     * Getter of board's size.
     * @return A String with the size of the board.
     */
    public String getSize() {
        return size;
    }
    
}
