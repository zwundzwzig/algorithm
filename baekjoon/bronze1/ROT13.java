package bronze1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ROT13 {

  public static void 일일육오오(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String output = "";

    for (char ch : br.readLine().toCharArray()) {
      if (Character.isUpperCase(ch)) output += (char) ('A' + (ch - 'A' + 13) % 26);
      else if (Character.isLowerCase(ch)) output += (char) ('a' + (ch - 'a' + 13) % 26);
      else output += ch;
    }

    br.close();
    System.out.println(output);
  }

  @Test
  public void 정답() throws IOException {
    String input = "Baekjoon Online Judge";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일육오오(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("Onrxwbba Bayvar Whqtr", result[0]);
  }

}
