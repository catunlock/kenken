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
        rand = new Random();
        
        for(int f = 0; f < board.size(); f++) {
            for (int c = 0; c < board.size(); c++) {
                int v = ((f+c)%board.size()) + 1;
                Cell ce = board.getCell(f, c);
                ce.setValue(v);
            }
        }
        
        shuffleRows();
        shuffleColumns();
        makeRegions();
        
        System.out.println(board);
        
        return board;
    }
    
    
    private void swapRow(int i, int j) {
        int tmp;
        for (int k = 0; k < board.size(); k++) {
            tmp = board.getCell(i,k).getSolutionValue();
            board.getCell(i,k).setSolutionValue(board.getCell(j,k).getSolutionValue());
            board.getCell(j,k).setSolutionValue(tmp);
        }
    }
 
    private void swapColumn(int i, int j) {
        int tmp;
        for (int k = 0; k < board.size(); k++) {
            tmp = board.getCell(k,i).getSolutionValue();
            board.getCell(k,i).setSolutionValue(board.getCell(k,j).getSolutionValue());
            board.getCell(k,j).setSolutionValue(tmp);
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
    
     Color::Code colorRegion(int region) {
    switch (region) {
    case 1:
      return Color::FG_LIGHT_GREEN;
    case 2:
      return Color::FG_LIGHT_GRAY;
    case 3:
      return Color::FG_LIGHT_CYAN;
    case 4:
      return Color::FG_LIGHT_RED;
    case 5:
      return Color::FG_LIGHT_YELLOW;
    case 6:
      return Color::FG_LIGHT_BLUE;
    case 7:
      return Color::FG_LIGHT_MAGENTA;
    }
    return Color::FG_DEFAULT;
  }
 
    void print() {
      Color::Modifier def(Color::FG_DEFAULT);

      for (auto f : board) {
        for (auto c : f) {
          Color::Modifier color(colorRegion(c.region));
          cout << color << c.c << " " << def;
        }
        cout << endl;
      }
    }

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
    }
    
    public static void main(String[] args) {
        Generator g = new Generator();
        g.generate(4);
    }
}
