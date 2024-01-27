package level_two;

public class 타겟넘버 {

  private int answer;

  public int solution(int[] numbers, int target) {

    dfs(numbers, target, 0, 0);

    return answer;
  }

  private void dfs(int[] numbers, int target, int index, int result) {

    if (index == numbers.length) {
      if (target == result) {
        answer++;
      }
    }

    dfs(numbers, target, index++, result + numbers[index]);
    dfs(numbers, target, index--, result - numbers[index]);
  }

}
