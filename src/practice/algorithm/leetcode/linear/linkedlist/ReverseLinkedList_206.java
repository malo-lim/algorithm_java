package practice.algorithm.leetcode.linear.linkedlist;

import practice.algorithm.ListNode;

public class ReverseLinkedList_206 {
  // 반복문으로 호출
  public ListNode reverseList(ListNode head) {
    ListNode prev = null, node = head;

    // 현재 노드가 null이 아닐 때 까지 진행
    while (node != null) {
      // 현재 노드의 다음 노드를 미리 지정
      ListNode next = node.next;

      // 현재 노드의 다음 노드를 이전 노드로 지정
      node.next = prev;

      // 전 노드는 현재 노드로 지정
      prev = node;

      // 미리 지정했던 다음 노드를 현재 노드로 변경
      node = next;
    }

    return prev;
  }

  // 재귀로 호출
  public static ListNode reverse(ListNode node, ListNode prev) {
    // reverse(head, null) 로 호출
    // 현재 노드가 null 이면 return
    if (node == null) {
      return prev;
    }

    // 현재 노드에 다음 노드 미리 지정
    ListNode next = node.next;

    // 현재 노드의 다음으로 이전 노드 지정
    node.next = prev;

    // 다음 노드와 현재 노드를 파라미터로 하여 재귀 호출
    return reverse(next, node);
  }

}
