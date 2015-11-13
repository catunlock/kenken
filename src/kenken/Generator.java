/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

import java.util.Random;

/**
 *
 * @author 1182347
 */
public class Generator {
    Board board;
    Random rand;
    
    public Board generate(int size) {
        board = new Board(size);
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
        //makeRegions();
        
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
/*    
    

    struct Pos {
      int f;
      int c;
      Pos() : f(0), c(0) {}
      Pos(int f, int c) : f(f), c(c) {}
      void print() { cout << "{" << f << "," << c << "}"; };
      inline bool operator==(const Pos &r) { return f == r.f and c == r.c; }
    };

    // Probabilidades de
    int randRegionSize() {
      int r = rand() % 100;

      if (r < 20) {
        return 1;
      }
      if (r >= 20 and r < 60) {
        return 2;
      }
      if (r >= 60 and r < 90) {
        return 3;
      }
      if (r >= 90) {
        return 4;
      }

      throw runtime_error("Hay algun numero que falla.");
      return -2;
    }

    void shuffleVectorPos(vector<Pos> &v) {
      for (size_t i = v.size() - 1; i > 0; i--) {
        int s = rand() % (i + 1);
        Pos tmp = v[i];
        v[i] = v[s];
        v[s] = tmp;
      }
    }

    void genAllPositions(list<Pos> &s) {

      vector<Pos> v(board.size() * board.size());

      for (int f = 0; f < board.size(); f++) {
        for (int c = 0; c < board[0].size(); c++) {
          v[(f * board.size()) + c] = Pos(f, c);
        }
      }

      shuffleVectorPos(v);

      for (int i = 0; i < v.size(); ++i) {
        s.push_back(v[i]);
        v[i].print();
      }
      cout << endl << endl;
    }

    void makeRegions() {
      vector<vector<bool>> empilat(board.size(),
                                   vector<bool>(board.size(), false));

      list<Pos> allPositions;
      genAllPositions(allPositions);

      int ff[] = {0, 1, 0, -1};
      int cc[] = {1, 0, -1, 0};

      stack<Pos> s;
      s.push(allPositions.front());
      allPositions.pop_front();

      int region = 1;

      while (not allPositions.empty()) {
        int maxRegionSize = randRegionSize();
        cout << "Region de: " << maxRegionSize << endl;
        int regionSize = 0;

        while (not s.empty() and regionSize < maxRegionSize) {
          Pos p = s.top();
          s.pop();

          cout << "{" << p.f << "," << p.c << "}";
          board[p.f][p.c].region = region;
          regionSize++;

          list<Pos>::iterator it =
              find(allPositions.begin(), allPositions.end(), p);
          if (it != allPositions.end())
            allPositions.erase(it);
          else {
            std::cout << "\nElement not found in myvector: ";
            p.print();
            cout << endl;
          }

          // Dos intentos de ir en direcciones diferentes.
          for (int i = 0; i < 4; ++i) {
            int dir = rand() % 4;
            Pos pn(p.f + ff[dir], p.c + cc[dir]);

            if (pn.f >= 0 and pn.f < board.size() and pn.c >= 0 and
                pn.c < board[0].size() and not empilat[pn.f][pn.c]) {
              s.push(pn);
              empilat[pn.f][pn.c] = true;
            }
          }
        }
        region++;
      }
    }*/
    
    public static void main(String[] args) {
        Generator g = new Generator();
        Board b = g.generate(4);
        System.out.print(kenken.color.Color.FG_GREEN);
        System.out.println(b);
        System.out.print(kenken.color.Color.FG_DEFAULT);
    }
}
