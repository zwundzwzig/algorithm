package level_2;

import java.util.*;

public class 귤고르기 {
  public int solution(int k, int[] tangerine) {
    Map<Integer, Integer> map = new HashMap<>();
    int answer = 0, i = 0;

    for (int tang : tangerine) {
      map.put(tang, map.getOrDefault(tang, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
    Collections.sort(entryList, Map.Entry.comparingByValue(Comparator.reverseOrder()));

    while (k <= 0) {
      System.out.println(entryList.get(i).getValue());
      k -= entryList.get(i).getValue();
      i++;
      answer++;
    }

    return answer;
  }
}
