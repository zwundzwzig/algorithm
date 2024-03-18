package silver5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class 나이순정렬 {

  public static void 일공팔일사(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int users = Integer.parseInt(br.readLine());

    int age;
    String name;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    ArrayList<User> userList = new ArrayList<>(users);

    for (int i = 0; i < users; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      age = Integer.parseInt(st.nextToken());
      name = st.nextToken();

      userList.add(new User(age, name));
    }
    br.close();

    Collections.sort(userList, (u1, u2) -> {
      if (u1.age == u2.age) return 0;

      return Integer.compare(u1.age, u2.age);
    });

    for (User user : userList) {
      sb.append(user.age + " " + user.name).append("\n");
    }

    System.out.println(sb);
  }

  static class User {
    private int age;
    private String name;

    public User(int age, String name) {
      this.age = age;
      this.name = name;
    }
  }

  @Test
  public void 정답() throws IOException {
    String input = "3\n" +
            "21 Junkyu\n" +
            "21 Dohyun\n" +
            "20 Sunyoung";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공팔일사(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("20 Sunyoung", result[0]);
    Assertions.assertEquals("21 Junkyu", result[1]);
    Assertions.assertEquals("21 Dohyun", result[2]);
  }

}
