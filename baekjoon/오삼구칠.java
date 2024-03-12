import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class 오삼구칠 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

    for (int t = 0; t < T; t++) {
      String input = br.readLine();
      String result = getPassword(input);

      System.out.println(result);
    }
  }

  private static String getPassword(String input) {
    List<Character> password = new LinkedList<>();
    ListIterator<Character> iterator = password.listIterator();

    for (char ch : input.toCharArray()) {
      if (ch == '<') {
        if (iterator.hasPrevious()) {
          iterator.previous();
        }
      } else if (ch == '>') {
        if (iterator.hasNext()) {
          iterator.next();
        }
      } else if (ch == '-') {
        if (iterator.hasPrevious()) {
          iterator.previous();
          iterator.remove();
        }
      } else {
        iterator.add(ch);
      }
    }

    StringBuilder result = new StringBuilder();
    for (char ch : password) {
      result.append(ch);
    }

    return result.toString();
  }
}