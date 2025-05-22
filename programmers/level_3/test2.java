package level_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class test2 {

  public static int[] solution(String[] purchase) {
    // 각 등급별 유지 기간을 저장할 배열
    int[] membershipPeriod = new int[5];
    // 각 등급의 기준 구매 금액
    int[] purchaseThreshold = {0, 10000, 20000, 50000, 100000};
    // 각 등급의 시작일을 저장할 배열
    int[] membershipStart = new int[5];
    // 날짜별로 최종 구매 기록을 저장할 맵
    Map<String, Integer> lastPurchaseByDate = new HashMap<>();

    // 각 구매 기록을 처리하며 최종 구매 기록 갱신
    for (String record : purchase) {
      String[] parts = record.split(" ");
      String date = parts[0];
      int amount = Integer.parseInt(parts[1]);

      lastPurchaseByDate.put(date, amount);
    }

    // 2019년 1월 1일부터 2019년 12월 31일까지 각 날짜에 대해 등급을 결정하고 기간을 계산
    String currentDate = "2019/01/01";
    int currentDateIndex = 0;
    int currentMembershipIndex = 0;
    for (int i = 0; i < 365; i++) {
      if (lastPurchaseByDate.containsKey(currentDate)) {
        int amount = lastPurchaseByDate.get(currentDate);

        // 현재 등급을 결정
        while (currentMembershipIndex < 5 && amount >= purchaseThreshold[currentMembershipIndex]) {
          currentMembershipIndex++;
        }

        // 현재 등급의 시작일을 업데이트
        membershipStart[currentMembershipIndex] = currentDateIndex;
      }

      // 다음 날짜로 이동
      currentDateIndex++;
      currentDate = getNextDate(currentDate);
    }

    // 등급별 기간 계산
    for (int i = 0; i < 5; i++) {
      membershipPeriod[i] = currentDateIndex - membershipStart[i];
    }

    return membershipPeriod;
  }

  // 다음 날짜 계산
  public static String getNextDate(String currentDate) {
    String[] parts = currentDate.split("/");
    int year = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int day = Integer.parseInt(parts[2]);

    // 각 달의 마지막 날짜 설정
    int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
      daysInMonth[1] = 29; // 윤년일 때 2월은 29일까지
    }

    // 다음 날짜 계산
    day++;
    if (day > daysInMonth[month - 1]) {
      day = 1;
      month++;
      if (month > 12) {
        month = 1;
        year++;
      }
    }

    // 날짜 형식으로 변환하여 반환
    return String.format("%d/%02d/%02d", year, month, day);
  }

  @Test
  public void 정답1() {
    int[] purchase = solution(new String[]{"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"});

    Assertions.assertEquals(315, purchase[0]);
    Assertions.assertEquals(9, purchase[1]);
    Assertions.assertEquals(11, purchase[2]);
    Assertions.assertEquals(20, purchase[3]);
    Assertions.assertEquals(10, purchase[4]);

  }

}