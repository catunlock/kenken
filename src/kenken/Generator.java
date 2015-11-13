/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import kenken.color.BoardColorator;

/**
 *
 * @author 1182347
 */
public class Generator {
    BoardKenken board;
    Random rand;
    
    public BoardKenken generate(int size) {
        board = new BoardKenken(size);
        rand = new Random(System.nanoTime());
        
        for(int f = 0; f < board.size(); f++) {
            for (int c = 0; c < board.size(); c++) {
                int v = ((f+c)%board.size()) + 1;
                Cell ce = board.getCell(f, c);
                ce.setSolutionValue(v);
            }
        }
        
        shuffleRows();
        shuffleColumns();
        makeRegions();
        
        return board;
    }
    
    
    private void swapRow(int i, int j) {
        for (int k = 0; k < board.size(); k++) {
            Cell c1 = board.getCell(i,k);
            Cell c2 = board.getCell(j,k);
            
            board.setCell(j, k, c1);
            board.setCell(i, k, c2);
        }
    }
 
    private void swapColumn(int i, int j) {
        for (int k = 0; k < board.size(); k++) {
            Cell c1 = board.getCell(k,i);
            Cell c2 = board.getCell(k,j);
            
            board.setCell(k, j, c1);
            board.setCell(k, i, c2);
        }
    }
 
    void shuffleRows() {
      for (int i = board.size() - 1; i > 0; i--) {
        int s = rand.nextInt(i + 1);
        swapRow(i, s);
      }
    }
 
    void shuffleColumns() {
      for (int i = board.size() - 1; i > 0; i--) {
        int s = rand.nextInt(i + 1);
        swapColumn(i, s);
      }
    }
    
    private class Pos {
        public int f = 0;
        public int c = 0;
        public Pos() {}
        public Pos(int f, int c) {
            this.f = f;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Pos{" + "f=" + f + ", c=" + c + '}';
        }
        //inline bool operator==(const Pos &r) { return f == r.f and c == r.c; }
    }
 
    int randRegionSize() {
      int r = rand.nextInt(100);

      if (r < 20) {
        return 1;
      }
      if (r >= 20 && r < 60) {
        return 2;
      }
      if (r >= 60 && r < 90) {
        return 3;
      }
      if (r >= 90) {
        return 4;
      }
      return -2;
    }
    
    void shuffleVectorPos(ArrayList<Pos> v) {
        for (int i = v.size() - 1; i > 0; i--) {
            int s = rand.nextInt(i + 1);
            Pos tmp = v.get(i);
            v.set(i, v.get(s));
            v.set(s, tmp);
        }
    }
    
    LinkedList<Pos> genAllPositions() {

        LinkedList<Pos> s = new LinkedList<Pos>();
        ArrayList<Pos> v = new ArrayList(board.size() * board.size());

        for (int f = 0; f < board.size(); f++) {
            for (int c = 0; c < board.size(); c++) {
                v.set((f * board.size()) + c, new Pos(f, c));
            }
        }

        shuffleVectorPos(v);

        for (int i = 0; i < v.size(); ++i) {
            s.add(v.get(i));

            System.out.println(v.get(i));
        }
        System.out.println();
        System.out.println();
        
        return s;
    }

    void makeRegions() {
      boolean[][] empilat = new boolean[board.size()][board.size()];
      
      for (int i = 0; i < board.size(); i++){
          for (int j = 0; j < board.size(); j++){
              empilat[i][j] = false;
          }
      }
      
      LinkedList<Pos> allPositions = genAllPositions();

      int ff[] = {0, 1, 0, -1};
      int cc[] = {1, 0, -1, 0};

      Stack<Pos> s = new Stack<Pos>();
      
      s.push(allPositions.removeFirst());
      
      int region = 1;

      while (! allPositions.isEmpty()) {
        int maxRegionSize = randRegionSize();
        System.out.println("Region de: " + maxRegionSize);

        int regionSize = 0;

        while (! s.isEmpty() && regionSize < maxRegionSize) {
            Pos p = s.firstElement();
            s.pop();

            System.out.println(p);

            Cell cell = board.getCell(p.f, p.c);
            cell.setRegion(region);
            board.setCell(p.f, p.c, cell);

            regionSize++;

            if (! allPositions.remove(p)){
                System.out.println("\nElement not found in myvector: " + p);
            }

            // "i" intentos de ir en direcciones diferentes.
            for (int i = 0; i < 4; ++i) {
                int dir = rand.nextInt(4);
                Pos pn = new Pos(p.f + ff[dir], p.c + cc[dir]);

                if (pn.f >= 0 && pn.f < board.size() && pn.c >= 0 &&
                    pn.c < board.size() && ! empilat[pn.f][pn.c]) {
                    s.push(pn);
                    empilat[pn.f][pn.c] = true;
                }
            }
        }
        region++;
      }
    }
    
    public static void main(String[] args) {
        Generator g = new Generator();
        BoardKenken b = g.generate(4);
        BoardColorator.print(b);
    }
}
