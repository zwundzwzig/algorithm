package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;

public class 접미사배열 {

  public static void 일일육오육(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    br.close();

    String[] arr = new String[input.length()];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      arr[i] = input.substring(i);
    }

    Arrays.sort(arr);
    for (String in : arr) {
      sb.append(in).append("\n");
    }

    System.out.println(sb);

  }

  @Test
  public void 정답() throws IOException {
    String input = "baekjoon";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일육오육(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("aekjoon", result[0]);
    Assertions.assertEquals("baekjoon", result[1]);
    Assertions.assertEquals("ekjoon", result[2]);
    Assertions.assertEquals("joon", result[3]);
    Assertions.assertEquals("kjoon", result[4]);
    Assertions.assertEquals("n", result[5]);
    Assertions.assertEquals("on", result[6]);
    Assertions.assertEquals("oon", result[7]);
  }

}
