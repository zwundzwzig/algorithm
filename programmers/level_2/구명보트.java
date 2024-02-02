package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 구명보트 {
  public int solution(int[] people, int limit) {
    int answer = 0, left = 0, right = people.length - 1;
    Arrays.sort(people);

    while (left <= right) {
      if (people[left] + people[right] <= limit)
        left++;

      right--;
      answer++;
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(3, solution(new int[]{70, 50, 80, 50}, 100));
    Assertions.assertEquals(3, solution(new int[]{70, 80, 50}, 100));
  }
}
