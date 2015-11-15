package kenken;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author JosÃ© Luis ExpÃ³sito Robles
 */
public class Board {

    private int id;
    private String difficulty;
    private final int sizeX;
    private final int sizeY;
    private ArrayList<ArrayList<Cell>> cells;
    private String boardName;
    private String username;
    private Date creationDate;
    
    /**
     * Pre: sizeX > 0,  sizeY > 0
     * Post: Se devuelve una instancia de board con cells vacÃ­a
     * @param sizeX tamaÃ±o del eje X
     * @param sizeY tamaÃ±o de eje Y
     */
    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.cells = new ArrayList<>();
        for (int i = 0; i < sizeX; i++) {
            cells.add(new ArrayList<>());
        }
    }
    
    /**
     * Pre: Cierto
     * Post: Se devuelve una instancia copia de board
     * @param board tablero original del que queremos hacer una copia
     */
    public Board(Board board) {
        this.sizeX = board.sizeX;
        this.sizeY = board.sizeY;
        for (int i = 0; i < sizeX; ++i) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < sizeY; ++j) {
                addCell(board.getCell(i, j));
            }
        }
    }
    
    /**
     * Pre: Cierto
     * Post: Devuelve la id del Board
     * @return id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Pre: Cierto
     * Post: Devuelve la string difficulty de Board
     * @return Difficulty del Board
     */
    public String getDifficulty() {
        return new String(difficulty);
    }
    
    /**
     * Pre: Cierto
     * Post: Devuelve el tamaÃ±o en coordenadas X del Board
     * @return tamaÃ±o de la coordenada x del Board
     */
    public int getSizeX() {
        return sizeX;
    }
    
    /**
     * Pre: Cierto
     * Post: Devuelve el tamaÃ±o en coordenadas X del Board
     * @return tamaÃ±o de la coordenada y del Board
     */
    public int getSizeY() {
        return sizeY;
    }
    
    /**
     * Pre: Cierto
     * Post: Devuelve el nombre del Board
     * @return nombre de board
     */
    public String getBoardName() {
        return new String(boardName);
    }
    
    /**
     * Pre: Cierto
     * Post: Devuelve el nombre de usuario creador del Board
     * @return nombre del creador del Board
     */
    public String getUsername() {
        return new String(username);
    }
    
    /**
     * Pre: Cierto
     * Post: Devuelve la fecha de creaciÃ³n del Board
     * @return fecha de creaciÃ³n del Board
     * @see Date
     */
    public Date getCreationDate() {
        return (Date) creationDate.clone();
    }

    /**
     * Pre: x > 0, x < tamaÃ±o de cells, y > 0, y < tamaÃ±o de cells
     * Post: devuelve la celda de la coordenada (x,y)
     * @param x coordenada de la matriz de cells
     * @param y coordenada de la matriz de cells
     * @return 
     */
    public Cell getCell(int x, int y) {
        return cells.get(x).get(y);
    }
    
    /**
     * Pre: Cierto
     * Post: Se asigna la nueva dificultad
     * @param newDifficulty dificultad que queremos asignarle al tablero
     */
    public void setDifficulty(String newDifficulty) {
        this.difficulty = newDifficulty;
    }

    /**
     * Pre: Cierto
     * Post: Se ha aÃ±adido la celda cell a la matriz cells
     * @param cell celda a aÃ±adir
     */
    public void addCell(Cell cell) {
        int x = cell.getPosX();
        int y = cell.getPosY();
        cells.get(x).set(y, new Cell(x, y ,
            cell.isOriginal(),cell.getSolutionValue()));
    }
    
    /**
     * Pre: Cierto
     * Post: Se asigna el nombre boardName al Board
     * @param boardName nombre que recibirÃ¡ el Board
     */
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
    
    /**
     * Pre: Cierto
     * Post: Se asigna el nombre username al creador del Board
     * @param username nombre del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Pre: Cierto
     * Post: Se asigna la fecha de creaciÃ³n al Board
     * @param creationDate fecha de creaciÃ³n
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    /**
     * Pre: Es una id vÃ¡lida que no existe en el sistema
     * Post: Se asigna la id newId al Board
     * @param newId id que se quiere asignar al Board
     */
    public void setId(int newId){
        this.id = newId;
    }
    
    /**
     * Pre: Cierto
     * Post: Se devuelve una matriz de Cell
     * @return ArayList<ArrayList<Cell>> cells matriz de Cell
     * @see ArrayList
     */
    public ArrayList<ArrayList<Cell>> getCells(){
        return this.cells;
    }
}
