package level_two;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class 전화번호목록 {
  public boolean solution(String[] phone_book) {

    Map<String, Integer> phoneNumberMap =
            Arrays.stream(phone_book)
                    .collect(HashMap::new, (map, key) -> map.put(key, 1), HashMap::putAll);

    for (String num : phoneNumberMap.keySet()) {
      for (int i = 0; i < num.length(); i++) {
        if (phoneNumberMap.containsKey(num.substring(0, i)))
          return false;
      }
    }

    return true;
  }
}
