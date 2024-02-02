package level_2;

class 브루트포스_카펫 {
  public int[] solution(int brown, int yellow) {
    int sum = brown + yellow;

    for (int i = 3; i <= sum; i++) {
      int remainder = sum / i;

      if (sum % i == 0 && remainder >= 3) {
        int width = Math.max(i, remainder);
        int height = Math.min(i, remainder);

        if((height - 2) * (width - 2) == yellow)
          return new int[] {width, height};
      }
    }

    return null;
  }
}
