package practice.algorithm.java.greedy;

import java.util.ArrayList;
import java.util.List;

public class 거스름돈주기 {
  public int[] solution(int amount) {
    int[] coins = {100, 50, 10, 1};
    List<Integer> result = new ArrayList<>();

    for (int coin : coins) {
      while (amount >= coin) {
        result.add(coin);
        amount -= coin;
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
