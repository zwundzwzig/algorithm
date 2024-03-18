package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐 {

  public static void 일공팔사오(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Queue<Integer> queue = new LinkedList<>();
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    String command;
    int x;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      command = st.nextToken();

      switch (command) {
        case "push":
          x = Integer.parseInt(st.nextToken());
          queue.offer(x);
          break;
        case "pop":
          x = queue.isEmpty() ? -1 : queue.poll();
          sb.append(x).append("\n");
          break;
        case "size":
          x = queue.size();
          sb.append(x).append("\n");
          break;
        case "empty":
          x = queue.isEmpty() ? 1 : 0;
          sb.append(x).append("\n");
          break;
        case "front":
          x = queue.isEmpty() ? -1 : queue.peek();
          sb.append(x).append("\n");
          break;
        case "back":
          if (queue.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            x = 0;
            for (int j = 0; j < queue.size(); j++) {
              x = queue.poll();
              queue.offer(x);
            }
            sb.append(x).append("\n");
          }
          break;
      }
    }

    br.close();
    System.out.println(sb);
  }

  @Test
  public void 정답() throws IOException {
    String input = "15\n" +
            "push 1\n" +
            "push 2\n" +
            "front\n" +
            "back\n" +
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
            "front";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공팔사오(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("1", result[0]);
    Assertions.assertEquals("2", result[1]);
    Assertions.assertEquals("2", result[2]);
    Assertions.assertEquals("0", result[3]);
    Assertions.assertEquals("1", result[4]);
    Assertions.assertEquals("2", result[5]);
    Assertions.assertEquals("-1", result[6]);
    Assertions.assertEquals("0", result[7]);
    Assertions.assertEquals("1", result[8]);
    Assertions.assertEquals("-1", result[9]);
    Assertions.assertEquals("0", result[10]);
    Assertions.assertEquals("3", result[11]);
  }

}
