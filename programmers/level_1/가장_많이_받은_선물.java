package level_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.StringTokenizer;

class 가장_많이_받은_선물 {
  private HashMap<String, Integer> dic = new HashMap<>();
  private int[][] relation;
  private int[] degree;
//  private HashMap<String, Integer> degreeMap = new HashMap<>();
  private String sender;
  private String receiver;

  public int solution(String[] friends, String[] gifts) {
    // HashMap<String, Integer> answer = new HashMap<>();
    int answer = 0;
    int size = friends.length;
    degree = new int[size];
    relation = new int[size][size];

    for (int i = 0; i < size; i++) {
      // answer.putIfAbsent(friends[i], 0);
      dic.putIfAbsent(friends[i], i);
    }

    setData(gifts);

    for (int i = 0; i < size; i++) {
        int temp = 0;
      for (int j = 0; j < size; j++) {
        if (i == j) continue;

        sender = friends[i];
        receiver = friends[j];

        if (relation[i][j] > relation[j][i]
                ||
                (relation[i][j] == relation[j][i]
                        && degree[i] > degree[j])
        ) {
          // answer.put(sender, answer.getOrDefault(sender, 0) + 1);
          temp++;
        }

        if (temp > answer) answer = temp;
      }
    }

    // return answer.values().stream()
    // .sorted(Comparator.reverseOrder())
    // .findFirst()
    // .orElse(-1);
    return answer;
  }

  private void setData(String[] gifts) {
    for (String gift : gifts) {
      StringTokenizer st = new StringTokenizer(gift, " ");
      sender = st.nextToken();
      receiver = st.nextToken();

      relation[dic.get(sender)][dic.get(receiver)]++;

      degree[dic.get(sender)]++;
      degree[dic.get(receiver)]--;
    }
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(2, solution(new String[] { "muzi", "ryan", "frodo", "neo" }, new String[] { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi" }));
    Assertions.assertEquals(4, solution(new String[] { "joy", "brad", "alessandro", "conan", "david" }, new String[] { "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david" }));
    Assertions.assertEquals(0, solution(new String[] { "a", "b", "c" }, new String[] { "a b", "b a", "c a", "a c", "a c", "c a" }));
  }

}