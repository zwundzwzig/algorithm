package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
  public int solution(int[] citations) {
    int answer = 0;

    Integer[] boxedArray = Arrays.stream(citations)
            .boxed()
            .sorted(Collections.reverseOrder())
            .toArray(Integer[]::new);

    for (int i = 0; i < boxedArray.length; i++) {
      if (boxedArray[i] > answer) answer++;
      else return answer;
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(3, solution(new int[]{ 3, 0, 6, 1, 5 }));
    Assertions.assertEquals(0, solution(new int[]{ 0 }));
  }
}
