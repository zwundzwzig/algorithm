package level_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 체육복 {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n - lost.length;

    Arrays.sort(reserve);
    Arrays.sort(lost);

    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if (lost[i] == reserve[j]) {
          answer++;
          lost[i] = reserve[j] = -1;
          break;
        }
      }
    }

    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
          answer++;
          reserve[j] = -1;
          break;
        }
      }
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(5, solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    Assertions.assertEquals(4, solution(5, new int[]{2, 4}, new int[]{3}));
    Assertions.assertEquals(3, solution(3, new int[]{1}, new int[]{1}));
  }
}
