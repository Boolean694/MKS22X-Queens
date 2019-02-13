public class QueenBoard {
  private int[][] board;
  private int nq; //num queens
  public QueenBoard(int size) {
    board = new int[size][size];
    for(int q = 0; q < board.length; q++) {
      for(int w = 0; w < board[q].length; w++) {
        board[q][w] = 0;
      }
    }
    nq = 0;
  }
  public void c() { //clear
    for(int q = 0; q < board.length; q++) {
      for(int w = 0; w < board[q].length; w++) {
        board[q][w] = 0;
      }
    }
  }
  public boolean bnc() { //board not clear?
    for(int q = 0; q < board.length; q++) {
      for(int w = 0; w < board[q].length; w++) {
        if(board[q][w] != 0) {
          return true;
        }
      }
    }
    return false;
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
    if(bnc()) {
      throw new IllegalStateException("Board must be cleared before solve() is run");
    }
    return sh(0);
  }
  public int countSolutions() {
    if(bnc()) {
      throw new IllegalStateException("Board must be cleared before solve() is run");
    }
    return csh(0);
  }
  public int csh(int r) {
    int co = 0;
    if(r >= board.length) {
      return 1;
    }
    for(int q = 0; q < board[r].length; q++) {
      if(aq(r, q)) {
        co += csh(r + 1);
        rq(r, q);
      }
    }
    return co;
  }
  public boolean sh(int r) {
    if(r >= board.length) {
      return true;
    }
    for(int q = 0; q < board[r].length; q++) {
      if(aq(r,q)) {
        if(sh(r + 1)) {
          return true;
        }
        rq(r, q);
      }
    }
    return false;
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
    nq--;
    return true;
  }
  private boolean aq(int r, int c) {
    if(board[r][c] != 0) {return false;}
    deathRaysAdd(board, r, c);
    board[r][c] = -1;
    nq++;
    return true;
  }
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(15);
    /*boolean b = test.solve();
    System.out.println(b);
    System.out.println(test);*/
    int n = test.countSolutions();
    System.out.println(n);
    System.out.println(test);
  }
}
