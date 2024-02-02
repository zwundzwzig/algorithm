package level_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 퀵정렬_최솟값만들기 {
  public int solution(int []A, int []B) {
    int answer = 0;

    Arrays.sort(A);
    Arrays.sort(B);

    for (int i = 0; i < A.length; i++) {
      answer += A[A.length - i - 1] * B[i];
    }

    return answer;
  }

  public static void quickSort(int[] arr, int left, int right) {
    int i, j, pivot, tmp;

    if (left < right) {
      i = left;
      j = right;
      pivot = arr[left];
      //분할 과정
      while (i < j) {
        while (arr[j] > pivot) j--;
        while (i < j && arr[i] <= pivot) i++;

        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
      arr[left] = arr[i];
      arr[i] = pivot;

      quickSort(arr, left, i - 1);
      quickSort(arr, i + 1, right);
    }
  }

  @Test
  public void 정답() {
    Assertions.assertEquals(29, solution(new int[]{1, 4, 2}, new int[]{ 5, 4, 4}));
    Assertions.assertEquals(10, solution(new int[]{1, 2}, new int[]{ 3, 4}));
  }
}
