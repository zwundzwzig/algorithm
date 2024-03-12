import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 곱셈 {

  public static void 일육이구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    long C = Long.parseLong(st.nextToken());
    br.close();

    System.out.println(modPow(A, B, C));
  }

  public static long modPow(long base, long exponent, long mod) {
    long answer = 1;
    base %= mod;

    while (exponent > 0) {
      if (exponent % 2 != 0) {
        answer = (answer * base) % mod;
      }

      exponent >>= 1;
      base = (base * base) % mod;
    }

    return answer;
  }

  @Test
  public void 정답_일육이구() throws IOException {
    String input = "10 11 12";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일육이구(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("4", result[0]);
  }

}
