package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class 생일 {

  private static String youngest = "";
  private static String oldest = "";
  private static int youngestYear = Integer.MIN_VALUE;
  private static int oldestYear = Integer.MAX_VALUE;

  public static void 오육삼오(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      String name = input[0];
      int day = Integer.parseInt(input[1]);
      int month = Integer.parseInt(input[2]);
      int year = Integer.parseInt(input[3]);

      int birthYear = year * 10000 + month * 100 + day;

      if (birthYear < oldestYear) {
        oldestYear = birthYear;
        oldest = name;
      }

      if (birthYear > youngestYear) {
        youngestYear = birthYear;
        youngest = name;
      }
    }

    System.out.println(youngest);
    System.out.println(oldest);

  }

}