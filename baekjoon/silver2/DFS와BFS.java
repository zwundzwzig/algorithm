package silver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
  static StringBuilder sb = new StringBuilder();
  static Queue<Integer> q = new LinkedList<>();

  public static void 일이육공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int nodes = Integer.parseInt(st.nextToken());
    int lines = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());

    int from;
    int to;

    boolean[][] links = new boolean[nodes + 1][nodes + 1];

    for(int i = 0 ; i < lines ; i ++) {
      StringTokenizer str = new StringTokenizer(br.readLine());

      from = Integer.parseInt(str.nextToken());
      to = Integer.parseInt(str.nextToken());

      links[from][to] = links[to][from] = true;
    }

    dfs(start, links, new boolean[nodes + 1]);

    if(sb.length() > 0) sb.setLength(sb.length() - 1);

    sb.append("\n");
    bfs(start, links, new boolean[nodes + 1]);

    if(sb.length() > 0) sb.setLength(sb.length() - 1);

    System.out.println(sb);
  }

  public static void dfs(int start, boolean[][] links, boolean[] visited) {
    visited[start] = true;
    sb.append(start).append(" ");

    for(int i = 0 ; i < links.length ; i++) {
      if(links[start][i] && !visited[i])
        dfs(i, links, visited);
    }
  }

  public static void bfs(int start, boolean[][] links, boolean[] visited) {
    q.offer(start);
    visited[start] = true;

    while(!q.isEmpty()) {
      start = q.poll();
      sb.append(start).append(" ");

      for(int i = 1 ; i < links.length ; i++) {
        if(links[start][i] && !visited[i]) {
          q.offer(i);
          visited[i] = true;
        }
      }
    }
  }

  @Test
  public void 정답() throws IOException {
    String input = "5 5 3\n" +
            "5 4\n" +
            "5 2\n" +
            "1 2\n" +
            "3 4\n" +
            "3 1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일이육공(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("3 1 2 5 4", result[0]);
    Assertions.assertEquals("3 1 4 2 5", result[1]);
  }

}
