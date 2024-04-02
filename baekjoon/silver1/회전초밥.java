package silver1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 회전초밥 {

  public static void 이오삼일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  }

  @Test
  public void 정답() throws IOException {
    String input = "8 30 4 30\n" +
            "7\n" +
            "9\n" +
            "7\n" +
            "30\n" +
            "2\n" +
            "7\n" +
            "9\n" +
            "25";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이오삼일(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("5", result[0]);
  }

}
