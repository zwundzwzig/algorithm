package level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 여행경로 {

  private static List<String> routeList = new ArrayList<>();
  private static boolean[] visited;
  private static final String depart = "ICN";

  public String[] solution(String[][] tickets) {
    visited = new boolean[tickets.length];
    dfs(tickets, depart, 0, depart);
    Collections.sort(routeList);

    return routeList.get(0).split(":");
  }

  private void dfs(String[][] tickets, String start, int cnt, String route) {
    if(cnt == tickets.length) {
      routeList.add(route);
      return;
    }

    String from;
    String to;

    for(int i = 0; i < tickets.length; i++) {
      from = tickets[i][0];
      to = tickets[i][1];

      if(!visited[i] && start.equals(from)) {
        visited[i] = true;
        dfs(tickets, to, cnt + 1, route + ":" + to);
        visited[i] = false;
      }
    }
  }

  @Test
  public void 정답1() {
    String[] answer = solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});

    Assertions.assertEquals("ICN", answer[0]);
    Assertions.assertEquals("JFK", answer[1]);
    Assertions.assertEquals("HND", answer[2]);
    Assertions.assertEquals("IAD", answer[3]);
  }

  @Test
  public void 정답2() {
    String[] answer = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "SFO"}, {"ATL","ICN"}});

    Assertions.assertEquals("ICN", answer[0]);
    Assertions.assertEquals("ATL", answer[1]);
    Assertions.assertEquals("ICN", answer[2]);
    Assertions.assertEquals("SFO", answer[3]);
    Assertions.assertEquals("ATL", answer[4]);
    Assertions.assertEquals("SFO", answer[5]);
  }

}
