public class QueenBoard {
  private int[][] board;
  private int nq;
  public QueenBoard(int size) {
    board = new int[size][size];
    nq = 0;
  }
  public String toString() {
    String s = "";
    for(int q = 0; q < board.length; q++) {
      for(int w = 0; w < board[q].length; w++) {
        if(board[q][w] == -1) {s += "Q";}
        else {s += "_";}
      }
      s += "\n";
    }
    return s;
  }
  public boolean solve() {
    
  }
  private boolean rq(int r, int c) {
    board[r][c] = 0;
    return true;
  }
  private boolean aq(int r, int c) {
    board[r][c] = -1;
    return true;
  }
}
