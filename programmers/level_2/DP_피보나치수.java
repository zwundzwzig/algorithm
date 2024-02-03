package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DP_피보나치수 {
  public int solution(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
    }

    return dp[n];
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(2, solution(3));
    Assertions.assertEquals(5, solution(5));
  }
}
