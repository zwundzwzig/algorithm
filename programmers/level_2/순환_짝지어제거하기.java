package level_2;

import java.util.Stack;

public class 순환_짝지어제거하기 {
  public int solution(String s) {
    int answer = 0, count = 0;
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);

      if (stack.isEmpty()) stack.push(c);

      else {
        if (stack.peek().equals(c)) stack.pop();
        else stack.push(c);
      }
    }

    return stack.isEmpty() ? 1 : 0;
  }
}
