package practice.algorithm.leetcode.linear.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      // target 에서 num을 뺀 값이 있다면 정답이므로 return
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      }

      // 키와 값을 바꿔서 저장
      map.put(nums[i], i);
    }

    return null;
  }
}
