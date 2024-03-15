package silver1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 쉬운계단수 {
  static Long[][] dp;
  static int N;
  final static long MOD = 1000000000;

  public static void 일공팔사사(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    dp = new Long[N + 1][10];

    for(int i = 0; i < 10; i++) {
      dp[1][i] = 1L;
    }

    long result = 0;

    for(int i = 1; i <= 9; i++) {
      result += recur(N, i);
    }

    System.out.println(result % MOD);
  }

  static long recur(int digit, int val) {
    if(digit == 1) return dp[digit][val];

    if(dp[digit][val] == null) {
      if(val == 0)
        dp[digit][val] = recur(digit - 1 ,1);
      else if(val== 9)
        dp[digit][val] = recur(digit - 1, 8);
      else
        dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
    }

    return dp[digit][val] % MOD;
  }

  @Test
  public void 정답_일공팔사사() throws IOException {
    String input = "2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공팔사사(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("17", result[0]);
  }

}
