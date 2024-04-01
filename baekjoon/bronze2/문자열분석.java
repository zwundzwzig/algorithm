package bronze2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class 문자열분석 {

  public static void 일공팔이공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    int upper;
    int lower;
    int number;
    int space;
    StringBuilder sb = new StringBuilder();

    while ((input = br.readLine()) != null) {
      upper = 0;
      lower = 0;
      number = 0;
      space = 0;

      for (char ch : input.toCharArray()) {
        if (Character.isUpperCase(ch)) upper++;
        if (Character.isLowerCase(ch)) lower++;
        if (Character.isDigit(ch)) number++;
        if (Character.isWhitespace(ch)) space++;
      }

      sb.append(lower + " " + upper + " " + number + " " + space).append("\n");
    }

    br.close();
    System.out.println(sb);
  }

  @Test
  public void 정답() throws IOException {
    String input = "This is String\n" +
            "SPACE    1    SPACE\n" +
            " S a M p L e I n P u T     \n" +
            "0L1A2S3T4L5I6N7E8";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공팔이공(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("10 2 0 2", result[0]);
    Assertions.assertEquals("0 10 1 8", result[1]);
    Assertions.assertEquals("5 6 0 16", result[2]);
    Assertions.assertEquals("0 8 9 0", result[3]);
  }

}
