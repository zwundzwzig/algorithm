package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 롤케이크자르기 {

  public int solution(int[] topping) {
    int answer = 0;
    int size = topping.length;

    HashSet<Integer> first = new HashSet<>();
    HashMap<Integer, Integer> second = new HashMap<>();

    first.add(topping[0]);
    for (int i = 1; i < size; i++) {
      second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
    }

    for (int i = 1; i < size; i++) {
      first.add(topping[i]);
      second.put(topping[i], second.get(topping[i]) - 1);

      if (second.get(topping[i]) == 0) second.remove(topping[i]);
      if (first.size() == second.size()) answer++;
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(2, solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    Assertions.assertEquals(0, solution(new int[]{1, 2, 3, 1, 4}));
  }

}
