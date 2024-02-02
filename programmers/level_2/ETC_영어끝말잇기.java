package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class ETC_영어끝말잇기 {
  public int[] solution(int n, String[] words) {
    int[] answer = new int[2];
    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < words.length - 1; i++) {
      String left = words[i];
      String right = words[i + 1];

      if (left.charAt(left.length() - 1) != right.charAt(0) || set.contains(right)) {
        answer[0] = (i + 1) % n + 1;
        answer[1] = (i + 1) / n + 1;
        break;
      }

      set.add(left);
    }

    System.out.println(answer[0]);
    System.out.println(answer[1]);

    return answer;
  }

  @Test
  public void 정답() {
//    Assertions.assertEquals(new int[] {3,3}, solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
//    Assertions.assertEquals(new int[] {0,0}, solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
    Assertions.assertEquals(new int[] {1,3}, solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));
  }
}
