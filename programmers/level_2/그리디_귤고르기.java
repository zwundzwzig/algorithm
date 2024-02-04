package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 그리디_귤고르기 {
  public int solution(int k, int[] tangerine) {
    Map<Integer, Integer> map = new HashMap<>();
    int answer = 0, i = 0;

    for (int tang : tangerine) {
      map.put(tang, map.getOrDefault(tang, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
    entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    while (k > 0) {
      k -= entryList.get(i).getValue();
      i++;
      answer++;
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(3, solution(6, new int[]{ 1, 3, 2, 5, 4, 5, 2, 3 }));
    Assertions.assertEquals(2, solution(4, new int[]{ 1, 3, 2, 5, 4, 5, 2, 3 }));
    Assertions.assertEquals(1, solution(2, new int[]{ 1, 1, 1, 1, 2, 2, 2, 3 }));
  }
}
