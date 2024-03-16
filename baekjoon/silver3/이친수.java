package silver3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 이친수 {
  public static void 이일구삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();

    if (N == 1) {
      System.out.println(N);
      return;
    }

    long[] dp = new long[N + 1];
    dp[1] = dp[2] = 1;

    for (int i = 3; i <= N; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    System.out.println(dp[N]);
  }

  @Test
  public void 정답_이일구삼() throws IOException {
    String input = "90";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이일구삼(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("2880067194370816120", result[0]);
  }
}
