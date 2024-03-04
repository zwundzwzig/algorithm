package level_2;

import java.util.HashSet;

// 참고 : https://velog.io/@yanghl98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%9B%84%EB%B3%B4%ED%82%A4-JAVA%EC%9E%90%EB%B0%94-2019-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B8%B0%EC%B6%9C#%EC%B0%B8%EA%B3%A0-%EC%82%AC%EC%9D%B4%ED%8A%B8

class dfs_후보키 {
  static HashSet<String> set;

  public int solution(String[][] relation) {
    set = new HashSet<String>();
    int length = relation[0].length;
    boolean[] visited = new boolean[length];

    for (int i = 1; i <= length; i++) {
      dfs(0, 0, i, visited, relation);
    }

    return set.size();
  }

  public void dfs(int index, int count, int limit, boolean[] visited, String[][] relation) {
    if (count == limit) {
      String cols = "";

      for (int i = 0; i < visited.length; i++) {
        if (visited[i]) cols += i;
      }

      if (validateCandidateKey(cols, visited, relation))
        set.add(cols);

      return;
    }

    if(index >= visited.length) return;
    visited[index] = true;
    dfs(index + 1, count + 1, limit, visited, relation);

    visited[index] = false;
    dfs(index + 1, count, limit, visited, relation);
  }

  public static boolean validateCandidateKey(String cols, boolean[] visited, String[][] relation) {
    for (String s : set) {
      boolean flag = true;
      for (int i = 0; i < s.length(); i++) {
        if(!cols.contains(s.charAt(i)+""))
          flag = false;
      }

      if(flag) return false;
    }

    HashSet<String> values = new HashSet<>();
    int[] colArray = new int[cols.length()];
    int idx = 0;
    for (int i = 0; i < visited.length; i++) {
      if(visited[i]){
        colArray[idx++] = i;
      }
    }

    String value = "";
    for (int i = 0; i < relation.length; i++) {
      value = "";
      for (int j = 0; j < colArray.length; j++) {
        value += relation[i][colArray[j]];
      }

      if(values.contains(value))
        return false;
      else values.add(value);
    }

    return true;
  }

}