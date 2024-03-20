package silver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class 에디터 {

  private static final String l = "L", d = "D", b = "B", p = "P";

  public static void 일사공육(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    LinkedList<Character> editor = new LinkedList<>();
    for (char ch : input.toCharArray()) {
      editor.add(ch);
    }

    ListIterator<Character> cursor = editor.listIterator(editor.size());
    StringTokenizer st;
    int len = Integer.parseInt(br.readLine());

    for (int i = 0; i < len; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      switch (st.nextToken()) {
        case l:
          if (cursor.hasPrevious()) {
            cursor.previous();
          }
          break;
        case d:
          if (cursor.hasNext()) {
            cursor.next();
          }
          break;
        case b:
          if (cursor.hasPrevious()) {
            cursor.previous();
            cursor.remove();
          }
          break;
        case p:
          cursor.add(st.nextToken().charAt(0));
          break;
      }
    }

    StringBuilder result = new StringBuilder();
    for (char ch : editor) {
      result.append(ch);
    }

    System.out.println(result);
  }

  @Test
  public void 정답() throws IOException {
    String input = "dmih\n" +
            "11\n" +
            "B\n" +
            "B\n" +
            "P x\n" +
            "L\n" +
            "B\n" +
            "B\n" +
            "B\n" +
            "P y\n" +
            "D\n" +
            "D\n" +
            "P z";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일사공육(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("yxz", result[0]);
  }

}
