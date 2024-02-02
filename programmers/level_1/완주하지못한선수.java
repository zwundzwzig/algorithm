package level_1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

  public String solution(String[] participant, String[] completion) {
    String answer = "";

    Map<String, Integer> map = new HashMap<>();

    for (String runner : participant) {
      map.put(runner, map.getOrDefault(runner, 0) + 1);
    }

    for (String runner : completion) {
      map.put(runner, map.get(runner) - 1);
    }

    for (String runner : map.keySet()) {
      if (map.get(runner) > 0) answer = runner;
    }

    return answer;
  }

}

