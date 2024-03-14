package gold5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 하노이탑이동순서 {
  public static StringBuilder sb = new StringBuilder();

  public static void 일일칠이구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    sb.append((1 << n) - 1).append("\n");
    hanoi(n, 1, 2, 3);
    System.out.print(sb);
  }

  private static void hanoi(int size, int from, int temp, int to) {
    if (size == 1) {
      sb.append(from + " " + to).append("\n");
      return;
    }

    hanoi(size - 1, from, to, temp);
    sb.append(from + " " + to).append("\n");
    hanoi(size - 1, temp, from, to);
  }

  @Test
  public void 정답_일일칠이구() throws IOException {
    String input = "3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일칠이구(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("7", result[0]);
    Assertions.assertEquals("1 3", result[1]);
    Assertions.assertEquals("1 2", result[2]);
    Assertions.assertEquals("3 2", result[3]);
    Assertions.assertEquals("1 3", result[4]);
    Assertions.assertEquals("2 1", result[5]);
    Assertions.assertEquals("2 3", result[6]);
    Assertions.assertEquals("1 3", result[7]);
  }
}
