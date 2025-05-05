package practice.algorithm.java.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class 폰켓몬_1845 {
  public int solution(int[] nums) {
    // nums 리스트에서 중복을 제거한 집합(set)을 구함
    HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

    // 폰켓몬의 총 수
    int n = nums.length;

    // 선택할 폰켓몬의 수
    int k = n / 2;

    // 중복을 제거한 폰켓몬의 종류 수와 선택할 폰켓몬의 수 중 작은 값 반환
    return Math.min(k, set.size());
  }

  public int solution2(int[] nums) {
    return Math.min(nums.length / 2, (int) Arrays.stream(nums).distinct().count());
  }
}
