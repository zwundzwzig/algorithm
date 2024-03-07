import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안테나 {

  private static int[] houses;
  private static int answer = Integer.MAX_VALUE;
  private static int SUM = Integer.MAX_VALUE;
  private static int N;
  private static ArrayList<String> t = new ArrayList<>();

  public static void 일팔삼일공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    houses = new int[N];

    for (int i = 0; i < N; i++) {
      houses[i] = Integer.parseInt(st.nextToken());
    }
    br.close();

    antenna(houses);

    System.out.println(answer);
  }

  private static void antenna(int[] houses) {
    if (N == 1) {
      answer = houses[0];
      return;
    }

    Arrays.sort(houses);
    int mid = N % 2 == 0 ? N / 2 - 1 : N / 2;

    for (int i = mid - 1; i <= mid + 1; i++) {
      int target = houses[i];
      int sum = 0;
      for (int j = 0; j < N; j++) {
        if (i == j) continue;

        sum += Math.abs(houses[j] - target);
      }
          t.add(target + " :: " + sum);

      if (sum < SUM) {
        answer = target;
        SUM = sum;
      }
    }
  }

  @Test
  public void 정답_일팔삼일공() throws IOException {
    String input = "4\n" +
            "5 1 7 9";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일팔삼일공(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("5", result[0]);
  }
}
