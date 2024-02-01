package sort.quick_sort;

public class LeftPivotQuickSort {
  public static void sort(int[] a) {
    qsort(a, 0, a.length - 1);
  }

  private static void qsort(int[] a, int small, int big) {

    if (small >= big) return; // 왼쪽이 오른쪽보다 커지면, 재귀 종료

    int pivot = partition(a, small, big);

    qsort(a, small, pivot - 1);
    qsort(a, pivot + 1, big);
  }


  private static int partition(int[] a, int left, int right) {
    int small = left;
    int big = right;
    int pivot = a[left];

    while(small < big) {
      while(a[big] > pivot) --big;
      while(a[small] <= pivot && small < big) ++small;

      swap(a, small, big);
    }

    swap(a, left, small);

    return small;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
