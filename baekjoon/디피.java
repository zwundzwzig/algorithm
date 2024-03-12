import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 디피 {
class 일사육삼 {
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

}
}