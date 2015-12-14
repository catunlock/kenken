/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken.domain.algorithms;

import kenken.domain.classes.CellKenken;
import kenken.domain.classes.Region;
import kenken.domain.classes.Cell;
import kenken.domain.classes.Board;
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import kenken.color.BoardColorator;
import kenken.domain.classes.Pos;

/**
 *
 * @author 1182347
 */
public class Generator {
    private Board board;
    private Random rand;
    
    /*
    Factores de probabilidad: si los factores de probabilidad valen 1 la dificultad
    es la original, digamos media. Si el factor es > 1, aumenta la dificultad.
    Si el factor es < 1 && > 0 disminuye la dificultad.
    */
      
    // Factor de probabilidad el tamaño de las regiones (que se distribuira como
    // una normal).
    private float pfRegionSize;
    
    // Factor de probabilidad que modifica si las operaciones son de multiplicar
    // o sumar i si las regiones de una sola casilla se muestra el valor al 
    // usuario o no.
    private float pfOperationType;
    
    public Board generate(int size, float pfRegionSize, float pfOperationType, long seed) {
        board = new Board(size);
        rand = new Random(seed);
        this.pfRegionSize = pfRegionSize;
        this.pfOperationType = pfOperationType;
        
        for(int f = 0; f < board.size(); f++) {
            for (int c = 0; c < board.size(); c++) {
                int v = ((f+c)%board.size()) + 1;
                CellKenken ce = board.getCell(f, c);
                ce.setSolutionValue(v);
            }
        }
        
        shuffleRows();
        shuffleColumns();
        RegionMaker rm = new RegionMaker();
        board.setRegions(rm.makeRegions());
        
        BoardColorator.printSolution(board);
        BoardColorator.printRegions(board);
        
        return board;
    }
    
    
    private void swapRow(int i, int j) {
        for (int k = 0; k < board.size(); k++) {
            CellKenken c1 = board.getCell(i,k);
            CellKenken c2 = board.getCell(j,k);
            
            int temp = c1.getSolutionValue();
            c1.setSolutionValue(c2.getSolutionValue());
            c2.setSolutionValue(temp);
        }
    }
 
    private void swapColumn(int i, int j) {
        for (int k = 0; k < board.size(); k++) {
            CellKenken c1 = board.getCell(k,i);
            CellKenken c2 = board.getCell(k,j);
            
            int temp = c1.getSolutionValue();
            c1.setSolutionValue(c2.getSolutionValue());
            c2.setSolutionValue(temp);
        }
    }
 
    private void shuffleRows() {
      for (int i = board.size() - 1; i > 0; i--) {
        int s = rand.nextInt(i + 1);
        swapRow(i, s);
      }
    }
 
    private void shuffleColumns() {
      for (int i = board.size() - 1; i > 0; i--) {
        int s = rand.nextInt(i + 1);
        swapColumn(i, s);
      }
    }

   
    class RegionMaker{
        private boolean[][] empilat;
        LinkedList<Pos> allPositions;
        
        
        public ArrayList<Region> makeRegions() {
            empilat = new boolean[board.size()][board.size()];
            allPositions = genAllPositions();
            int region = 1;
            
            ArrayList<Region> regions = new ArrayList<>();
            
            while (!allPositions.isEmpty()) {
                Pos p = allPositions.remove();
                if (board.getCell(p.f, p.c).getRegion() == 0 && ! empilat[p.f][p.c]) 
                {
                    System.out.println("Start point of region: " + p);
                    ArrayList<CellKenken> cells = makeRegion(p, region);
                    
                    Region r = constructRegion(region, cells);
                    regions.add(r);
                    
                    for (CellKenken ck : cells) {
                        ck.setRegion(region);
                    }
                    region++;
                }else {
                    System.out.println("Skipping start point: " + p);
                }
            }
            
            return regions;
        }
        
        private Region.OperationType randOperation(ArrayList<CellKenken> cells) {
            if (cells.size() == 1) {
                float n = rand.nextInt(100) * pfOperationType;
                if (n < 50) {
                    cells.get(0).setVisible(true);
                } else {
                    cells.get(0).setVisible(false);
                }
                return Region.OperationType.None;
            }
            else if (cells.size() == 2) {
                int a = cells.get(0).getSolutionValue();
                int b = cells.get(1).getSolutionValue();
                
                double r1 = Math.max((double)a,(double)b)/ Math.min((double)a,(double)b);
                int r2 = Math.max(a,b)/ Math.min(a,b);
                if (r1 == r2){
                    return Region.OperationType.Divide;
                } else {
                    return Region.OperationType.Subtract;
                }
            }
            else {
                float n = rand.nextInt(100) * pfOperationType;
                if (n < 50) {
                    return Region.OperationType.Add;
                }else {
                    return Region.OperationType.Multiply;
                }
            }
        }
        
        private Region constructRegion(int id, ArrayList<CellKenken> cells) {
            Region.OperationType op = randOperation(cells);
             
            Region result = null;
            Iterator<CellKenken> it = cells.iterator();
            
            if(it.hasNext()){
                Cell c = it.next();
                int resultValue = c.getSolutionValue();
                
                if (op == Region.OperationType.None) {
                    c.setUserValue(c.getSolutionValue());
                }
                
                while (it.hasNext()) {
                    c = it.next();
                    
                    switch(op) {
                        case Add:
                            resultValue += c.getSolutionValue();
                            break;
                        case Subtract:
                            resultValue = abs(resultValue - c.getSolutionValue());
                            break;
                        case Multiply:
                            resultValue *= c.getSolutionValue();
                            break;
                        case Divide:
                            resultValue = max(resultValue,c.getSolutionValue())/ Math.min(resultValue,c.getSolutionValue());
                            break;                    
                    }
                }
                
                result = new Region(id, cells, op, resultValue, false);
            }
            return result;
        }
                
        private void setCellRegion(Pos p, int region) {
            CellKenken c = board.getCell(p.f, p.c);
            c.setRegion(region);
            board.setCell(p.f, p.c, c);
        }
        
        
        private int randRegionSize() {

            int r = abs(rand.nextInt(board.size()-2)) +2;

            r *= pfRegionSize;
            System.out.println("Me ha dado el random: " + r);

            return (int) max(1, min(r, board.size() - 1) );
        }
        
        private ArrayList<CellKenken> makeRegion(Pos pos, int region) {
            
            int regionSize = randRegionSize();
            int actualSize = 1;
            
            ArrayList<CellKenken> cells = new ArrayList<>();

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
        
        float pfRegionSize = 1f;
        float pfOperation = 2f;
        long seed = 162;
        
        Board b = g.generate(4, pfRegionSize, pfOperation, 1);
        BoardColorator.printSolution(b);
        
        BoardColorator.printRegions(b);
    }
    
}
