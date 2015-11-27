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

    public BoardInfo(String name, String creador, String size) {
        this.name = name;
        this.creador = creador;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getCreador() {
        return creador;
    }

    public String getSize() {
        return size;
    }
    
}
