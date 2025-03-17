package practice.algorithm.leetcode.linear.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    // 빈도수 저장
    for (int num: nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // 빈도수 기준으로 각 엘리먼트를 저장
    Map<Integer, List<Integer>> buckets = new HashMap<>();

    // 각 엘리먼트를 반복하며 빈도수를 키로 저장
    for (int element: frequencyMap.keySet()) {
      int frequency = frequencyMap.get(element);
      // 빈도수에 해당하는 엘리먼트가 존재하지 않으면 빈 리스트 생성
      List<Integer> elementList = buckets.getOrDefault(frequency, new ArrayList<>());

      // 저장할 값에 엘리먼트 추가
      elementList.add(element);
      // 빈도수를 키로, 값을 엘리먼트로 저장
      buckets.put(frequency, elementList);
    }

    // 결과로 리턴할 변수 선언
    int[] result = new int[k];
    int index = 0;

    // 전체 엘리먼트 수에서 하나씩 내려가면서 해당하는 빈도의 엘리먼트 추출
    for (int frequency = nums.length; frequency >= 0 && index < k; frequency--) {
      // 해당 빈도에 값이 존재한다면 엘리먼트를 결과 변수에 삽입
      if (buckets.get(frequency) != null) {
        // 해당 빈도에 여러 엘리먼트가 있을 수 있으므로 반복하여 모두 삽입
        for (int elem: buckets.get(frequency)) {
          result[index] = elem;
          index++;
        }
      }
    }

    return result;
  }
}
