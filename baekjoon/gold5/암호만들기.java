package gold5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {

  static int L, C;
  static char[] alphabets;
  static StringBuilder password = new StringBuilder();

  public static void 일칠오구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    alphabets = new char[C];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) {
      alphabets[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(alphabets);

    backtrack(0, 0, 0, 0);
  }

  public static void backtrack(int index, int selected, int consonants, int vowels) {
    if (selected == L) {
      if (consonants >= 2 && vowels >= 1) System.out.println(password);
      return;
    }

    if (index >= C) return;

    password.append(alphabets[index]);
    char current = alphabets[index];
    if (isVowel(current))
      backtrack(index + 1, selected + 1, consonants, vowels + 1);
    else
      backtrack(index + 1, selected + 1, consonants + 1, vowels);
    password.deleteCharAt(password.length() - 1);

    backtrack(index + 1, selected, consonants, vowels);
  }

  public static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  @Test
  public void 정답() throws IOException {
    String input = "4 6\n" +
            "a t c i s w";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일칠오구(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("acis", result[0]);
    Assertions.assertEquals("acit", result[1]);
    Assertions.assertEquals("aciw", result[2]);
    Assertions.assertEquals("acst", result[3]);
    Assertions.assertEquals("acsw", result[4]);
    Assertions.assertEquals("actw", result[5]);
    Assertions.assertEquals("aist", result[6]);
    Assertions.assertEquals("aisw", result[7]);
    Assertions.assertEquals("aitw", result[8]);
    Assertions.assertEquals("astw", result[9]);
    Assertions.assertEquals("cist", result[10]);
    Assertions.assertEquals("cisw", result[11]);
    Assertions.assertEquals("citw", result[12]);
    Assertions.assertEquals("istw", result[13]);
  }
}

