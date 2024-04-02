package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 요세푸스문제 {

  public static void 일일오팔(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    br.close();

    int number = Integer.parseInt(st.nextToken());
    int kill = Integer.parseInt(st.nextToken());

    LinkedList<Integer> josephus = new LinkedList<>();
    for (int i = 1; i <= number; i++) {
      josephus.add(i);
    }

    int count = 1;
    int target;
    LinkedList<Integer> answer = new LinkedList<>();

    while (!josephus.isEmpty()) {
      target = josephus.poll();
      if (count < kill) {
        josephus.add(target);
        count++;
      } else {
        answer.add(target);
        count = 1;
      }
    }

    StringBuilder sb = new StringBuilder("<");
    while (!answer.isEmpty()) {
      sb.append(answer.poll());
      if (!answer.isEmpty()) sb.append(", ");
    }
    sb.append(">");

    System.out.println(sb);
  }

  @Test
  public void 정답() throws IOException {
    String input = "7 3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일오팔(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("<3, 6, 2, 7, 5, 1, 4>", result[0]);
  }

}
