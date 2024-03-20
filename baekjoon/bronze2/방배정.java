package bronze2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 방배정 {

  public static void 일삼삼공공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int student = Integer.parseInt(st.nextToken());
    int max = Integer.parseInt(st.nextToken());

    int gender;
    int grade;

    int[] boys = new int[7];
    int[] girls = new int[7];

    for (int i = 0; i < student; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      gender = Integer.parseInt(st.nextToken());
      grade = Integer.parseInt(st.nextToken());

      if (gender == 0) girls[grade]++;
      else boys[grade]++;
    }

    br.close();

    int rooms = 0;

    for (int i = 1; i <= 6; i++) {
      rooms += Math.ceil((double) boys[i] / max);
      rooms += Math.ceil((double) girls[i] / max);
    }

    System.out.println(rooms);
  }

  @Test
  public void 정답() throws IOException {
    String input = "16 2\n" +
            "1 1\n" +
            "0 1\n" +
            "1 1\n" +
            "0 2\n" +
            "1 2\n" +
            "0 2\n" +
            "0 3\n" +
            "1 3\n" +
            "1 4\n" +
            "1 3\n" +
            "1 3\n" +
            "0 6\n" +
            "1 5\n" +
            "0 5\n" +
            "1 5\n" +
            "1 6";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일삼삼공공(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("12", result[0]);
  }

}
