package practice.algorithm.leetcode.linear.priorityqueue;

import practice.algorithm.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

    ListNode root = new ListNode();
    ListNode tail = root;

    // 각 연결 리스트의 노드를 우선순위 큐에 저장
    for (ListNode node : lists) {
      if (node != null) {
        pq.add(node);
      }
    }

    // 큐가 비어질때 까지 반복
    while (!pq.isEmpty()) {
      // 우선순위에 따라 추출, 다음 노드로 이동
      tail.next = pq.poll();
      tail = tail.next;

      // 추출한 연결리스트의 다음 노드는 다시 큐에 저장
      if (tail.next != null) {
        pq.add(tail.next);
      }
    }

    return root.next;
  }
}
