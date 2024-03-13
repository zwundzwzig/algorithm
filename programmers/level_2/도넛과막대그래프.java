package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 도넛과막대그래프 {

  private static List<List<Integer>> graph;
  private static boolean[] visited;
  private static int[] countIncoming;

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
    int maxVertex = 0;

    for (int[] edge : edges) {
      maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
    }

    visited = new boolean[maxVertex + 1];
    countIncoming = new int[maxVertex + 1];
    graph = new ArrayList<>(maxVertex + 1);

    for (int i = 0; i <= maxVertex; i++) {
      graph.add(new LinkedList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      graph.get(edges[i][0]).add(edges[i][1]);
      countIncoming[edges[i][1]]++;
    }
  }

  private int findCreatedVertex() {
    int createdVertex = 0;
    for (int i = 1; i < graph.size(); i++) {
      if (graph.get(i).size() >= 2 && countIncoming[i] == 0) {
        createdVertex = i;
        break;
      }
    }
    visited[createdVertex] = true;
    return createdVertex;
  }

  private int findGraph(String param) {
    int count = 0;
    for (int i = 1; i < graph.size(); i++) {
      if (!visited[i]) {
        if (param.equals(BAR) && graph.get(i).isEmpty()) {
          count++;
          visited[i] = true;
        } else if (param.equals(EIGHT) && graph.get(i).size() == 2 && countIncoming[i] == 2) {
          count++;
          visited[i] = true;
        }
      }
    }
    return count;
  }

  private void removeEdgesFromCreatedVertex(int vertex) {
    for (int end : graph.get(vertex)) {
      countIncoming[end]--;
    }
    graph.set(vertex, null);
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(2, solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})[0]);
    Assertions.assertEquals(1, solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})[1]);
    Assertions.assertEquals(1, solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})[2]);
    Assertions.assertEquals(0, solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})[3]);

    Assertions.assertEquals(4, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[0]);
    Assertions.assertEquals(0, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[1]);
    Assertions.assertEquals(1, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[2]);
    Assertions.assertEquals(2, solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})[3]);
  }

}
