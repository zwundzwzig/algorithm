package gold5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC {

  private static final char r = 'R';

  public static void 오사삼공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    String function;
    int n;
    String stringForArray;
    ArrayList<Integer> listForDeque;

    for (int t = 0; t < T; t++) {
      function = br.readLine();
      n = Integer.parseInt(br.readLine());
      stringForArray = br.readLine();
      listForDeque = parseStringToArray(stringForArray);

      sb.append(getResult(listForDeque, function)).append("\n");
    }
    br.close();

    System.out.println(sb);
  }

  private static ArrayList<Integer> parseStringToArray(String stringForArray) {
    ArrayList<Integer> arr = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(stringForArray.substring(1, stringForArray.length() - 1), ",");
    while (st.hasMoreTokens()) {
      arr.add(Integer.parseInt(st.nextToken()));
    }
    return arr;
  }

  private static String getResult(ArrayList<Integer> listForDeque, String function) {
    boolean reverse = false;
    Deque<Integer> deque = new LinkedList<>(listForDeque);

    for (char func : function.toCharArray()) {
      if (func == r) {
        reverse = !reverse;
      } else {
        if (deque.isEmpty()) return "error";
        if (reverse) deque.pollLast();
        else deque.pollFirst();
      }
    }

    StringBuilder sb = new StringBuilder("[");
    while (!deque.isEmpty()) {
      sb.append(!reverse ? deque.pollFirst() : deque.pollLast());
      if (!deque.isEmpty()) sb.append(",");
    }
    sb.append("]");
    return sb.toString();
  }

  @Test
  public void 정답() throws IOException {
    String input = "4\n" +
            "RDD\n" +
            "4\n" +
            "[1,2,3,4]\n" +
            "DD\n" +
            "1\n" +
            "[42]\n" +
            "RRD\n" +
            "6\n" +
            "[1,1,2,3,5,8]\n" +
            "D\n" +
            "0\n" +
            "[]";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    오사삼공(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("[2,1]", result[0]);
    Assertions.assertEquals("error", result[1]);
    Assertions.assertEquals("[1,2,3,5,8]", result[2]);
    Assertions.assertEquals("error", result[3]);
  }

}
