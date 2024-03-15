package level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
  private int n, m;
  private int answer;
  private boolean[][] visited;
  private int[][] deltas = { {-1,0}, {1,0}, {0,-1}, {0,1} }; // 상하좌우
  private int[] dr = { -1, 1, 0, 0 }; // 상하좌우
  private int[] dc = { 0, 0, -1, 1 };

  public int solution(int[][] maps) {
    this.n = maps.length;
    this.m = maps[0].length;
    this.answer = Integer.MAX_VALUE;
    this.visited = new boolean[n][m];

    bfs(maps);

    return (answer == Integer.MAX_VALUE) ? -1 : answer;
  }

  private void bfs(int[][] maps) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0, 0, 1});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int row = current[0];
      int col = current[1];
      int distance = current[2];

      if (row == n - 1 && col == m - 1) {
        answer = distance;
        return;
      }

      for (int i = 0; i < dr.length; i++) {
        int newRow = row + dr[i];
        int newCol = col + dc[i];

        if (isValid(newRow, newCol) && maps[newRow][newCol] == 1 && !visited[newRow][newCol]) {
          queue.offer(new int[]{newRow, newCol, distance + 1});
          visited[newRow][newCol] = true;
        }
      }
    }

    answer = -1;
  }

  private boolean isValid(int row, int col) {
    return row >= 0 && row < n && col >= 0 && col < m;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(11, solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    Assertions.assertEquals(-1, solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
  }
}
