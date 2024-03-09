package level_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class 키패드누르기 {
  private List<Integer> left = Arrays.asList(1, 4, 7);
  private List<Integer> right = Arrays.asList(3, 6, 9);
  private Map<Integer, int[]> keypad = new HashMap<>();

  private int l = -1;
  private int r = 999;

  public String solution(int[] numbers, String hand) {
    String answer = "";
    keypad.put(0, new int[]{3, 1});
    keypad.put(-1, new int[]{3, 0});
    keypad.put(999, new int[]{3, 2});

    int i = 1;
    while (i <= 9) {
      for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
          keypad.put(i, new int[]{x, y});
          i++;
        }
      }
    }

    for (int number : numbers) {
      if (right.contains(number)) {
        answer += "R";
        r = number;
      } else if (left.contains(number)) {
        answer += "L";
        l = number;
      } else {
        String mid = chooseHand(number, hand);
        answer += mid;
        if (mid.equals("R")) r = number;
        else l = number;
      }
    }

    return answer;
  }

  private String chooseHand(int number, String hand) {
    int left = getDistance(number, l);
    int right = getDistance(number, r);

    if (left < right) return "L";
    else if (left > right) return "R";
    else return hand.equals("right") ? "R" : "L";
  }

  private int getDistance(int number, int cur) {
    return Math.abs(keypad.get(number)[0] - keypad.get(cur)[0]) + Math.abs(keypad.get(number)[1] - keypad.get(cur)[1]);
  }

  @Test
  public void 정답() {
    Assertions.assertEquals("LRLLLRLLRRL", solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
    Assertions.assertEquals("LRLLRRLLLRR", solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"));
    Assertions.assertEquals("LLRLLRLLRL", solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right"));
  }
}
