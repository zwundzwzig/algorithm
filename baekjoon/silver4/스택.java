package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {

  private static String push = "push", pop = "pop", top = "top", size = "size", empty = "empty";

  public static void 일공팔이팔(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int x;
    String command;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      command = st.nextToken();

      if (command.equals(push)) {
        x = Integer.parseInt(st.nextToken());
        stack.push(x);
      } else if (command.equals(pop)) {
        if (stack.size() <= 0) sb.append(-1).append("\n");
        else {
          x = stack.pop();
          sb.append(x).append("\n");
        }
      } else if (command.equals(top)) {
        if (stack.size() <= 0) sb.append(-1).append("\n");
        else {
          x = stack.peek();
          sb.append(x).append("\n");
        }
      } else if (command.equals(size)) {
        x = stack.size();
        sb.append(x).append("\n");
      } else {
        x = stack.empty() ? 1 : 0;
        sb.append(x).append("\n");
      }
    }
    br.close();

    System.out.println(sb);
  }

  @Test
  public void 정답() throws IOException {
    String input = "14\n" +
            "push 1\n" +
            "push 2\n" +
            "top\n" +
            "size\n" +
            "empty\n" +
            "pop\n" +
            "pop\n" +
            "pop\n" +
            "size\n" +
            "empty\n" +
            "pop\n" +
            "push 3\n" +
            "empty\n" +
            "top";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공팔이팔(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("2", result[0]);
    Assertions.assertEquals("2", result[1]);
    Assertions.assertEquals("0", result[2]);
    Assertions.assertEquals("2", result[3]);
    Assertions.assertEquals("1", result[4]);
    Assertions.assertEquals("-1", result[5]);
    Assertions.assertEquals("0", result[6]);
    Assertions.assertEquals("1", result[7]);
    Assertions.assertEquals("-1", result[8]);
    Assertions.assertEquals("0", result[9]);
    Assertions.assertEquals("3", result[10]);
  }

}
