package silver1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 회전초밥 {

  public static void 이오삼일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] list = new int[N + k - 1];
    for (int i = 0; i < N; i++) {
      list[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    for (int i = 0; i < k - 1; i++) {
      list[N++] = list[i];
    }

    int[] eaten = new int[d + 1];
    int max = 1;
    eaten[c] += 1;

    // 처음
    int start = 0;
    for (int i = start; i < k; i++) {
      if (eaten[list[i]] == 0) max++;
      eaten[list[i]] += 1;
    }

    // 윈도우 이동
    start = 0;
    int end = k;

    int result = max;
    for (int i = end; i < list.length; i++) {
      eaten[list[start]] -= 1;

      // 삭제된 초밥 개수는 무조건 빼는 것 X, 현재 윈도우 안에 삭제된 초밥이 있다면, 빼지 않아도 됨
      if (eaten[list[start]] == 0) result -= 1;
      if (eaten[list[i]] == 0) result += 1;

      eaten[list[i]] += 1;
      max = Math.max(max, result);
      start++;
    }

    System.out.println(max);
  }

  @Test
  public void 정답() throws IOException {
    String input = "8 30 4 30\n" +
            "7\n" +
            "9\n" +
            "7\n" +
            "30\n" +
            "2\n" +
            "7\n" +
            "9\n" +
            "25";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이오삼일(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("5", result[0]);
  }

}
