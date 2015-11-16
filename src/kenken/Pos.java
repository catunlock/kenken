/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author SuNLoCK
 */
public class Pos {
    public int f = 0;
    public int c = 0;
    public Pos() {}
    public Pos(int f, int c) {
        this.f = f;
        this.c = c;
    }
    
    public Pos(Pos p) {
        this.f = p.f;
        this.c = p.c;
    }

    @Override
    public String toString() {
        return "Pos{" + "f=" + f + ", c=" + c + '}';
    }
    //inline bool operator==(const Pos &r) { return f == r.f and c == r.c; }
}