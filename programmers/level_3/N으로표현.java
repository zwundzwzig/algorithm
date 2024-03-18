package level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class N으로표현 {

  public int solution(int N, int number) {
    if (N == number) return 1;

    ArrayList<HashSet<Integer>> dp = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    set.add(0);
    dp.add(set);

    for (int i = 1; i < 9; i++) {
      set = new HashSet<>();
      int repeatNumber = Integer.parseInt(Integer.toString(N).repeat(i));
      set.add(repeatNumber);

      for (int j = 1; j < i; j++) {
        int k = i - j;
        for (int num1 : dp.get(j)) {
          for (int num2 : dp.get(k)) {
            set.add(num1 + num2);
            set.add(num1 - num2);
            set.add(num1 * num2);
            if (num2 != 0) set.add(num1 / num2);
          }
        }
      }

      if (set.contains(number)) return i;
      dp.add(set);
    }

    return -1;
  }

  @Test
  public void 정답1() {
    int answer = solution(5, 12);

    Assertions.assertEquals(4, answer);
  }

  @Test
  public void 정답2() {
    int answer = solution(2, 11);

    Assertions.assertEquals(3, answer);
  }

}
