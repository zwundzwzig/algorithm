package level_3;

import java.util.Stack;

class 네트워크 {

  public int 네트워크(int n, int[][] computers) {
    int answer = 0;
    boolean[] visited = new boolean[n];

    for(int i = 0; i < n; i++) {
      if(!visited[i]) {
        dfs(computers, visited, i);
        answer++;
      }
    }
    return answer;
  }

  private void dfs(int[][] computers, boolean[] visited, int v) {
    Stack<Integer> stack = new Stack<>();
    visited[v] = true;
    stack.push(v);

    while(!stack.isEmpty()) {
      Integer w = stack.peek();
      visited[w] = true;

      boolean hasAdjNodeNotVisited = false; // 방문하지 않은 인접 노드가 있는지?

      for(int i = 0; i < computers.length; i++) {
        if(computers[w][i] == 1 && !visited[i]) {
          visited[i] = true;
          hasAdjNodeNotVisited = true;
          stack.push(i);
          break;
        }
      }

      if(!hasAdjNodeNotVisited) {
        stack.pop();
      }
    }
  }

}

