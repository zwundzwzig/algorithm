package silver1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 오르막수 {

  public static void 일일공오칠(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();

    int[][] dp = new int[N + 2][10];

    for (int i = 0; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= N + 1; i++) {
      for (int j = 0; j <= 9; j++) {
        for (int k = j; k <= 9; k++) {
          dp[i][j] += dp[i - 1][k];
          dp[i][j] %= 10007;
        }
      }
    }

    System.out.println(dp[N + 1][0]);
  }

  @Test
  public void 정답_일일공오칠() throws IOException {
    String input = "3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일공오칠(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("220", result[0]);
  }

}
