package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 그리디_점프와순간이동 {

  public static int solution(int n) {
    int count = 0;

    while (n > 0) {
      if (n % 2 == 0) {
        // 짝수일 때는 순간이동
        n /= 2;
      } else {
        // 홀수일 때는 K 칸 앞으로 점프
        n -= 1;
        count++;
      }
    }

    return count;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(2, solution(5));
    Assertions.assertEquals(2, solution(6));
    Assertions.assertEquals(5, solution(5000));
  }
}
