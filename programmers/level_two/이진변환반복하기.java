package level_two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 이진변환반복하기 {
  public int[] solution(String s) {
    int[] answer = new int[2];

    while (!s.equals("1")) {
      String temp = s.replaceAll("0", "");
      answer[1] += s.length() - temp.length();
      s = Integer.toString(temp.length(), 2);
      answer[0]++;
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(new int[] { 3, 8 }, solution("110010101001"));
    Assertions.assertEquals(new int[] { 3, 3 }, solution("01110"));
    Assertions.assertEquals(new int[] { 4, 1 }, solution("1111111"));
  }
}
