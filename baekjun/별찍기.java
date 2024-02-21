import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class 별찍기 {
  /*
   *
   **
   ***
   ****
   *****
  */
  public static void 이사삼팔(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();

    for (int i = 1; i <= a; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println("");
    }
  }

  /*
       *
      **
     ***
    ****
   *****
   */
  public static void 이사삼구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    br.close();

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N - i; j++) {
        bw.write(' ');
      }
      for (int k = 1; k <= i; k++) {
        bw.write('*');
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }

  /*
   *****
   ****
   ***
   **
   *
   */
  public static void 이사사공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  /*
  *****
   ****
    ***
     **
      *
  */
  public static void 이사사일(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.close();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < N - i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  /*
       *
      ***
     *****
    *******
   *********
  */
  public static void 이사사이(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n-i; j++) {
        sb.append(" ");
      }

      for (int j = 1; j <= 2*i-1; j++) {
        sb.append("*");
      }

      sb.append("\n");
    }

    System.out.print(sb);
    br.close();
  }


  /*
   *********
    *******
     *****
      ***
       *
  * */
  public static void 이사사삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        sb.append(" ");
      }

      for (int j = (2*n) - (i*2-1); j > 0; j--) {
        sb.append("*");
      }

      sb.append("\n");
    }

    System.out.print(sb);
    br.close();
  }

  /*
       *
      ***
     *****
    *******
   *********
    *******
     *****
      ***
       *
  * */
  public static void 이사사사(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    br.close();

    // 상단
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        sb.append(" ");
      }

      for (int j = 1; j <= 2 * i - 1; j++) {
        sb.append("*");
      }

      sb.append("\n");
    }

    // 하단
    for (int i = n - 1; i >= 1; i--) {
      for (int j = 1; j <= n - i; j++) {
        sb.append(" ");
      }

      for (int j = 1; j <= 2 * i - 1; j++) {
        sb.append("*");
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }

  /*
   *        *
   **      **
   ***    ***
   ****  ****
   **********
   ****  ****
   ***    ***
   **      **
   *        *
   * */
  public static void 이사사오(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    br.close();

    // 상단 부분 출력
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        sb.append("*");
      }
      for (int j = 1; j <= 2 * (N - i); j++) {
        sb.append(" ");
      }
      for (int j = 1; j <= i; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }

    // 하단 부분 출력
    for (int i = N - 1; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        sb.append("*");
      }
      for (int j = 1; j <= 2 * (N - i); j++) {
        sb.append(" ");
      }
      for (int j = 1; j <= i; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  /*
   *********
    *******
     *****
      ***
       *
      ***
     *****
    *******
   *********
   * */
  public static void 이사사육(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    br.close();

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < i; j++) {
        sb.append(" ");
      }

      for (int j = (2*n) - (i*2-1); j > 0; j--) {
        sb.append("*");
      }
      sb.append("\n");
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n-i; j++) {
        sb.append(" ");
      }

      for (int j = 1; j <= 2*i-1; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  /*
     *
    **
   ***
    **
     *
  */
  public static void 이오이이(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    br.close();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= size; i++) {
      for (int j = size - i; j > 0; j--) {
        sb.append(" ");
      }
      for (int j = 1; j <= i; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }

    for (int i = 1; i <= size - 1; i++) {
      for (int j = 1; j <= i; j++) {
        sb.append(" ");
      }
      for (int j = 1; j <= size - i; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  /*
      *
     * *
    * * *
   * * * *
  */
  public static void 일공구구일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    br.close();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size - i; j++) {
        sb.append(" ");
      }

      for (int j = 1; j <= i*2-1; j++) {
        if (j % 2 == 0) sb.append(" ");
        else sb.append("*");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  /*
      *
     * *
    *   *
   *******
 */
  public static void 일공구구이(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    br.close();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size - i; j++) {
        sb.append(" ");
      }

      if (i == 1 || i == size) {
        for (int j = 1; j <= 2 * i - 1; j++) {
          sb.append("*");
        }
      }
      else {
        sb.append("*");
        for (int j = 2; j < 2 * i - 1; j++) {
          sb.append(" ");
        }
        sb.append("*");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  @Test
  public void 정답_이사삼팔() {
    String input = "5";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이사삼팔(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("*", result[0]);
    Assertions.assertEquals("**", result[1]);
    Assertions.assertEquals("***", result[2]);
    Assertions.assertEquals("****", result[3]);
    Assertions.assertEquals("*****", result[4]);
  }

  @Test
  public void 정답_이사삼구() {
    String input = "5";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이사삼팔(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("    *", result[0]);
    Assertions.assertEquals("   **", result[1]);
    Assertions.assertEquals("  ***", result[2]);
    Assertions.assertEquals(" ****", result[3]);
    Assertions.assertEquals("*****", result[4]);
  }

  @Test
  public void 정답_이사사사() throws IOException {
    String input = "5";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이사사사(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("    *", result[0]);
    Assertions.assertEquals("   ***", result[1]);
    Assertions.assertEquals("  *****", result[2]);
    Assertions.assertEquals(" *******", result[3]);
    Assertions.assertEquals("*********", result[4]);
    Assertions.assertEquals(" *******", result[5]);
    Assertions.assertEquals("  *****", result[6]);
    Assertions.assertEquals("   ***", result[7]);
    Assertions.assertEquals("    *", result[8]);
  }

  @Test
  public void 정답_이사사육() throws IOException {
    String input = "5";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이사사육(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("*********", result[0]);
    Assertions.assertEquals(" *******", result[1]);
    Assertions.assertEquals("  *****", result[2]);
    Assertions.assertEquals("   ***", result[3]);
    Assertions.assertEquals("    *", result[4]);
    Assertions.assertEquals("   ***", result[5]);
    Assertions.assertEquals("  *****", result[6]);
    Assertions.assertEquals(" *******", result[7]);
    Assertions.assertEquals("*********", result[8]);
  }

  @Test
  public void 정답_이오이이() throws IOException {
    String input = "3";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이오이이(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("  *", result[0]);
    Assertions.assertEquals(" **", result[1]);
    Assertions.assertEquals("***", result[2]);
    Assertions.assertEquals(" **", result[3]);
    Assertions.assertEquals("  *", result[4]);
  }

  @Test
  public void 정답_일공구구일() throws IOException {
    String input = "4";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공구구일(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("   *", result[0]);
    Assertions.assertEquals("  * *", result[1]);
    Assertions.assertEquals(" * * *", result[2]);
    Assertions.assertEquals("* * * *", result[3]);
  }

  @Test
  public void 정답_일공구구이() throws IOException {
    String input = "4";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공구구이(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("   *", result[0]);
    Assertions.assertEquals("  * *", result[1]);
    Assertions.assertEquals(" *   *", result[2]);
    Assertions.assertEquals("*******", result[3]);
  }
}
