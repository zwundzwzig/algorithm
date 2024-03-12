import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 이육공육 {
  static boolean[][] graph;
  static boolean[] visited;
  static int answer;

  public static void 이육공육(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int computers = Integer.parseInt(br.readLine());
    int connections = Integer.parseInt(br.readLine());

    graph = new boolean[computers + 1][computers + 1];
    visited = new boolean[computers + 1];
    StringTokenizer input;

    int x, y;
    for (int i = 0; i < connections; i++) {
      input = new StringTokenizer(br.readLine(), " ");
      x = Integer.parseInt(input.nextToken());
      y = Integer.parseInt(input.nextToken());
      graph[x][y] = graph[y][x] = true;
    }
    br.close();

    dfs(1, computers);

    System.out.println(answer - 1);
  }

  public static void dfs(int index, int computers) {
    answer++;
    visited[index] = true;

    for (int i = 1; i <= computers; i++) {
      if (!visited[i] && graph[index][i]) dfs(i, computers);
    }
  }

  @Test
  public void 정답_이육공육() throws IOException {
    String input = "7\n" +
            "6\n" +
            "1 2\n" +
            "2 3\n" +
            "1 5\n" +
            "5 2\n" +
            "5 6\n" +
            "4 7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이육공육(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("4", result[0]);
  }
}
