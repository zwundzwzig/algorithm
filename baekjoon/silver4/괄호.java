package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Stack;

public class 괄호 {

  public static void 구공일이(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for(int i = 0; i < T; i++) {
      sb.append(solve(br.readLine())).append('\n');
    }

    br.close();
    System.out.println(sb);
  }

  public static String solve(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(') stack.push(c);

      else if (stack.empty()) return "NO";

      else stack.pop();
    }

    if (stack.empty()) return "YES";
    else return "NO";
  }

  @Test
  public void 정답() throws IOException {
    String input = "6\n" +
            "(())())\n" +
            "(((()())()\n" +
            "(()())((()))\n" +
            "((()()(()))(((())))()\n" +
            "()()()()(()()())()\n" +
            "(()((())()(";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] result;

    구공일이(new String[]{input});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("NO", result[0]);
    Assertions.assertEquals("NO", result[1]);
    Assertions.assertEquals("YES", result[2]);
    Assertions.assertEquals("NO", result[3]);
    Assertions.assertEquals("YES", result[4]);
    Assertions.assertEquals("NO", result[5]);
  }

}
