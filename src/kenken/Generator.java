/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenken;

/**
 *
 * @author 1182347
 */
public class Generator {
    Board board;
    
    public Board generate(int size) {
        board = new Board(size);
        
        for(int f = 0; f < board.size(); f++) {
            for (int c = 0; c < board.size(); c++) {
                int v = ((f+c)%board.size()) + 1;
                Cell ce = board.getCell(f, c);
                ce.setValue(v);
            }
        }
        
        System.out.println(board);
        
        return board;
    }
    
    
    private void swapRow(int i, int j) {
        int tmp;
        for (int k = 0; k < board.size(); k++) {
            tmp = board.getCell(i,k).getSolutionValue();
            board[i][k].c = board[j][k].c;
            board[j][k].c = tmp;
        }
    }
 
    private void swapColumn(int i, int j) {
        int tmp;
        for (int k = 0; k < boardSize; k++) {
            tmp = board[k][i].c;
            board[k][i].c = board[k][j].c;
            board[k][j].c = tmp;
    }
  }
 
    void shuffleRows() {
      for (size_t i = board[0].size() - 1; i > 0; i--) {
        int s = rand() % (i + 1);
        swapRow(i, s);
      }
    }
 
    void shuffleColumns() {
      for (size_t i = board[0].size() - 1; i > 0; i--) {
        int s = rand() % (i + 1);
        swapColumn(i, s);
      }
    }
    
    public static void main(String[] args) {
        Generator g = new Generator();
        g.generate(4);
    }
}
