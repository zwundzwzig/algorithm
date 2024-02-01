package level_two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 올바른괄호 {

  boolean solution(String s) {
    Stack<String> stack = new Stack<>();

    if (s.charAt(0) == ')') return false;
    if (s.charAt(s.length() - 1) == '(') return false;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(')
        stack.push("(");
      else if (s.charAt(i) == ')') {
        if (!stack.isEmpty()) stack.pop();
        else return false;
      }
    }

    return stack.isEmpty() ? true : false;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(true, solution("()()"));
    Assertions.assertEquals(true, solution("(())()"));
    Assertions.assertEquals(false, solution(")()("));
    Assertions.assertEquals(false, solution("(()("));
  }
}
