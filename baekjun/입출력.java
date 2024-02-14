import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 입출력 {
  public static void 일공공공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s);
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    System.out.println(a + b);
    br.close();
  }

  public static void 이오오팔(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());

    System.out.println(a + b);
    br.close();
  }

  public static void 일공구오공(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());

    for (int i = 0; i < size; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(a + b);
    }

    br.close();
  }

  public static void 일공구오일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    String s;

    while ((s = br.readLine()) != null) {
      st = new StringTokenizer(s, " ");

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(a + b).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  public static void 일공구오이(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    String s;

    while ((s = br.readLine()) != null) {
      st = new StringTokenizer(s, " ");

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (a == 0 || b == 0) break;

      sb.append(a + b).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  public static void 일공구오삼(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());

    for (int i = 0; i < size; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), ",");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(a + b);
    }

    br.close();
  }

  public static void 일일공이일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int size = Integer.parseInt(br.readLine());

    for (int i = 0; i < size; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      sb.append("Case #" + (i + 1) + ": ").append(a + b).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  public static void 일일공이이(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int size = Integer.parseInt(br.readLine());

    for (int i = 0; i < size; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      sb.append("Case #" + (i + 1) + ": " + a + " + " + b + " = ").append(a + b).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  public static void 일일칠일팔(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String s;

    while ((s = br.readLine()) != null) {
      sb.append(s).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  public static void 일일칠이일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    StringBuilder sb = new StringBuilder();
    int count = 0;

    for (int i = 0; i < word.length(); i++) {
      sb.append(word.charAt(i));
      count++;

      if (count == 10) {
        sb.append("\n");
        count = 0;
      }
    }

    System.out.println(sb);
    br.close();
  }

  public static void 이칠사일(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    StringBuilder sb = new StringBuilder();
    int count = 0;

    for (int i = 0; i < word.length(); i++) {
      sb.append(word.charAt(i));
      count++;

      if (count == 10) {
        sb.append("\n");
        count = 0;
      }
    }

    System.out.println(sb);
    br.close();
  }

  public static void 이칠삼구(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int target = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 9; i++) {
      sb.append(target + " * " + i + " = " + (target * i)).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  @Test
  public void 정답_일공공공() throws IOException {
    String input = "1 2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공공공(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("3", result[0]);
  }

  @Test
  public void 정답_이오오팔() throws IOException {
    String input = "1\n2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    이오오팔(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("3", result[0]);
  }

  @Test
  public void 정답_일공구오공() throws IOException {
    String input = "5\n1 1\n2 3\n3 4\n9 8\n5 2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공구오공(new String[]{input});

    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("2", result[0]);
    Assertions.assertEquals("5", result[1]);
    Assertions.assertEquals("7", result[2]);
    Assertions.assertEquals("17", result[3]);
    Assertions.assertEquals("7", result[4]);
  }
}
