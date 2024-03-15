package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 도넛과막대그래프 {

  private static Map<Integer, List<Integer>> graph = new HashMap<>();
  private static Map<Integer, Boolean> visited = new HashMap<>();
  private static Map<Integer, Integer> countIncoming = new HashMap<>();

  private static String EIGHT = "EIGHT", BAR = "BAR";

  public int[] solution(int[][] edges) {
    int[] answer = new int[4];
    initGraph(edges);

    int createdVertex = findCreatedVertex();
    int graphNum = graph.get(createdVertex).size();
    answer[0] = createdVertex;
    removeEdgesFromCreatedVertex(createdVertex);

    answer[2] = findGraph(BAR);
    answer[3] = findGraph(EIGHT);
    answer[1] = graphNum - (answer[2] + answer[3]);

    return answer;
  }

  private void initGraph(int[][] edges) {
    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];

      visited.put(from, false);
      visited.put(to, false);
      graph.putIfAbsent(from, new LinkedList<>());
      graph.putIfAbsent(to, null);
      graph.get(from).add(to);

      countIncoming.put(to, countIncoming.getOrDefault(to, 1) + 1);
    }
  }

  private int findCreatedVertex() {
    int createdVertex = 0;
    for (int key : graph.keySet()) {
      if (graph.get(key) != null && graph.get(key).size() >= 2 && countIncoming.get(key) == null) {
        createdVertex = key;
        break;
      }
    }
    visited.put(createdVertex, true);
    return createdVertex;
  }

  private int findGraph(String param) {
    int count = 0;
    for (int key : graph.keySet()) {
      if (!visited.get(key)) {
        if (param.equals(BAR) && graph.get(key) == null) {
          count++;
          visited.put(key, true);
        } else if (param.equals(EIGHT)
                && graph.get(key) != null
                && countIncoming.get(key) != null
                && graph.get(key).size() == 2
                && countIncoming.get(key) == 2) {
          count++;
          visited.put(key, true);
        }
      }
    }
    return count;
  }

  private void removeEdgesFromCreatedVertex(int vertex) {
    for (int end : graph.get(vertex)) {
      countIncoming.put(end, countIncoming.get(end) - 1);
    }
    graph.put(vertex, null);
  }

  @Test
  public void 정답1() {
    Assertions.assertEquals(2, solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})[0]);
    Assertions.assertEquals(1, solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})[1]);
    Assertions.assertEquals(1, solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})[2]);
    Assertions.assertEquals(0, solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})[3]);
  }

  @Test
  public void 정답2() {
    Assertions.assertEquals(4, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[0]);
    Assertions.assertEquals(0, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[1]);
    Assertions.assertEquals(1, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[2]);
    Assertions.assertEquals(2, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[3]);
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(4, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 25}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[0]);
    Assertions.assertEquals(0, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 25}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[1]);
    Assertions.assertEquals(1, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 25}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[2]);
    Assertions.assertEquals(2, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 25}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[3]);
  }

}
