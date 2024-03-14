package silver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 싸이버개강총회 {
  static HashMap<String, String> timeMap = new HashMap<>();
  static String start;
  static String mid;
  static String end;
  static String target;
  static StringTokenizer st;
  static HashSet<String> attend = new HashSet<>();
  static HashSet<String> answer = new HashSet<>();

  public static void 일구오팔삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    start = st.nextToken();
    mid = st.nextToken();
    end = st.nextToken();

    String temp;

    while ((temp = br.readLine()) != null) {
      st = new StringTokenizer(temp, " ");
      String time = st.nextToken();
      String student = st.nextToken();

      if (time.compareTo(end) <= 0) {
        timeMap.put(student, timeMap.containsKey(student) ? timeMap.get(student) + " " + time : time);
      }
    }
    br.close();
    checkAttend();

    System.out.println(answer.size());
  }

  static void checkAttend() {
    for (String student : timeMap.keySet()) {
      String times = timeMap.get(student);

      if (times.contains(" ")) {
        st = new StringTokenizer(times, " ");
        while (st.hasMoreTokens()) {
          target = st.nextToken();

          if (target.compareTo(start) <= 0)
            attend.add(student);

          if (target.compareTo(mid) >= 0 && attend.contains(student))
            answer.add(student);
        }
      }
    }
  }

  @Test
  public void 정답_일구오팔삼() throws IOException {
    String input = "22:00 23:00 23:30\n" +
            "21:30 malkoring\n" +
            "21:33 tolelom\n" +
            "21:34 minjae705\n" +
            "21:35 hhan14\n" +
            "21:36 dicohy27\n" +
            "21:40 906bc\n" +
            "23:00 906bc\n" +
            "23:01 tolelom\n" +
            "23:10 minjae705\n" +
            "23:11 hhan14\n" +
            "23:20 dicohy27";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일구오팔삼(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("5", result[0]);
  }
}
