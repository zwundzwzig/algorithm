package level_2;

class DP_멀리뛰기 {
  public long solution(int n) {
    long[] dp = new long[2001];  // n == 1이면 runtime 에러
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
    }

    return dp[n];
  }
}
