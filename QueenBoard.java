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
  public boolean solve(int[][] board, int r, int c) {
    return true;
  }
  public void deathRays(int[][] board, int r, int c, int aor) {
    int qr1 = r;
    int qc1 = c;
    while(qc1 < board[r].length && qr1 < board.length) {
      board[qr1][qc1] = aor;
      qr1++;
      qc1++;
    }
    int qr2 = r;
    int qc2 = c;
    while(qc2 >= 0 && qr2 < board.length) {
      board[qr2][qc2] = aor;
      qr2++;
      qc2--;
    }
    for(int qc3 = c; qc3 < board[r].length; qc3++) {
      board[r][qc3] = aor;
    }
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
