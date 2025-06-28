package practice.algorithm.java.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 귤고르기_138476 {
  public int solution(int k, int[] tangerine) {
    HashMap<Integer, Integer> countMap = new HashMap<>();
    int answer = 0;
    int remain = k;

    for (int j : tangerine) {
      countMap.put(j, countMap.getOrDefault(j, 0) + 1);
    }

    ArrayList<Integer> list = new ArrayList<>(countMap.values());
    list.sort(Collections.reverseOrder());

    for (Integer value : list) {
      if (remain <= 0) {
        break;
      }

      remain -= value;
      answer++;
    }

    return answer;
  }
}
