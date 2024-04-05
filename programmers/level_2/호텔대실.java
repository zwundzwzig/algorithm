package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class 호텔대실 {
  public int solution(String[][] book_time) {
    int answer;
    int[][] bookTime = new int[book_time.length][2];
    int start;
    int end;

    for (int i = 0; i < book_time.length; i++) {
      start = Integer.parseInt(book_time[i][0].replace(":", ""));
      end = Integer.parseInt(book_time[i][1].replace(":", ""));

      end += 10;

      if (end % 100 >= 60) end += 40;

      bookTime[i][0] = start;
      bookTime[i][1] = end;
    }

    Arrays.sort(bookTime, Comparator.comparingInt(a -> a[0]));

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    for (int[] book : bookTime) {
      if (pq.isEmpty()) pq.add(book);
      else {
        int[] tmp = pq.peek();
        end = tmp[1];

        if (book[0] >= end) {
          pq.poll();
        }
        pq.add(book);
      }
    }

    answer = pq.size();
    return answer;
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
