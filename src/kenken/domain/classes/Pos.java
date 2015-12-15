/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.classes;

/**
 *
 * @author SuNLoCK
 */
public class Pos {
    public int f = 0;
    public int c = 0;
    
    /**
     * Default Constructor of Pos.
     */
    public Pos() {}
    
    /**
     * Constructor of Pos with parameters f and c.
     * @param f An Integer with the row position.
     * @param c An Integer with the column position.
     */
    public Pos(int f, int c) {
        this.f = f;
        this.c = c;
    }
    
    /**
     * A Copy Constructor of Pos.
     * @param p The p Pos to copy.
     */
    public Pos(Pos p) {
        this.f = p.f;
        this.c = p.c;
    }

    /**
     * Converts the Pos Object to a String
     * @return The String with all the Pos information.
     */
    @Override
    public String toString() {
        return "Pos{" + "f=" + f + ", c=" + c + '}';
    }
    //inline bool operator==(const Pos &r) { return f == r.f and c == r.c; }
}