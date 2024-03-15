package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 주차요금계산 {

  private Map<String, List<String>> inTimeMap = new HashMap<>();
  private Map<String, List<String>> outTimeMap = new HashMap<>();
  private Map<String, Integer> usingTimeMap = new HashMap<>();
  private String in = "IN", out = "OUT", lastTime = "23:59";

  public int[] solution(int[] fees, String[] records) {
    List<String> tempList;

    String[] tempArray;

    for (String record : records) {
      tempArray = record.split(" ");
      String time = tempArray[0];
      String car = tempArray[1];

      if (tempArray[2].equals(in)) {
        tempList = inTimeMap.getOrDefault(car, new LinkedList<>());
        tempList.add(time);
        inTimeMap.put(car, tempList);
        continue;
      }
      tempList = outTimeMap.getOrDefault(car, new LinkedList<>());
      tempList.add(time);
      outTimeMap.put(car, tempList);
    }

    setUsingTime(inTimeMap.keySet());
    return makeFees(fees, inTimeMap.keySet());
  }

  private void setUsingTime(Set<String> carSet) {
    List<String> inTimeList;
    List<String> outTimeList;

    for (String car : carSet) {
      inTimeList = inTimeMap.get(car);
      outTimeList = outTimeMap.get(car) == null ? new ArrayList<>() : outTimeMap.get(car);
      int time = 0;
      if (inTimeList.size() != outTimeList.size()) outTimeList.add(lastTime);

      for (int i = 0; i < inTimeList.size(); i++) {
        time += compareTime(inTimeList.get(i), outTimeList.get(i));
      }

      usingTimeMap.put(car, time);
    }
  }

  int compareTime(String in, String out) {
    return convertMinutes(out) - convertMinutes(in);
  }

  private int convertMinutes(String time) {
    String[] parts = time.split(":");
    int hours = Integer.parseInt(parts[0]);
    int minutes = Integer.parseInt(parts[1]);
    return hours * 60 + minutes;
  }

  private int[] makeFees(int[] fees, Set<String> carSet) {
    int basicMinutes = fees[0];
    int basicFee = fees[1];
    int countMinutes = fees[2];
    int countFee = fees[3];
    int[] answer = new int[carSet.size()];

    List<String> carList = new ArrayList<>(carSet);
    Collections.sort(carList);

    for (int i = 0; i < carList.size(); i++) {
      answer[i] = basicFee;

      int usingTime = usingTimeMap.get(carList.get(i));
      int remainTime = usingTime - basicMinutes;
      if (remainTime > 0) {
        int countTime = (int) Math.ceil(((double) remainTime) / countMinutes);
        answer[i] += countTime * countFee;
      }
    }

    return answer;
  }

  @Test
  public void 정답1() {
    int[] answer = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

    Assertions.assertEquals(14600, answer[0]);
    Assertions.assertEquals(34400, answer[1]);
    Assertions.assertEquals(5000, answer[2]);
  }

  @Test
  public void 정답2() {
//    Assertions.assertEquals(0, solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})[0]);
//    Assertions.assertEquals(591, solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})[1]);
  }

  @Test
  public void 정답3() {
    Assertions.assertEquals(14841, solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})[0]);
  }
}
