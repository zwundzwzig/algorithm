package gold3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 최소편집 {
  public static void 일오사팔삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String wordA = br.readLine();
    String wordB = br.readLine();
    br.close();

    int m = wordA.length();
    int n = wordB.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i < dp[0].length; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (wordA.charAt(i - 1) == wordB.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        }
      }
    }

    System.out.println(dp[m][n]);
  }

  @Test
  public void 정답() throws IOException {
    String input = "abc\n" +
            "ab";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일오사팔삼(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("1", result[0]);
  }
}
