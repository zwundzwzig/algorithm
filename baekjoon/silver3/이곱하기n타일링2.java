package silver3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 이곱하기n타일링2 {

  public static void 일일칠이칠(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();

    int[] dp = new int[n + 1];
    dp[1] = 1;
    System.out.println(getCountForCoverTile(dp));
  }

  private static int getCountForCoverTile(int[] dp) {
    if (dp.length != 2) dp[2] = 3;

    for (int i = 3; i < dp.length; i++) {
      dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
    }

    return dp[dp.length - 1];
  }

  @Test
  public void 정답_일일칠이칠() throws IOException {
    String input = "12";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일칠이칠(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("2731", result[0]);
  }

}
