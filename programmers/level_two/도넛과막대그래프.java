package level_two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 도넛과막대그래프 {

  private static List<List<Integer>> graph;

  private static boolean[] visited;

  private static int createdVertex;

  private static int lastVertexIndex;
  private static int countGraph;

  private static int[] countInEdges;

  private void initGraph(int[][] edges) {
    lastVertexIndex = 0;

    for (int[] edge : edges) {
      lastVertexIndex = Math.max(lastVertexIndex, Math.max(edge[0], edge[1])); // 마지막 정점 번호 확보
    }

    visited = new boolean[lastVertexIndex + 1]; // 각각 배열마다 1~마지막 정점 번호 확인할 수 있도록 +1
    countInEdges = new int[lastVertexIndex + 1];
    graph = new ArrayList<>(lastVertexIndex + 1);

    for (int i = 0; i <= lastVertexIndex; i++) {
      graph.add(new LinkedList<>()); // 단방향 그래프로 설정
    }

    for (int i = 0; i < edges.length; i++) {
      graph.get(edges[i][0]).add(edges[i][1]); // key 정점에서 value 정점으로 향한 간선, graph.get(key) 하면 key에서 나간 간선 확보 가능
      countInEdges[edges[i][1]]++; // i 정점이 받은 간선 추가
    }
  }

  public int[] solution(int[][] edges) {
    int[] answer = new int[4];

    initGraph(edges); // 그래프 초기화

    createdVertex = findCreatedVertex(); // 생성된 정점 번호 찾기
    countGraph = graph.get(createdVertex).size(); // 전체 그래프 갯수 찾기
    answer[0] = createdVertex;

    removeEdgesFromCreatedVertex(createdVertex); //시작 정점 연결 끊기

    //막대 그래프 갯수 찾기.
    //들어오는 간선이 없는 정점이 하나, 나가는 간선이 없는 정점이 하나 존재
    answer[2] = countBarGraphs();

    //8자모양 그래프 갯수 찾기.
    //둘어오는 간선 2개, 나가는 간선2개인 vertex의 갯수이다.
    answer[3] = countEightShape();

    answer[1] = countGraph - (answer[2] + answer[3]);

    return answer;
  }

  private int countBarGraphs() {
    int count = 0;

    for (int i = 1; i < graph.size(); i++) {
      if (i == createdVertex)
        continue;

      if (graph.get(i).isEmpty()) { //나가는 게 없다.
        count++;
        visited[i] = true;
      }
    }

    return count;
  }

  private int countEightShape() {
    int count = 0;
    for (int i = 1; i < graph.size(); i++) {
      if (!visited[i]) {
        if (graph.get(i).size() == 2 && countInEdges[i] == 2) {
          count++;
        }
      }
    }
    return count;
  }

  private int findCreatedVertex() {
    //들어오는 거의 갯수가 없고, 나가는 것만 2개 이상인 점.
    int answer = 0;
    for (int i = 1; i < graph.size(); i++) {
      if (graph.get(i).size() >= 2 && countInEdges[i] == 0) {
        answer = i;
        break;
      }
    }
    visited[answer] = true;
    return answer;
  }

  private void removeEdgesFromCreatedVertex(int vertex) {
    for(int end : graph.get(vertex))
      countInEdges[end]--; // 생성된 정점에서 간선이 향한 정점이 받은 수 하나씩 제거

    graph.set(vertex, new LinkedList<>()); // 이제 해당 정점에서 향하는 간선없어졌으니 초기화 진행
  }
}