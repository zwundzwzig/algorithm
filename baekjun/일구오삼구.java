import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class 일구오삼구 {

  public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int sizeAppleTree = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine(), " ");
    int sum = 0, odd = 0, tmp;

    for(int i = 0; i < sizeAppleTree; i++) {
      tmp = Integer.parseInt(st.nextToken());
      sum += tmp;
      if(tmp %2 == 1) odd++;
    }

    br.close();

    System.out.println(sum%3 == 0 && odd <= sum / 3 ? "YES" : "NO");
  }

  @Test
  public void 정답_일구오삼구() throws IOException {
    String first = "1\n0";
    String second = "2\n4 3";
    String third = "3\n10000 1000 100";
    String fourth = "5\n1 3 1 3 1";
    InputStream in = new ByteArrayInputStream(first.getBytes());
    System.setIn(in);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    main(new String[]{first});
    String[] result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("YES", result[0]);
    main(new String[]{second});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("NO", result[0]);
    main(new String[]{third});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("YES", result[0]);
    main(new String[]{fourth});
    result = outContent.toString().split(System.lineSeparator());
    Assertions.assertEquals("NO", result[0]);
  }
}
