package silver1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 스티커 {

  public static void 구사육오(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int columns;
    int[][] stickers;
    int[][] dp;

    for (int test = 0; test < tests; test++) {
      columns = Integer.parseInt(br.readLine());
      stickers = new int[2][columns + 1];

      for (int row = 0; row < stickers.length; row++) {
        st = new StringTokenizer(br.readLine(), " ");

        for (int column = 1; column <= columns; column++) {
          stickers[row][column] = Integer.parseInt(st.nextToken());
        }
      }

      dp = new int[2][columns + 1];
      dp[0][1] = stickers[0][1];
      dp[1][1] = stickers[1][1];

      dp = calculateMaxScore(columns, stickers, dp);
      sb.append(Math.max(dp[0][columns], dp[1][columns])).append("\n");
    }

    br.close();
    System.out.println(sb);

  }

  private static int[][] calculateMaxScore(int columns, int[][] stickers, int[][] dp) {
    for (int column = 2; column <= columns; column++) {
      dp[0][column] = Math.max(dp[1][column - 1], dp[1][column - 2]) + stickers[0][column];
      dp[1][column] = Math.max(dp[0][column - 1], dp[0][column - 2]) + stickers[1][column];
    }

    return dp;
  }

  @Test
  public void 정답_구사육오() throws IOException {
    String input = "1\n" +
            "3\n" +
            "21 69 96\n" +
            "81 50 24";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    구사육오(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("177", result[0]);
  }
}
