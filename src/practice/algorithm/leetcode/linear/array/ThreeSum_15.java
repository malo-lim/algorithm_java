package practice.algorithm.leetcode.linear.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
  public List<List<Integer>> threeSum(int[] nums) {
    int left, right, sum;
    List<List<Integer>> results = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      // 중복된 값은 건너뛰기
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      // 간격을 좁혀가면서 sum 계산
      left = i + 1;
      right = nums.length - 1;

      while (left < right) {
        sum = nums[i] + nums[left] + nums[right];

        // 합이 0보다 작으면 왼쪽 이동
        if (sum < 0) {
          left++;
        } else if (sum > 0) {
          right--;
        } else {
          // 합이 0이므로 정답처리
          results.add(List.of(nums[i], nums[left], nums[right]));

          // 중복된 값 건너 뛰기
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }

          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }

          // 정답이 나왔으므로 각 포인터들은 +1, -1해준다.
          left++;
          right--;
        }
      }
    }

    return results;
  }
}
