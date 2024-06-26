package practice.algorithm.leetcode.linear.linkedlist;

import practice.algorithm.ListNode;

public class ReverseLinkedList2_92 {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null) {
      return null;
    }

    // 임시 노드 선언
    ListNode root = new ListNode(0);

    // 임시 노드 다음으로 노드 시작
    root.next = head;

    // 임시 노드로부터 시작해 변경 필요한 위치 앞으로 이동
    ListNode start = root;
    for (int i = 0; i < left - 1; i++) {
      start = start.next;
    }

    // 변경이 필요한 마지막 위치 선언
    ListNode end = start.next;

    // right - left 만큼 진행
    for (int i = 0; i < right - left; i++) {
      /*
      start.next로 한칸씩 이동하면서 결국에는 마지막 값이 온다.
      tmp = 2;
      2 = 3;
      3 = 4;
      3 = 2;
       */
      ListNode tmp = start.next; // 2
      start.next = end.next; // 2 = 3
      end.next = end.next.next; // 3 = 4
      start.next.next = tmp; // 3 = 2
    }

    // 첫 번째 노드는 임시 노드이므로 그 다음 노드 리턴
    return root.next;
  }
}
