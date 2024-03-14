package bronze1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 이천칠년 {
  public static void 일구이사(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int month = Integer.parseInt(st.nextToken());
    int day = Integer.parseInt(st.nextToken());

    String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    br.close();

    int daysInMonth = 0;
    for (int i = 1; i < month; i++) {
      daysInMonth += months[i];
    }

    daysInMonth += day - 1;
    System.out.print(days[daysInMonth % 7]);
  }

  @Test
  public void 정답_일구이사() throws IOException {
    String input = "1 1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일구이사(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("MON", result[0]);
  }
}
