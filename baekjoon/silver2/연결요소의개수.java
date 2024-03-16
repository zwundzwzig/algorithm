package silver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수 {

  public static void 일일칠이사(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int nodes = Integer.parseInt(st.nextToken());
    int lines = Integer.parseInt(st.nextToken());

    ArrayList<Integer>[] connect = new ArrayList[nodes + 1];
    boolean[] visited = new boolean[nodes + 1];

    for (int i = 1; i <= nodes; i++) {
      connect[i] = new ArrayList<>();
    }

    int from;
    int to;

    for (int i = 1; i < lines; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());

      connect[from].add(to);
      connect[to].add(from);
    }

    int count = 0;
    for (int i = 1; i <= nodes; i++) {
      if (!visited[i]) {
        dfs(i, connect, visited);
        count++;
      }
    }

    System.out.println(count);
  }

  private static void dfs(int node, ArrayList<Integer>[] connect, boolean[] visited) {
    visited[node] = true;
    for (int next : connect[node]) {
      if (!visited[next]) {
        dfs(next, connect, visited);
      }
    }
  }

  @Test
  public void 정답() throws IOException {
    String input = "6 8\n" +
            "1 2\n" +
            "2 5\n" +
            "5 1\n" +
            "3 4\n" +
            "4 6\n" +
            "5 4\n" +
            "2 4\n" +
            "2 3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일일칠이사(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("1", result[0]);
  }

}
