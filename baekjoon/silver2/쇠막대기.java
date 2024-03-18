package silver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Stack;

public class 쇠막대기 {

  public static void 일공칠구구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String laser = br.readLine();
    br.close();

    int pieces = 0;
    Stack<Character> stack = new Stack<>();
    Character in = '(';

    for (int i = 0; i < laser.length(); i++) {
      char c = laser.charAt(i);

      if (c == in) stack.push(c);
      else {
        stack.pop();
        pieces += laser.charAt(i - 1) == in ? stack.size() : 1;
      }
    }

    System.out.println(pieces);
  }

  @Test
  public void 정답() throws IOException {
    String input = "(((()(()()))(())()))(()())";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공칠구구(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("24", result[0]);
  }

}
