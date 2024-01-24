package level_one;

public class 붕대감기 {
  public int solution(int[] bandage, int health, int[][] attacks) {
    int maxHp = health;
    int count = 0;
    int nextAtk = 0;

    for(int t = 1; t <= attacks[attacks.length - 1][0]; t++) {
      if(t == attacks[nextAtk][0]) {
        health -= attacks[nextAtk++][1];
        count = 0;

        if(health <= 0) return -1;
      }
      else {
        health += bandage[1];
        count++;

        if(count == bandage[0]) {
          health += bandage[2];
          count = 0;
        }

        if(health > maxHp) health = maxHp;
      }
    }

    return health;
  }
}
