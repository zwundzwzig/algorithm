import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class Z {
  public static void 일공칠사(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    br.close();

    System.out.println(z(n, r, c));
  }

  private static int z(int n, int r, int c) {
    if (n == 0) return 0;
    int half = 1 << (n - 1);
    int powHalf = half * half;

    if (r < half && c < half) return z(n - 1, r, c);
    if (r < half && c >= half) return powHalf + z(n - 1, r, c - half);
    if (r >= half && c < half) return powHalf * 2 + z(n - 1, r - half, c);
    else return powHalf * 3 + z(n - 1, r - half, c - half);
  }

  @Test
  public void 정답_일공칠사() throws IOException {
    String input = "10 512 512";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공칠사(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("786432", result[0]);
  }
}