package silver3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 일이삼더하기 {
  public static void 구공구오(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int n;
    int[] dp;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      n = Integer.parseInt(br.readLine());
      dp = new int[n + 1];

      dp[1] = 1;
      if (n > 1) dp[2] = 2;
      if (n > 2) dp[3] = 4;
      if (n > 3) dp[4] = 7;

      for (int t = 5; t <= n; t++) {
        dp[t] = dp[t - 3] + dp[t - 2] + dp[t - 1];
      }

      sb.append(dp[n]).append("\n");
    }
    br.close();

    System.out.println(sb);
  }

  @Test
  public void 정답_구공구오() throws IOException {
    String input = "3\n" +
            "4\n" +
            "7\n" +
            "10";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    구공구오(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("7", result[0]);
    Assertions.assertEquals("44", result[0]);
    Assertions.assertEquals("274", result[0]);
  }
}
