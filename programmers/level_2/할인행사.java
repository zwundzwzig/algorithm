package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class 할인행사 {
  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < want.length; i++) {
      map.put(want[i], number[i]);
    }

    for (int i = 0; i < discount.length; i++) {
      String today = discount[i];

      if (map.containsKey(today)) {
        map.put(today, map.get(today) - 1);
      }

      // 10일간의 할인 상품을 모두 확인한 후, 모든 원하는 제품의 수량이 0 이하라면 회원가입 가능한 날짜로 간주
      if (i >= 9) {
        boolean isPossible = true;
        for (int num : map.values()) {
          if (num > 0) {
            isPossible = false;
            break;
          }
        }
        if (isPossible) {
          answer++;
        }

        // 현재 날짜에서 10일 전의 할인 상품을 제거
        String prevDiscount = discount[i - 9];
        if (map.containsKey(prevDiscount)) {
          map.put(prevDiscount, map.get(prevDiscount) + 1);
        }
      }
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(3, solution(new String[]{ "banana", "apple", "rice", "pork", "pot" }, new int[]{ 3, 2, 2, 2, 1 }, new String[]{ "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana" }));
    Assertions.assertEquals(0, solution(new String[]{ "apple" }, new int[]{ 10 }, new String[]{ "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana" }));
  }
}
