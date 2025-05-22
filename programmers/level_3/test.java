package level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class test {

  public static int[] solution(int n, int[][] quests) {
    // 퀘스트 그래프 생성
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int[] quest : quests) {
      int prerequisite = quest[0];
      int target = quest[1];
      graph.get(target).add(prerequisite);
    }

    // 퀘스트 순서 찾기
    List<Integer> order = new ArrayList<>();
    boolean[] visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      dfs(i, graph, visited, order);
    }

    // List를 배열로 변환하여 반환
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = order.get(i);
    }
    return result;
  }

  private static void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, List<Integer> order) {
    if (!visited[node]) {
      visited[node] = true;
      for (int prerequisite : graph.get(node)) {
        dfs(prerequisite, graph, visited, order);
      }
      order.add(node);
    }
  }

  @Test
  public void 정답1() {
    int[] answer = solution(5, new int[][]{{1, 3}, {1, 4}, {3, 5}, {5, 4}});

    Assertions.assertEquals(1, answer[0]);
    Assertions.assertEquals(2, answer[1]);
    Assertions.assertEquals(3, answer[2]);
    Assertions.assertEquals(5, answer[3]);
    Assertions.assertEquals(4, answer[4]);

  }

}