package practice.algorithm.leetcode.linear.queue;

public class DesignCircularQueue_622 {
  // 원형(환형) 큐를 만든다.
  int[] queue;
  int front = 0, rear = -1, len = 0;

  public DesignCircularQueue_622(int k) {
    this.queue = new int[k];
  }

  public boolean enQueue(int value) {
    if (!this.isFull()) {
      // rear 포인터를 한칸 앞으로 이동하고 해당 위치에 현재 값을 넣는다.
      this.rear = (this.rear + 1) % this.queue.length; // 전체 길이만큼 모듈러 연산하여 길이를 벗어나지 않게 한다.
      this.queue[rear] = value;
      this.len++;
      return true;
    } else {
      return false;
    }
  }

  public boolean deQueue() {
    if (!this.isEmpty()) {
      // front 포인터를 한칸 앞으로 이동하고 현재 큐의 길이를 1 빼준다
      this.front = (this.front + 1) % this.queue.length; // 전체 길이만큼 모듈러 연산하여 길이를 벗어나지 않게 한다.
      this.len--;
      return true;
    } else {
      return false;
    }
  }

  public int Front() {
    return (this.isEmpty()) ? -1 : this.queue[this.front];
  }

  public int Rear() {
    return (this.isEmpty()) ? -1 : this.queue[this.rear];
  }

  public boolean isEmpty() {
    // 현재 큐의 크기가 0 이면 비어 있는 상태
    return this.len == 0;
  }

  public boolean isFull() {
    // 현재 큐의 크기가 전체 큐의 크기와 일치하면 꽉 차있는 상태
    return this.queue.length == this.len;
  }
}
