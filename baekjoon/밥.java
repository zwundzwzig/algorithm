import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class 밥 {

  public static void 이삼오오구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int days = Integer.parseInt(st.nextToken());
    long budget = Integer.parseInt(st.nextToken());

    ArrayList<Price> menus = new ArrayList<>();
    int taste = 0;
    int five;
    int one;

    for (int i = 0; i < days; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      five = Integer.parseInt(st.nextToken());
      one = Integer.parseInt(st.nextToken());
      menus.add(new Price(five, one));
      taste += one;
      budget -= 1000;
    }

    Collections.sort(menus, (a, b) -> Math.abs(a.five - a.one) > Math.abs(b.five - b.one) ? -1 : 1);

    for (int i = 0; i < days; i++) {
      if (budget >= 4000 && menus.get(i).five - menus.get(i).one >= 0) {
        budget -= 4000;
        taste += menus.get(i).five - menus.get(i).one;
      }
    }
    
    System.out.println(taste);
  }

  static class Price {
    int five, one;

    public Price(int five, int one) {
      this.five = five;
      this.one = one;
    }
  }

  @Test
  public void 정답_이삼오오구() throws IOException {
    String input = "3 9000\n" +
            "40 10\n" +
            "20 5\n" +
            "30 20";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이삼오오구(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("65", result[0]);
  }
}
