package silver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

  public static void 일일공오삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    br.close();

    int[] numbers = new int[n + 1];
    int[] dp = new int[n + 1];
    int length = 0;

    for (int i = 1; i <= n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
      int index = binarySearch(dp, 1, length, numbers[i]);
      dp[index] = numbers[i];

      length = Math.max(index, length);
    }

    System.out.println(length);
  }

  private static int binarySearch(int[] dp, int start, int end, int target) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (dp[mid] < target) start = mid + 1;
      else end = mid - 1;
    }
    return start;
  }

  @Test
  public void 정답() throws IOException {
    String input = "4\n" +
            "1 2 1 2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일공오삼(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("2", result[0]);
  }

}
