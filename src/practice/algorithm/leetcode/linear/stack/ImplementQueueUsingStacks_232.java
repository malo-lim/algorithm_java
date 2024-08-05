package practice.algorithm.leetcode.linear.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks_232 {
  private Deque<Integer> input = new ArrayDeque<>();
  private Deque<Integer> output = new ArrayDeque<>();

  public void push(int x) {
    input.push(x);
  }

  public int pop() {
    peek();
    return output.pop();
  }

  public int peek() {
    // 추출 스택에 저장된 게 없다면 진행
    if (output.isEmpty()) {
      while (!input.isEmpty()) {
        // 삽입 스택이 비워질 때까지 진행
        output.push(input.pop());
      }
    }
    // 가장 나중에 삽입된 결과 조회
    return output.peek();
  }

  public boolean empty() {
    // 두 스택이 모두 비어야 비어있는것으로 처리한다.
    return input.isEmpty() && output.isEmpty();
  }
}
