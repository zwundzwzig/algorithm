package silver1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 포도주시식 {

  public static void 이일오육(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] cups = new int[n + 1];
    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      cups[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    dp[1] = cups[1];
    if (n == 1) {
      System.out.println(dp[n]);
      return;
    }

    dp[2] = dp[1] + cups[2];

    System.out.println(getMaxCups(dp, cups));
  }

  private static int getMaxCups(int[] dp, int[] cups) {
    for (int cup = 3; cup < dp.length; cup++) {
      dp[cup] = Math.max(dp[cup - 3] + cups[cup - 1], dp[cup - 2]) + cups[cup];
      dp[cup] = Math.max(dp[cup], dp[cup - 1]);
    }

    return dp[dp.length - 1];
  }

  @Test
  public void 정답() throws IOException {
    String input = "6\n" +
            "6\n" +
            "10\n" +
            "13\n" +
            "9\n" +
            "8\n" +
            "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이일오육(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("33", result[0]);
  }
}
