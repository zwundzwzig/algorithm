import java.io.*;

public class 구육육삼 {

  private static int N;
  private static int[] cols;
  private static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());

    cols = new int[N];

    backTracking(0);

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }

  static void backTracking(int cnt) {
    if (cnt == N) {
      result++;
      return;
    }

    for (int i = 0; i < N; i++) {
      cols[cnt] = i;

      if (isPossible(cnt))
        backTracking(cnt++);
    }
  }

  static boolean isPossible(int cnt) {
    for (int i = 0; i < cnt; i++) {
      if (cols[i] == cols[cnt] || Math.abs(cnt - i) == Math.abs(cols[cnt] - i))
        return false;
    }

    return true;
  }

}
