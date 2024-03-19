package silver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열 {

  public static void 일일공오오(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    br.close();

    int[] numbers = new int[n + 1];
    int[] dp = new int[n + 1];
    int length = 0;

    for (int i = 1; i <= n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    dp[1] = numbers[1];

    for (int i = 1; i <= n; i++) {
      dp[i] = numbers[i];
      for (int j = 1; j < i; j++) {
        if (numbers[i] > numbers[j]) dp[i] = Math.max(dp[j] + numbers[i], dp[i]);
      }
    }

    Arrays.sort(dp);

    System.out.println(dp[n]);
  }

  @Test
  public void 정답() throws IOException {
    String input = "10\n" +
            "1 100 2 50 60 3 5 6 7 8";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일공오오(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("113", result[0]);
  }

}
