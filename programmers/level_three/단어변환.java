package level_three;

import java.util.ArrayList;
import java.util.Arrays;

public class 단어변환 {
  boolean[] isVisited;
  int answer;

  public int solution(String begin, String target, String[] words) {
    isVisited = new boolean[words.length];

    ArrayList<String> strList = new ArrayList<>(Arrays.asList(words));
    if (!strList.contains(target)) return 0;

    for (int i = 0; i < words.length; i++) {
      if(compare(begin, words[i])) {
        isVisited[i] = true;
        dfs(1, i, target, words);
      }
    }

    return answer;
  }

  private void dfs(int cnt, int cur, String target, String[] words) {
    if(target.equals(words[cur])) {
      answer = cnt;
      return;
    }

    for (int i = 0; i < words.length; i++) {
      if(!isVisited[i] && compare(words[cur], words[i])) {
        isVisited[i] = true;
        dfs(cnt + 1, i, target, words);
        isVisited[i] = false;
      }
    }
  }

  private boolean compare(String s1, String s2) {
    int n = 0;
    for (int i = 0; i < s1.length(); i++)
      if(s1.charAt(i) != s2.charAt(i))
        n++;

    return n == 1 ? true : false;
  }
}
