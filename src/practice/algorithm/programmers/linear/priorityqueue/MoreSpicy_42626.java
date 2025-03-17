package practice.algorithm.programmers.linear.priorityqueue;

import java.util.PriorityQueue;

public class MoreSpicy_42626 {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int s: scoville) {
      pq.add(s);
    }

    while (pq.peek() < K) {
      if (pq.size() == 1) {
        return -1;
      }
      // 두 음식을 섞어서 새로운 음식을 만들어 삽입
      pq.add(pq.poll() + (pq.poll() * 2));
      answer++;
    }

    return answer;
  }
}
