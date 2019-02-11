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
    return sh(0, 0);
  }
  public boolean sh(int r, int c) {
    if(r >= board.length) {
      for(int q = 0; q < board.length; q++) {
        for(int w = 0; w < board[q].length; w++) {
          if(board[q][w] == -1) {
            break;
          }
          return false;
        }
      }
    }
  }
  public void deathRaysAdd(int[][] board, int r, int c) {
    //bottom right
    int qr1 = r;
    int qc1 = c;
    while(qc1 < board[r].length && qr1 < board.length) {
      board[qr1][qc1]++;
      qr1++;
      qc1++;
    }
    //bottom left
    int qr2 = r;
    int qc2 = c;
    while(qc2 >= 0 && qr2 < board.length) {
      board[qr2][qc2]++;
      qr2++;
      qc2--;
    }
    //down
    for(int qr3 = r; qr3 < board.length; qr3++) {
      board[qr3][c]++;
    }
  }
  public void deathRaysDel(int[][] board, int r, int c) {
    //bottom right
    int qr1 = r;
    int qc1 = c;
    while(qc1 < board[r].length && qr1 < board.length) {
      board[qr1][qc1]--;
      qr1++;
      qc1++;
    }
    //bottom left
    int qr2 = r;
    int qc2 = c;
    while(qc2 >= 0 && qr2 < board.length) {
      board[qr2][qc2]--;
      qr2++;
      qc2--;
    }
    //down
    for(int qr3 = r; qr3 < board.length; qr3++) {
      board[qr3][c]--;
    }
  }
  private boolean rq(int r, int c) {
    deathRaysDel(board, r, c);
    board[r][c] = 0;
    return true;
  }
  private boolean aq(int r, int c) {
    deathRaysAdd(board, r, c, 1);
    board[r][c] = -1;
    return true;
  }
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(4);
    test.solve();
  }
}
