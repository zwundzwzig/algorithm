package silver4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 국영수 {

  public static void 일공팔이오(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String name;
    int korean;
    int english;
    int math;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    ArrayList<Student> students = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      name = st.nextToken();
      korean = Integer.parseInt(st.nextToken());
      english = Integer.parseInt(st.nextToken());
      math = Integer.parseInt(st.nextToken());

      students.add(new Student(name, korean, english, math));
    }
    br.close();

    Collections.sort(students, (s1, s2) -> {
      if (s1.korean != s2.korean) return Integer.compare(s2.korean, s1.korean);
      else if (s1.english != s2.english) return Integer.compare(s1.english, s2.english);
      else if (s1.math != s2.math) return Integer.compare(s2.math, s1.math);
      else return s1.name.compareTo(s2.name);
    });

    for (Student student : students) {
      sb.append(student.name).append("\n");
    }

    System.out.println(sb);
  }

  static class Student {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student(String name, int korean, int english, int math) {
      this.name = name;
      this.korean = korean;
      this.english = english;
      this.math = math;
    }
  }

  @Test
  public void 정답() throws IOException {
    String input = "12\n" +
            "Junkyu 50 60 100\n" +
            "Sangkeun 80 60 50\n" +
            "Sunyoung 80 70 100\n" +
            "Soong 50 60 90\n" +
            "Haebin 50 60 100\n" +
            "Kangsoo 60 80 100\n" +
            "Donghyuk 80 60 100\n" +
            "Sei 70 70 70\n" +
            "Wonseob 70 70 90\n" +
            "Sanghyun 70 70 80\n" +
            "nsj 80 80 80\n" +
            "Taewhan 50 60 90";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    일공팔이오(new String[]{input});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("Donghyuk", result[0]);
    Assertions.assertEquals("Sangkeun", result[1]);
    Assertions.assertEquals("Sunyoung", result[2]);
    Assertions.assertEquals("nsj", result[3]);
    Assertions.assertEquals("Wonseob", result[4]);
    Assertions.assertEquals("Sanghyun", result[5]);
    Assertions.assertEquals("Sei", result[6]);
    Assertions.assertEquals("Kangsoo", result[7]);
    Assertions.assertEquals("Haebin", result[8]);
    Assertions.assertEquals("Junkyu", result[9]);
    Assertions.assertEquals("Soong", result[10]);
    Assertions.assertEquals("Taewhan", result[11]);
  }

}
