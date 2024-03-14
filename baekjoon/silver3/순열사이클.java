package silver3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

class 순열사이클 {
  private static int[] permutation;
  private static boolean[] visited;
  private static StringTokenizer st;
  private static int N;

  public static void 일공사오일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] answer = new int[Integer.parseInt(br.readLine())];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < answer.length; i++) {
      N = Integer.parseInt(br.readLine());
      permutation = new int[N + 1];
      visited = new boolean[N + 1];
      st = new StringTokenizer(br.readLine(), " ");

      for (int j = 1; j <= N; j++) {
        permutation[j] = Integer.parseInt(st.nextToken());
      }

      for (int j = 1; j <= N; j++) {
        if (!visited[j]) {
          dfs(j);
          answer[i]++;
        }
      }
      sb.append(answer[i]).append("\n");
    }
    br.close();

    System.out.print(sb);
  }

  private static void dfs(int index) {
    visited[index] = true;
    if (!visited[permutation[index]]) dfs(permutation[index]);
  }

  @Test
  public void 정답_일공사오일() throws IOException {
    String input = "2\n" +
            "8\n" +
            "3 2 7 8 1 4 5 6\n" +
            "10\n" +
            "2 1 3 4 5 6 7 9 10 8";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공사오일(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("3", result[0]);
    Assertions.assertEquals("7", result[1]);
  }
}
