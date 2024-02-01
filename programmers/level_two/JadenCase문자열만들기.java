package level_two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JadenCase문자열만들기 {
  public String solution(String s) {
    String answer = new String();

    for (String c : s.toLowerCase().split(" ")) {
      if (c.equals("")) answer += " ";

      else {
        String[] targetString = c.split("", 2);
        answer += targetString[0].toUpperCase();
        answer += targetString[1];
        answer += " ";
      }
    }

    return s.substring(s.length() -1, s.length()).equals(" ")
            ? answer
            : answer.substring(0, answer.length() - 1);
  }

  @Test
  public void 정답() {
    Assertions.assertEquals("3people Unfollowed Me", solution("3people unFollowed me"));
    Assertions.assertEquals("For The Last Week", solution("for the last week"));
    Assertions.assertEquals("For", solution("for"));
    Assertions.assertEquals("Hello  World", solution("hello  World"));
  }

}
