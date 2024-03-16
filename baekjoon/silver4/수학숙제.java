package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class 수학숙제 {
  public static void 이팔칠공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int papers = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    ArrayList<BigInteger> numbers = new ArrayList<>();
    String[] lines;

    for (int i = 0; i < papers; i++) {
      lines = br.readLine().split("\\D");

      for (String line : lines) {
        if (!line.isEmpty()) numbers.add(new BigInteger(line));
      }
    }

    br.close();
    Collections.sort(numbers);

    for (BigInteger number : numbers) sb.append(number).append("\n");
    System.out.println(sb);
  }

  @Test
  public void 정답_이팔칠공() throws IOException {
    String input = "4\n" +
            "01bond\n" +
            "02james007\n" +
            "03bond\n" +
            "04austinpowers000";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이팔칠공(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("0", result[0]);
    Assertions.assertEquals("1", result[1]);
    Assertions.assertEquals("2", result[2]);
    Assertions.assertEquals("3", result[3]);
    Assertions.assertEquals("4", result[4]);
    Assertions.assertEquals("7", result[5]);
  }

}