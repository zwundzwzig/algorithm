package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class 호텔대실 {
  public int solution(String[][] book_time) {
    int[] timeline = new int[24 * 60];
    int start;
    int end;

    for (String[] book : book_time) {
      start = convertTimeToMinutes(book[0]);
      end = convertTimeToMinutes(book[1]);

      for (int i = start; i < end; i++) {
        timeline[i]++;
      }
    }

    return Arrays.stream(timeline).max().getAsInt();
  }

  private int convertTimeToMinutes(String time) {
    String[] split = time.split(":");
    int hour = Integer.parseInt(split[0]);
    int minute = Integer.parseInt(split[1]);
    return hour * 60 + minute;
  }

  @Test
  public void 정답() {
    int a = solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
    int b = solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}});
    int c = solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}});

    Assertions.assertEquals(3, a);
    Assertions.assertEquals(1, b);
    Assertions.assertEquals(3, c);
  }
}
