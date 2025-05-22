package level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class testt {

  public int solution(int n, int[] student, int[] point) {
    int changes = 0;

    Map<Integer, Integer> global = new HashMap<>();
    Map<Integer, Integer> a = new HashMap<>();
    Map<Integer, Integer> b = new HashMap<>();

    for (int i = 0; i < n / 2; i++) {
      global.put(student[i], 1);
      a.put(student[i], 0);
    }

    for (int i = n / 2; i < n; i++) {
      global.put(student[i], 0);
      b.put(student[i], 0);
    }

    for (int i = 0; i < n; i++) {
      int currentStudent = student[i];
      int currentPoint = point[i];
      int currentClass = global.get(currentStudent);

      if (currentClass == 0) { // 열반에 속한 학생의 경우
        int minPointA = a.values().stream().min(Integer::compare).orElse(Integer.MAX_VALUE);
        if (currentPoint > minPointA || (currentPoint == minPointA && currentStudent < getLowestStudent(a))) {
          // 우반의 최하점보다 득점이 높거나, 같지만 번호가 더 낮은 경우에 변경
          int expelledStudent = a.entrySet().stream()
                  .filter(entry -> entry.getValue() == minPointA)
//                  .filter(entry -> entry.getKey() > currentStudent)
                  .map(Map.Entry::getKey)
                  .findFirst().orElse(-1);
          if (expelledStudent != -1) {
            a.remove(expelledStudent);
            a.put(currentStudent, b.get(currentStudent) + currentPoint);
            b.put(expelledStudent, minPointA);
            changes++;
          }
        }
      } else a.put(currentStudent, a.get(currentStudent) + currentPoint);
    }

    return changes;
  }

  // 맵에서 가장 낮은 번호를 가진 학생을 반환하는 메서드
  public static int getLowestStudent(Map<Integer, Integer> map) {
    return map.keySet().stream().min(Integer::compare).orElse(Integer.MAX_VALUE);
  }

  @Test
  public void 정답1() {
    int answer = solution(6, new int[]{6, 1, 4, 2, 5, 1, 3, 3, 1, 6, 5}, new int[]{3, 2, 5, 3, 4, 2, 4, 2, 3, 2, 2});
    Assertions.assertEquals(7, answer);
  }

}