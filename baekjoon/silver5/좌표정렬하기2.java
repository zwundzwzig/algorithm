package silver5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표정렬하기2 {

  public static void 일일육오일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][2];
    StringTokenizer st;

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][1] = Integer.parseInt(st.nextToken());
      arr[i][0] = Integer.parseInt(st.nextToken());
    }

    br.close();
    Arrays.sort(arr, (e1, e2) -> {
      if(e1[0] == e2[0]) return e1[1] - e2[1];
      else return e1[0] - e2[0];
    });

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
      sb.append(arr[i][1] + " " + arr[i][0]).append('\n');
    }

    System.out.println(sb);
  }

  @Test
  public void 정답() throws IOException {
    String input = "5\n" +
            "0 4\n" +
            "1 2\n" +
            "1 -1\n" +
            "2 2\n" +
            "3 3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] result;

    일일육오일(new String[]{input});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("1 -1", result[0]);
    Assertions.assertEquals("1 2", result[1]);
    Assertions.assertEquals("2 2", result[2]);
    Assertions.assertEquals("3 3", result[3]);
    Assertions.assertEquals("0 4", result[4]);
  }

}
