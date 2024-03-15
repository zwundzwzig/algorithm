package silver3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 일로만들기 {
  private Integer[] dp;

  public void 일사육삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();

    dp = new Integer[n + 1];
    dp[0] = dp[1] = 0;
    System.out.println(getMinCountForOne(n));
  }

  private int getMinCountForOne(int n) {
    if (dp[n] == null) {
      if (n % 6 == 0) {
        dp[n] = Math.min(getMinCountForOne(n - 1), Math.min(getMinCountForOne(n / 3), getMinCountForOne(n / 2))) + 1;
      }
      else if (n % 3 == 0) {
        dp[n] = Math.min(getMinCountForOne(n / 3), getMinCountForOne(n - 1)) + 1;
      }
      else if (n % 2 == 0) {
        dp[n] = Math.min(getMinCountForOne(n / 2), getMinCountForOne(n - 1)) + 1;
      }
      else {
        dp[n] = getMinCountForOne(n - 1) + 1;
      }
    }

    return dp[n];
  }

  @Test
  public void 정답_일사육삼() throws IOException {
    String input = "10";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일사육삼(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("3", result[0]);
  }

}