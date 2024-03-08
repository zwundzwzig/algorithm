package combination;

import java.util.ArrayList;
import java.util.List;

public class Combination {

  // nums 배열에서 k개를 뽑아라
  public static List<List<Integer>> getCombinations(int[] nums, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    generateCombinations(nums, k, 0, combination, result);
    return result;
  }

  // 재귀적으로 조합을 생성하는 메서드
  private static void generateCombinations(int[] nums, int k, int start, List<Integer> combination, List<List<Integer>> result) {
    // 기저 사례: 조합의 크기가 k가 되면 결과에 추가하고 종료
    if (combination.size() == k) {
      result.add(new ArrayList<>(combination));
      return;
    }
    // 시작 인덱스부터 배열의 끝까지 반복
    for (int i = start; i < nums.length; i++) {
      // 현재 원소를 조합에 추가
      combination.add(nums[i]);
      // 다음 원소를 포함한 조합을 재귀적으로 생성
      generateCombinations(nums, k, i + 1, combination, result);
      // 백트래킹: 현재 원소를 제거하여 다른 조합을 만듦
      combination.remove(combination.size() - 1);
    }
  }

  // 테스트를 위한 메인 메서드
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    int k = 3;
    List<List<Integer>> combinations = getCombinations(nums, k);
    // 결과 출력
    for (List<Integer> combination : combinations) {
      System.out.println(combination);
    }
    System.out.println(combinations.size());
  }
}