package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 그리디_요격시스템 {
  public int solution(int[][] targets) {
    int answer = 0, tmpEnd = -1;
    Arrays.sort(targets, Comparator.comparingInt(o -> o[0]));


    for (int [] target : targets) {
      int start = target[0];
      int end = target[1];

      if (start >= tmpEnd) {
        answer++;
        tmpEnd = end;
      }
      else tmpEnd = Math.min(end, tmpEnd);
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(3, solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
  }
}
