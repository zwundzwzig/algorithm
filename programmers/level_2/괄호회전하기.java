package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 괄호회전하기 {
  public int solution(String s) {
    int answer = 0;
    String tmp;

    for (int i = 0; i < s.length(); i++) {
      tmp = s.substring(i) + s.substring(0, i);

      if (check(tmp)) answer++;
    }

    return answer;
  }

  private boolean check(String s) {
    String out = "})]";
    String in = "{([";

    Stack<String> stack = new Stack<>();

    if (out.contains(String.valueOf(s.charAt(0)))) return false;
    if (in.contains(String.valueOf(s.charAt(s.length() - 1)))) return false;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (in.contains(String.valueOf(c)))
        stack.push(c + "");
      else if (out.contains(String.valueOf(c))) {
        if (!stack.isEmpty()) {
          String peek = stack.peek();
          if (in.indexOf(peek) == out.indexOf(c))
            stack.pop();
        }
        else return false;
      }
    }

    return stack.isEmpty() ? true : false;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(3, solution("[](){}"));
    Assertions.assertEquals(2, solution("}]()[{"));
    Assertions.assertEquals(0, solution("[)(]"));
    Assertions.assertEquals(0, solution("}}}"));
  }
}
