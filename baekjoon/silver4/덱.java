package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱 {

  public static void 일공팔육육(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int N = Integer.parseInt(br.readLine());

  Deque<Integer> deque = new LinkedList<>();
  StringTokenizer st;
  StringBuilder sb = new StringBuilder();
  String command;
  int x;

  for (int i = 0; i < N; i++) {
    st = new StringTokenizer(br.readLine());
    command = st.nextToken();

    switch (command) {
      case "push_front":
        x = Integer.parseInt(st.nextToken());
        deque.offerFirst(x);
        break;
      case "push_back":
        x = Integer.parseInt(st.nextToken());
        deque.offerLast(x);
        break;
      case "pop_front":
        x = deque.isEmpty() ? -1 : deque.pollFirst();
        sb.append(x).append("\n");
        break;
      case "pop_back":
        x = deque.isEmpty() ? -1 : deque.pollLast();
        sb.append(x).append("\n");
        break;
      case "size":
        x = deque.size();
        sb.append(x).append("\n");
        break;
      case "empty":
        x = deque.isEmpty() ? 1 : 0;
        sb.append(x).append("\n");
        break;
      case "front":
        x = deque.isEmpty() ? -1 : deque.peekFirst();
        sb.append(x).append("\n");
        break;
      case "back":
        x = deque.isEmpty() ? -1 : deque.peekLast();
        sb.append(x).append("\n");
        break;
    }
  }

    br.close();
    System.out.println(sb);
}

  @Test
  public void 정답() throws IOException {
    String input = "22\n" +
            "front\n" +
            "back\n" +
            "pop_front\n" +
            "pop_back\n" +
            "push_front 1\n" +
            "front\n" +
            "pop_back\n" +
            "push_back 2\n" +
            "back\n" +
            "pop_front\n" +
            "push_front 10\n" +
            "push_front 333\n" +
            "front\n" +
            "back\n" +
            "pop_back\n" +
            "pop_back\n" +
            "push_back 20\n" +
            "push_back 1234\n" +
            "front\n" +
            "back\n" +
            "pop_back\n" +
            "pop_back";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공팔육육(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("-1", result[0]);
    Assertions.assertEquals("-1", result[1]);
    Assertions.assertEquals("-1", result[2]);
    Assertions.assertEquals("-1", result[3]);
    Assertions.assertEquals("1", result[4]);
    Assertions.assertEquals("1", result[5]);
    Assertions.assertEquals("2", result[6]);
    Assertions.assertEquals("2", result[7]);
    Assertions.assertEquals("333", result[8]);
    Assertions.assertEquals("10", result[9]);
    Assertions.assertEquals("10", result[10]);
    Assertions.assertEquals("333", result[11]);
    Assertions.assertEquals("20", result[12]);
    Assertions.assertEquals("1234", result[13]);
    Assertions.assertEquals("1234", result[14]);
    Assertions.assertEquals("20", result[15]);
  }

}
