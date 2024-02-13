package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class n2승배열자르기 {
  public int[] solution(int n, long left, long right) {
    int[] answer = new int[(int) (right - left + 1)];
    int index = 0;

    for (long i = left; i <= right; i++) {
      answer[index++] = (int) Math.max(i / n, i % n) + 1;
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(new int[] { 3, 2, 2, 3 }, solution(3, 2, 5));
    Assertions.assertEquals(new int[] { 4, 3, 3, 3, 4, 4, 4, 4 }, solution(4, 7, 14));
  }
}
