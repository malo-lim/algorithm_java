package practice.algorithm.leetcode.linear.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {
  // 큐 변수이며, 구현체는 LinkedList로 구현한다.
  // 큐로 스택을 구현한다.
  Queue<Integer> queue = new LinkedList<>();

  public ImplementStackUsingQueues_225() {

  }

  public void push(int x) {
    queue.add(x);
    // 맨앞에 두는 상태로 재정렬
    for (int i = 1, size = queue.size(); i < size; i++) {
      queue.add(queue.remove());
    }
  }

  public int pop() {
    // 재 정렬한 상태이므로 큐 연산으로 추출
    return queue.remove();
  }

  public int top() {
    // 재 정렬한 상태이므로 큐 연산으로 조회
    return queue.peek();
  }

  public boolean empty() {
    return queue.isEmpty();
  }
}
