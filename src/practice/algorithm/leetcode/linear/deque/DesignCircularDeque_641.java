package practice.algorithm.leetcode.linear.deque;

public class DesignCircularDeque_641 {
  // 원형 데크를 이중 연결 리스트로 구현이 가능하다는 것을 구현한 것.
  /*
    원래는 배열로 문제를 풀어야 한다.
    연결 리스트는 애초에 빈 공간이라는 개념이 존재하지 않기 때문에 원형의 의미가 없어서 그렇다.
   */
  static class DoublyLinkedList {
    // 왼쪽으로 연결할 이중 연결 리스트
    DoublyLinkedList left;
    // 오른쪽으로 연결할 이중 연결 리스트
    DoublyLinkedList right;
    int val;

    public DoublyLinkedList(int val) {
      this.val = val;
    }
  }

  int len; // 현재 큐의 크기
  int k; // 큐의 전체 크기
  DoublyLinkedList head;
  DoublyLinkedList tail;

  public DesignCircularDeque_641(int k) {
    head = new DoublyLinkedList(0);
    tail = new DoublyLinkedList(0);

    // 서로 연결
    head.right = tail;
    tail.left = head;

    // 전체 큐의 크기 지정
    this.k = k;
    // 현재 큐의 크기 지정
    this.len = 0;
  }

  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    } else {
      DoublyLinkedList node = new DoublyLinkedList(value);
      // 신규 노드는 head 바로 오른쪽에 삽입
      node.right = head.right;
      node.left = head;
      head.right.left = node;
      head.right = node;
      len++;
      return true;
    }
  }

  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    } else {
      DoublyLinkedList node = new DoublyLinkedList(value);
      // 신규 노드는 tail 바로 왼쪽에 삽입
      node.left = tail.left;
      node.right = tail;
      tail.left.right = node;
      tail.left = node;
      len++;
      return true;
    }
  }

  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    } else {
      // head 바로 오른쪽 노드를 연결에서 끊음
      head.right.right.left = head;
      head.right = head.right.right;
      len--;
      return true;
    }
  }

  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    } else {
      // tail 바로 왼쪽 노드를 연결에서 끊음
      tail.left.left.right = tail;
      tail.left = tail.left.left;
      len--;
      return true;
    }
  }

  public int getFront() {
    // 맨 앞(head 오른쪽)의 값을 가져온다
    return (isEmpty()) ? -1 : head.right.val;
  }

  public int getRear() {
    // 맨 뒤(tail 왼쪽)의 값을 가져온다
    return (isEmpty()) ? -1 : tail.left.val;
  }

  public boolean isEmpty() {
    return len == 0;
  }

  public boolean isFull() {
    return len == k;
  }
}
