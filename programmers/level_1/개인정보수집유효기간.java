package level_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 개인정보수집유효기간 {
  private HashMap<String, LocalDate> maturity = new HashMap<>();
  private StringTokenizer st;

  public int[] solution(String today, String[] terms, String[] privacies) {
    ArrayList<Integer> answer = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    LocalDate todayDate = LocalDate.parse(today, formatter);

    setMaturity(todayDate, terms);
    LocalDate collectionDate;
    String type;

    for (int i = 0; i < privacies.length; i++) {
      st = new StringTokenizer(privacies[i], " ");
      collectionDate = LocalDate.parse(st.nextToken(), formatter);
      type = st.nextToken();
      if (collectionDate.isBefore(maturity.get(type)))  answer.add(i + 1);
    }

    System.out.println(answer);

    return toIntArray(answer);
  }

  private void setMaturity(LocalDate today, String[] terms) {
    for (String term : terms) {
      st = new StringTokenizer(term, " ");
      maturity.put(st.nextToken(), today.minusMonths(Long.parseLong(st.nextToken())).plusDays(1));
    }
  }

  private int[] toIntArray(ArrayList<Integer> list) {
    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(1, solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})[0]);
    Assertions.assertEquals(3, solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})[1]);
    Assertions.assertEquals(1, solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})[0]);
    Assertions.assertEquals(4, solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})[1]);
    Assertions.assertEquals(5, solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})[2]);
  }

}
