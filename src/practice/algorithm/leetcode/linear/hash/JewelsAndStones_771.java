package practice.algorithm.leetcode.linear.hash;

import java.util.*;

public class JewelsAndStones_771 {

  // 해시 셋 이용
  public int numJewelsInStones(String jewels, String stones) {
    int count = 0;
    Set<Character> set = new HashSet<>();

    // 보석 종류 저장
    for (char jewel : jewels.toCharArray()) {
      set.add(jewel);
    }

    // 돌이 보석인 경우 + 1
    for (char stone : stones.toCharArray()) {
      if (set.contains(stone)) {
        count++;
      }
    }

    return count;
  }

  // 해시테이블 이용
  public int numJewelsInStonesByHashMap(String jewels, String stones) {
    int count = 0;
    Map<Character, Integer> freq = new HashMap<>();

    // 돌의 빈도수 계산
    for (char stone : stones.toCharArray()) {
      // 이미 계산한 돌이면 +1
      if (freq.containsKey(stone)) {
        freq.put(stone, freq.get(stone) + 1);
      } else {
        // 처음 보는 돌이면 1
        freq.put(stone, 1);
      }
    }

    System.out.println(freq);

    // 보석의 빈도수 합산
    for (char jewel : jewels.toCharArray()) {
      // 보석과 일치하는 돌의 개수를 합산
      if (freq.containsKey(jewel)) {
        count += freq.get(jewel);
      }
    }

    return count;
  }
}
