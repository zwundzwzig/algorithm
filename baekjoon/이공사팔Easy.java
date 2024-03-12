import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 이공사팔Easy {
  private static int N;
  private static int[][] blocks;
  static int max = -1;

  public static void 일이일공공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    blocks = new int[N][N];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        blocks[i][j] = Integer.parseInt(st.nextToken());
        max = Math.max(max, blocks[i][j]);
      }
    }
    br.close();

    dfs(blocks, 0);

    System.out.println(max);
  }

  static void dfs(int[][] origin, int count) {
    if (count == 5) return;

    for (int direction = 0; direction < 4; direction++) {
      int[][] moved = play(origin, direction);
      dfs(moved, count + 1);
    }
  }

  static int[][] play(int[][] origin, int direction) {
    int[][] tempBoard = new int[N][N];

    if (direction == 0) blocks = up(origin, tempBoard);
    else if (direction == 1) blocks = down(origin, tempBoard);
    else if (direction == 2) blocks = left(origin, tempBoard);
    else blocks = right(origin, tempBoard);

    return blocks;
  }

  private static int[][] up(int[][] blocks, int[][] tempBoard) {
    for (int y = 0; y < N; y++) {
      int nextIndex = 0, target = -1;

      for (int x = 0; x < N; x++) {
        if (blocks[x][y] == 0) continue;

        if (blocks[x][y] == target) {
          tempBoard[nextIndex - 1][y] = target * 2;
          max = Math.max(max, tempBoard[nextIndex - 1][y]);
          target = -1;
        }
        else {
          tempBoard[nextIndex++][y] = target = blocks[x][y];
        }
      }
    }

    return tempBoard;
  }

  private static int[][] down(int[][] blocks, int[][] tempBoard) {
    for (int y = 0; y < N; y++) {
      int nextIndex = N - 1, target = -1;

      for (int x = N - 1; x >= 0; x--) {
        if (blocks[x][y] == 0) continue;

        if (blocks[x][y] == target) {
          tempBoard[nextIndex + 1][y] = target * 2;
          max = Math.max(max, tempBoard[nextIndex + 1][y]);
          target = -1;
        }
        else {
          tempBoard[nextIndex--][y] = target = blocks[x][y];
        }
      }
    }
    return tempBoard;
  }

  private static int[][] left(int[][] blocks, int[][] tempBoard) {
    for (int x = 0; x < N; x++) {
      int nextIndex = 0, target = -1;

      for (int y = 0; y < N; y++) {
        if (blocks[x][y] == 0) continue;

        if (blocks[x][y] == target) {
          tempBoard[x][nextIndex - 1] = target * 2;
          max = Math.max(max, tempBoard[x][nextIndex - 1]);
          target = -1;
        }
        else {
          tempBoard[x][nextIndex++] = target = blocks[x][y];
        }
      }
    }
    return tempBoard;
  }

  private static int[][] right(int[][] blocks, int[][] tempBoard) {
    for (int x = 0; x < N; x++) {
      int nextIndex = N - 1, target = -1;

      for (int y = N - 1; y >= 0; y--) {
        if (blocks[x][y] == 0) continue;

        if (blocks[x][y] == target) {
          tempBoard[x][nextIndex + 1] = target * 2;
          max = Math.max(max, tempBoard[x][nextIndex + 1]);
          target = -1;
        }
        else {
          tempBoard[x][nextIndex--] = target = blocks[x][y];
        }
      }
    }
    return tempBoard;
  }

  @Test
  public void 정답_일이일공공() throws IOException {
    String input = "3\n" +
            "2 2 2\n" +
            "4 4 4\n" +
            "8 8 8";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일이일공공(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("16", result[0]);
  }

}
