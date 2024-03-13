import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 크로아티아알파벳 {
  private static String[] croatianArr = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

  public static void 이구사일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    br.close();

    for (String croatian : croatianArr) {
      if (input.contains(croatian)) {
        input = input.replace(croatian,  " ");
      }
    }

    System.out.println(input.length());
  }

  @Test
  public void 정답_이구사일() throws IOException {
    String input = "dz=ak";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] result;

    이구사일(new String[]{input});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("3", result[0]);
  }
}
