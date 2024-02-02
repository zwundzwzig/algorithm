package level_2;

public class N개의최소공배수 {
  public int solution(int[] arr) {
    int answer = getLcm(arr[0], arr[1]);

    for (int i = 2; i < arr.length; i++) {
      answer = getLcm(answer, arr[i]);
    }

    return answer;
  }

  private int getLcm(int a, int b) {
    return (a * b) / getGcd(a, b);
  }

  private int getGcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
