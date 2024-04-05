package gold4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 비밀번호만들기 {
  public static void 일칠이일팔(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String wordA = br.readLine();
    String wordB = br.readLine();
    br.close();

    int m = wordA.length(), n = wordB.length();

    int[][] dp = new int[m + 1][n + 1];

    // LCS를 구하기 위한 다이나믹 프로그래밍
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (wordA.charAt(i - 1) == wordB.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // LCS를 역추적하여 구하기
    StringBuilder password = new StringBuilder();
    int i = m, j = n;
    while (i > 0 && j > 0) {
      if (wordA.charAt(i - 1) == wordB.charAt(j - 1)) {
        password.append(wordA.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    System.out.println(password.reverse());
  }

  @Test
  public void 정답() throws IOException {
    String input = "AUTABBEHNSA\n" +
            "BCUAMEFKAJNA";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일칠이일팔(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("UAENA", result[0]);
  }
}