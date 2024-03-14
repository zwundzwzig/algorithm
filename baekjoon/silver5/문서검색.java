package silver5;

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
    int answer = 0;

    while (document.contains(target)) {
      answer++;
      document = document.replaceFirst(target, " ");
    }

    System.out.println(answer);
  }

  @Test
  public void 정답_일오사삼() throws IOException {
    String input = "aabb\n" +
            "ab";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] result;

    일오사삼(new String[]{input});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("1", result[0]);
  }

}
