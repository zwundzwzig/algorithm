package bronze1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;

public class 수정렬하기3 {

  public static void 일공구팔구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    Arrays.sort(arr);

    for (int i = 0; i < n; i++) {
      sb.append(arr[i]).append("\n");
    }

    System.out.println(sb);
  }

  @Test
  public void 정답() throws IOException {
    String input = "10\n" +
            "5\n" +
            "2\n" +
            "3\n" +
            "1\n" +
            "4\n" +
            "2\n" +
            "3\n" +
            "5\n" +
            "1\n" +
            "7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공구팔구(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("1", result[0]);
    Assertions.assertEquals("1", result[1]);
    Assertions.assertEquals("2", result[2]);
    Assertions.assertEquals("2", result[3]);
    Assertions.assertEquals("3", result[4]);
    Assertions.assertEquals("3", result[5]);
    Assertions.assertEquals("4", result[6]);
    Assertions.assertEquals("5", result[7]);
    Assertions.assertEquals("5", result[8]);
    Assertions.assertEquals("7", result[9]);
  }

}
