package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 등차수열_숫자의표현 {
  public static int solution(int n) {
    int answer = 0, start = 1, temp, sum;

    while (start < n) {
      temp = start;
      sum = 0;

      while (sum < n) {
        sum += temp;

        if (sum == n) {
          answer++;
        } else temp++;
      }
      start++;
    }

    return ++answer; // 왜냐면 자기 자신
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(4, solution(15));
  }
}
