package practice.algorithm.leetcode.linear.linkedlist;

import practice.algorithm.ListNode;

public class OddEvenLinkedList_328 {
  public ListNode oddEvenList(ListNode head) {
    // 예외 처리
    if (head == null) {
      return null;
    }

    // 홀수 노드
    ListNode odd = head;
    // 짝수 노드
    ListNode even = head.next;
    // 짝수 첫번째 노드
    ListNode evenHead = even;

    // 반복하면서 홀 짝 노드 처리
    while (even != null && even.next != null) {
      // 홀짝 노드의 다음노드를 다음다음 노드로 지정
      odd.next = odd.next.next;
      even.next = even.next.next;

      // 홀짝 한칸씩 이동
      odd = odd.next;
      even = even.next;
    }

    // 결국 여기서는 홀수 노드는 마지막 노드에 있을거고, 홀수 노드 마지막을 짝수 첫번째와 연결
    odd.next = evenHead;

    // 첫 번째 노드 리턴
    return head;
  }
}
