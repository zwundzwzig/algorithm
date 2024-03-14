package gold4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 여행가자 {

  static int cities, plans;
  static int[] parents;

  public static void 일구칠육(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    cities = Integer.parseInt(br.readLine());
    plans = Integer.parseInt(br.readLine());

    parents = new int[cities + 1];
    for (int i = 1; i < cities + 1; i++) {
      parents[i] = i;
    }

    for (int i = 1; i < cities + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < cities + 1; j++) {
        int num = Integer.parseInt(st.nextToken());
        if (num == 1) union(i, j);
      }
    }

    st = new StringTokenizer(br.readLine());
    int root = find(Integer.parseInt(st.nextToken()));
    for (int i = 0; i < plans - 1; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (root != find(num)) {
        System.out.println("NO");
        return;
      }
    }

    br.close();
    System.out.println("YES");
  }

  static int find(int x) {
    if (x == parents[x]) return x;
    return find(parents[x]);
  }

  static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x < y) parents[y]= x;
    else parents[x] = y;
  }

  @Test
  public void 정답_일구칠육() throws IOException {
    String input = "3\n" +
            "3\n" +
            "0 1 0\n" +
            "1 0 1\n" +
            "0 1 0\n" +
            "1 2 3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일구칠육(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("YES", result[0]);
  }
}

