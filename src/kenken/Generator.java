/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import static java.lang.Math.max;
import java.util.ArrayList;
import java.util.Iterator;
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
        RegionMaker rm = new RegionMaker();
        board.setRegions(rm.makeRegions());
        
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
    
    
    
    class RegionMaker{
        private boolean[][] empilat;
        LinkedList<Pos> allPositions;
        int region;
        
        public ArrayList<Region> makeRegions() {
            empilat = new boolean[board.size()][board.size()];
            allPositions = genAllPositions();
            region = 1;
            
            ArrayList<Region> regions = new ArrayList<>();
            
            while (!allPositions.isEmpty()) {
                Pos p = allPositions.remove();
                if (board.getCell(p.f, p.c).getRegion() == 0 && ! empilat[p.f][p.c]) 
                {
                    System.out.println("Start point of region: " + p);
                    ArrayList<Cell> cells = makeRegion(p);
                    
                    Region r = setOperationAndResult(cells);
                    regions.add(r);
                }else {
                    System.out.println("Skipping start point: " + p);
                }
            }
            
            return regions;
        }
        
        private Region.OperationType randOperation(ArrayList<Cell> cells) {
            if (cells.size() == 1) {
                return Region.OperationType.None;
            }
            else if (cells.size() == 2) {
                int n = rand.nextInt(100);
                if (n < 50) {
                    return Region.OperationType.Subtract;
                }else {
                    return Region.OperationType.Divide;
                }
            }
            else{
                int n = rand.nextInt(100);
                if (n < 50) {
                    return Region.OperationType.Multiply;
                }else {
                    return Region.OperationType.Add;
                }
            }
        }
        
        private Region setOperationAndResult(ArrayList<Cell> cells) {
            Region.OperationType op = randOperation(cells);
            
            Region result = null;
            Iterator<Cell> it = cells.iterator();
            
            if(it.hasNext()){
                int resultValue = it.next().getSolutionValue();
                
                while (it.hasNext()) {
                    Cell c = it.next();

                    switch(op) {
                        case Add:
                            resultValue += c.getSolutionValue();
                            break;
                        case Subtract:
                            resultValue -= c.getSolutionValue();
                            break;
                        case Multiply:
                            resultValue *= c.getSolutionValue();
                            break;
                        case Divide:
                            resultValue /= c.getSolutionValue();
                            break;                    
                    }
                }
                
                result = new Region(cells, op, resultValue, false);
            }
            return result;
        }
                
        private void setCellRegion(Pos p, int region) {
            Cell c = board.getCell(p.f, p.c);
            c.setRegion(region);
            board.setCell(p.f, p.c, c);
        }
        
        private ArrayList<Cell> makeRegion(Pos pos) {
            //int regionSize = randRegionSize();
            int regionSize = max(1,rand.nextInt(board.size() -1));
            int actualSize = 0;
            
            ArrayList<Cell> cells = new ArrayList<>();

            Stack<Pos> s = new Stack<>();
            s.push(pos);

            while(! s.isEmpty()) {
                Pos p = s.pop();
                
                setCellRegion(p, region);
                cells.add(board.getCell(p.f, p.c));
                
                System.out.print(p + ", ");

                Stack<Pos> directions = genAllDirections();
                while (! directions.isEmpty() && actualSize < regionSize) {

                    Pos dir = directions.pop();
                    Pos pn = new Pos(p.f + dir.f, p.c + dir.c);

                    if (pn.f >= 0 && pn.f < board.size() && pn.c >= 0 &&
                        pn.c < board.size() && ! empilat[pn.f][pn.c] &&
                            board.getCell(pn.f, pn.c).getRegion() == 0) 
                    {
                        s.push(pn);
                        empilat[pn.f][pn.c] = true;
                        actualSize++;
                    }
                }
            }
            region++;
            System.out.println();
            
            return cells;
        }
        
        private void shuffleVectorPos(ArrayList<Pos> v) {
            for (int i = v.size() - 1; i > 0; i--) {
                int s = rand.nextInt(i + 1);
                Pos tmp = v.get(i);
                v.set(i, v.get(s));
                v.set(s, tmp);
            }
        }
    
        private LinkedList<Pos> genAllPositions() {

            LinkedList<Pos> s = new LinkedList<Pos>();
            ArrayList<Pos> v = new ArrayList(board.size() * board.size());

            for (int f = 0; f < board.size(); f++) {
                for (int c = 0; c < board.size(); c++) {
                    v.add(new Pos(f, c));
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

        private Stack<Pos> genAllDirections() {
            ArrayList<Pos> pos = new ArrayList<>(4);

            pos.add(new Pos(0,1));
            pos.add(new Pos(1,0));
            pos.add(new Pos(0,-1));
            pos.add(new Pos(-1,0));

            shuffleVectorPos(pos);

            Stack<Pos> s = new Stack<>();

            for(int i = 0; i < pos.size(); ++i) {
                s.add(pos.get(i));
            }

            return s;
        }
    }
   
    public static void main(String[] args) {
        Generator g = new Generator();
        BoardKenken b = g.generate(4);
        BoardColorator.print(b);
        
        int i = 1;
        for (Region r : b.getRegions()) {
            System.out.println("Region " + i + ": Operation: " + r.getOperationType() + " Result: " + r.getResult());
            System.out.print("\tValues: ");
            for (Cell c : r.getCellList()) {
                System.out.print(c.getSolutionValue() + " ");
            }
            System.out.println();
            ++i;
        }
    }
}
