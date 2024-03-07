import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 텀프로젝트 {
  static StringBuilder answer = new StringBuilder();
  static int[] students;
  static boolean[] visited, success;
  static int count;

  public static void 구사육육(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int n;
    StringTokenizer st;

    for (int i = 0; i < T; i++) {
      n = Integer.parseInt(br.readLine());
      students = new int[n + 1];
      visited = new boolean[n + 1];
      success = new boolean[n + 1];

      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        students[j] = Integer.parseInt(st.nextToken());
      }

      count = 0;
      for (int j = 1; j <= n; j++) {
        if (!visited[j]) {
          dfs(j);
        }
      }

      answer.append(n - count).append("\n");
    }

    br.close();
    System.out.print(answer);
  }

  static void dfs(int index) {
    visited[index] = true;
    int target = students[index];

    if (!visited[target]) dfs(target);
    else if (!success[target]) {
      count++;
      while (target != index) {
        count++;
        target = students[target];
      }
    }
    success[index] = true;
  }

  @Test
  public void 정답_구사육육() throws IOException {
    String input = "2\n" +
            "7\n" +
            "3 1 3 7 3 4 6\n" +
            "8\n" +
            "1 2 3 4 5 6 7 8";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    구사육육(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("3", result[0]);
    Assertions.assertEquals("0", result[1]);
  }
}
