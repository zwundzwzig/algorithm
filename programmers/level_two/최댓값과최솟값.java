package level_two;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 최댓값과최솟값 {
  public String solution(String s) {
    List<Integer> list = Arrays.stream(s.split(" "))
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());

    return list.get(0) + " " + list.get(list.size() - 1);
  }
}
