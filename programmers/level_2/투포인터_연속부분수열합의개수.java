package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class 투포인터_연속부분수열합의개수 {

  public int solution(int[] elements) {
    HashSet<Integer> answer = new HashSet<>();

    for (int i = 0; i < elements.length; i++) {
      int sum = 0;
      for (int j = 0; j < elements.length; j++) {
        sum += elements[(i + j) % elements.length];
        answer.add(sum);
      }
    }

    return answer.size();
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(18, solution(new int[]{ 7,9,1,1,4 }));
  }
}
