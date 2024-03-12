import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

  private static int N, M, answer = Integer.MAX_VALUE;
  private static List<List<Integer>> houses = new ArrayList<>(), chickens = new ArrayList<>();

  public static void 일오육팔육(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int node;

    for (int y = 0; y < N; y++) {
      st = new StringTokenizer(br.readLine());
      int x = 0;
      while (st.hasMoreTokens()) {
        node = Integer.parseInt(st.nextToken());
        if (node == 1) houses.add(Arrays.asList(x, y));
        if (node == 2) chickens.add(Arrays.asList(x, y));
        x++;
      }
    }

    br.close();
    doCombination(0, new ArrayList<>());

    System.out.println(answer);

  }

  private static void doCombination(int start, List<List<Integer>> combination) {
    if (combination.size() == M) {
      answer = Math.min(answer, calculateMinInCombination(combination));
      return;
    }

    for (int i = start; i < chickens.size(); i++) {
      combination.add(chickens.get(i));
      doCombination(i + 1, combination);
      combination.remove(combination.size() - 1);
    }
  }

  private static int calculateMinInCombination(List<List<Integer>> selectedChickens) {
    int totalDistance = 0;
    int minDistance;
    for (List<Integer> house : houses) {
      minDistance = Integer.MAX_VALUE;
      for (List<Integer> chicken : selectedChickens) {
        int distance = Math.abs(chicken.get(0) - house.get(0)) + Math.abs(chicken.get(1) - house.get(1));
        minDistance = Math.min(minDistance, distance);
      }
      totalDistance += minDistance;
    }
    return totalDistance;
  }

  @Test
  public void 정답_일오육팔육() throws IOException {
    String input = "5 2\n" +
            "0 2 0 1 0\n" +
            "1 0 1 0 0\n" +
            "0 0 0 0 0\n" +
            "2 0 0 1 1\n" +
            "2 2 0 1 2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일오육팔육(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("10", result[0]);
  }

}
