package practice.algorithm.leetcode.linear.linkedlist;

import practice.algorithm.ListNode;

public class MergeTwoSortedLists_21 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // 두 노드 중 한쪽이 널이면 널이 아닌 노드 리턴
    if (list1 == null) {
      return list2;
    }

    if (list2 == null) {
      return list1;
    }

    // list2가 더 크면 list1에 재귀 호출을 결과를 엮고 list1 리턴
    if (list1.val < list2.val) {
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
    }
  }
}
