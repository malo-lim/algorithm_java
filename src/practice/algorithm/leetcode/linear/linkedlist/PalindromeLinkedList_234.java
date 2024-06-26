package practice.algorithm.leetcode.linear.linkedlist;

import practice.algorithm.ListNode;

public class PalindromeLinkedList_234 {
  public boolean isPalindrome(ListNode head) {
    // stack, deque, runner 방법으로 풀 수 있다.
    // runner 방법으로 풀것이다.
    /*
    러너(Runner)는 연결리스트를 순회할 때 2개의 포인터를 동시에 사용하는 기법이다.
    한 포인터가 앞서게 하여 병합 지점이나 중간 위치, 길이 등을 판별할 때 유용하게 사용할 수 있다.
     */
    ListNode fast = head, slow = head;

    // 빠른 러너가 끝까지 갈 때까지 느린 러너와 함께 진행
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // 홀수 개 일때 느린 러너가 한칸 더 앞으로 가도록 처리
    if (fast != null) {
      slow = slow.next;
    }

    // 중간에 도달한 느린 러너를 기준으로 역순 연결 리스트를 만든다.
    ListNode rev = null;
    while (slow != null) {
      // 느린 러너로 역순 연결 리스트 rev를 만들어 나간다.
      ListNode next = slow.next;
      slow.next = rev;
      rev = slow;
      slow = next;
    }

    // rev 연결 리스트를 끝까지 비교하며 이동
    while (rev != null) {
      // 역순 연결 리스트 rev와 기존 연결 리스트 head를 차례대로 비교
      if (rev.val != head.val) {
        return false;
      }

      rev = rev.next;
      head = head.next;
    }

    return true;
  }
}
