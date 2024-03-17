package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;

public class 카드 {

  public static void 일일육오이(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashMap<Long, Integer> cards = new HashMap<>();
    long key = 0;
    int value = 0;
    long card;

    for (int i = 0; i < N; i++) {
      card = Long.parseLong(br.readLine());

      cards.put(card, cards.getOrDefault(card, 0) + 1);

      if (cards.get(card) > value) {
        key = card;
        value = cards.get(card);
      }
      else if (cards.get(card) == value)
        key = Math.min(key, card);
    }

    System.out.println(key);
  }

  @Test
  public void 정답() throws IOException {
    String input = "6\n" +
            "1\n" +
            "2\n" +
            "1\n" +
            "2\n" +
            "1\n" +
            "2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] result;

    일일육오이(new String[]{input});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("1", result[0]);
  }

}
