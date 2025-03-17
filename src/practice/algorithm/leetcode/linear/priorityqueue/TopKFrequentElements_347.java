package practice.algorithm.leetcode.linear.priorityqueue;

import java.util.*;

public class TopKFrequentElements_347 {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    // 빈도수 저장
    for (int num: nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // 빈도순으로 정렬되는 우선순위 큐 선언
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

    // 우선순위 큐에 각 엘리먼트와 빈도수 삽입
    for (int elem: frequencyMap.keySet()) {
      pq.add(new int[]{elem, frequencyMap.get(elem)});
    }

    // 결과로 리턴할 변수 선언
    int[] result = new int[k];

    // k번까지만 반복하여 우선순위 큐에서 결과 추출
    for (int i = 0; i < k; i++) {
      result[i] = pq.poll()[0];
    }

    return result;
  }
}
