import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

public class 문서검색 {

  private static ArrayList<String> temp = new ArrayList<>();

  public static void 일오사삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String document = br.readLine();
    String target = br.readLine();
    br.close();
    int documentLength = document.length();
    int targetLength = target.length();
    int count = 0;

    for (int i = 0; i <= documentLength - targetLength; i++) {
      boolean found = true;
      for (int j = 0; j < targetLength; j++) {
        if (document.charAt(i + j) != target.charAt(j)) {
          found = false;
          break;
        }
      }

      if (found) {
        count++;
        i += targetLength - 1;
      }
    }

    System.out.println(count);
  }

  @Test
  public void 정답_일오사삼() throws IOException {
    String input = "a a a a a\n" +
            "a a";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] result;

    일오사삼(new String[]{input});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("2", result[0]);
  }

}
