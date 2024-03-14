package gold4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class NQueen {

  public static int N;
  public static int[] chessBoard;
  public static int answer;

  public static void 구육육삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    br.close();
    chessBoard = new int[N];
    answer = 0;

    backtracking(0);
    System.out.print(answer);
  }

  public static void backtracking(int row) {
    if (row == N) {
      answer++;
      return;
    }

    for (int col = 0; col < N; col++) {
      chessBoard[row] = col;

      if (isPossibility(row))
        backtracking(row + 1);
    }
  }

  public static boolean isPossibility(int row) {
    for (int col = 0; col < row; col++) {
      if (chessBoard[row] == chessBoard[col]
              || Math.abs(row - col) == Math.abs(chessBoard[row] - chessBoard[col]))
          return false;
    }
    return true;
  }

  @Test
  public void 정답_구육육삼() throws IOException {
    String input = "8";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    구육육삼(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("92", result[0]);
  }
}
