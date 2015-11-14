package kenken;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JosÃ© Luis ExpÃ³sito Robles
 */
public class Board implements Serializable{

    private int id;
    private String difficulty;
    private int sizeX;
    private int sizeY;
    private String boardName;
    private String username;
    private Date creationDate;
    private ArrayList<ArrayList<Cell>> cells;
    private ArrayList<Region> regions;
    

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.id = 0;
    }

    public Board()
    {
        
    }

    public int getId() {
        return id;
    }

    public String getDifficulty() {
        return new String(difficulty);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public ArrayList<ArrayList<Cell>> getCells() {
        return new ArrayList<ArrayList<Cell>>(cells);
    }

    public ArrayList<Region> getRegions() {
        return new ArrayList<Region>(regions);
    }

    public String getBoardName() {
        return new String(boardName);
    }

    public String getUsername() {
        return new String(username);
    }

    public Date getCreationDate() {
        return (Date) creationDate.clone();
    }

    public Cell getCell(int x, int y) {
        return cells.get(x).get(y);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void setCells(ArrayList<ArrayList<Cell>> cells) {
        this.cells = cells;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /* FUNCION NO OFICIAL DE LA ESPECIFICACION COMPARTIDA*/
    public int size() {
        return cells.size();
    }
    
    /* FUNCION NO OFICIAL DE LA ESPECIFICACION COMPARTIDA*/
    public void setCell() {
    }

}
