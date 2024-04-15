package level_2;

import java.util.*;

public class 뉴스클러스터링 {
  public int solution(String str1, String str2) {
    Map<String, Integer> map1 = createMultiset(str1);
    Map<String, Integer> map2 = createMultiset(str2);

    int intersectionSize = 0;
    int unionSize = 0;

    Set<String> allKeys = new HashSet<>(map1.keySet());
    allKeys.addAll(map2.keySet());

    for (String key : allKeys) {
      int count1 = map1.getOrDefault(key, 0);
      int count2 = map2.getOrDefault(key, 0);
      intersectionSize += Math.min(count1, count2);
      unionSize += Math.max(count1, count2);
    }

    double jacard = unionSize == 0 ? 1 : (double) intersectionSize / unionSize;
    return (int) (jacard * 65536);
  }

  private Map<String, Integer> createMultiset(String str) {
    Map<String, Integer> multiset = new HashMap<>();
    String input = str.toLowerCase();

    for (int i = 0; i < input.length() - 1; i++) {
      char first = input.charAt(i);
      char second = input.charAt(i + 1);
      if (Character.isLetter(first) && Character.isLetter(second)) {
        String pair = String.valueOf((first + second));
        multiset.put(pair, multiset.getOrDefault(pair, 0) + 1);
      }
    }

    return multiset;
  }
}
