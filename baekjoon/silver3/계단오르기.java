package silver3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 계단오르기 {
  public static void 이오칠구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] stairs = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    int[] dp = new int[n + 1];
    dp[1] = stairs[1];
    if (n == 1) {
      System.out.println(stairs[1]);
      return;
    }

    dp[2] = Math.max(stairs[1] + stairs[2], stairs[2]);
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
    }

    System.out.println(dp[n]);
  }

  @Test
  public void 정답() throws IOException {
    String input = "6\n" +
            "10\n" +
            "20\n" +
            "15\n" +
            "25\n" +
            "10\n" +
            "20";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이오칠구(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("75", result[0]);
  }

}
