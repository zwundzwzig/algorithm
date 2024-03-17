package silver5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표정렬하기 {

  public static void 일일육오공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Point[] points = new Point[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      points[i] = new Point(x, y);
    }

    Arrays.sort(points);

    for (Point p : points) {
      System.out.println(p.x + " " + p.y);
    }

    br.close();
  }

  static class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point other) {
      if (this.x == other.x) {
        return this.y - other.y;
      }
      return this.x - other.x;
    }
  }

  @Test
  public void 정답() throws IOException {
    String input = "5\n" +
            "3 4\n" +
            "1 1\n" +
            "1 -1\n" +
            "2 2\n" +
            "3 3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] result;

    일일육오공(new String[]{input});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("1 -1", result[0]);
    Assertions.assertEquals("1 1", result[1]);
    Assertions.assertEquals("2 2", result[2]);
    Assertions.assertEquals("3 3", result[3]);
    Assertions.assertEquals("3 4", result[4]);
  }

}
