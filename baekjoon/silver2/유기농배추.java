package silver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추 {

  private static int[][] field;
  private static boolean[][] visited;

  public static void 일공일이(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int row;
    int column;
    int cabbage;

    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine(), " ");
      row = Integer.parseInt(st.nextToken());
      column = Integer.parseInt(st.nextToken());
      cabbage = Integer.parseInt(st.nextToken());

      field = new int[row][column];
      visited = new boolean[row][column];

      for (int i = 0; i < cabbage; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        field[row][column]++;
      }

      int earthworm = 0;

      for (int x = 0; x < field.length; x++) {
        for (int y = 0; y < field[0].length; y++) {
          if (field[x][y] != 0 && !visited[x][y]) {
            earthworm++;
            dfs(x, y);
          }
        }
      }

      sb.append(earthworm).append("\n");
    }

    br.close();
    System.out.println(sb);
  }

  private static void dfs( int x, int y) {
    visited[x][y] = true;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0
              && nx < field.length && ny < field[0].length
              && field[nx][ny] == 1 && !visited[nx][ny]
      ) {
        dfs(nx, ny);
      }
    }
  }

  @Test
  public void 정답() throws IOException {
    String input = "2\n" +
            "10 8 17\n" +
            "0 0\n" +
            "1 0\n" +
            "1 1\n" +
            "4 2\n" +
            "4 3\n" +
            "4 5\n" +
            "2 4\n" +
            "3 4\n" +
            "7 4\n" +
            "8 4\n" +
            "9 4\n" +
            "7 5\n" +
            "8 5\n" +
            "9 5\n" +
            "7 6\n" +
            "8 6\n" +
            "9 6\n" +
            "10 10 1\n" +
            "5 5";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공일이(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("5", result[0]);
    Assertions.assertEquals("1", result[1]);
  }

}

