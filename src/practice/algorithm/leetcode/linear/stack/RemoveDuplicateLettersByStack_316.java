package practice.algorithm.leetcode.linear.stack;

import java.util.*;

public class RemoveDuplicateLettersByStack_316 {

  public String removeDuplicateLetters(String s) {
    // 문자 개수를 계산해서 담아둘 변수 선언
    Map<Character, Integer> counter = new HashMap<>();
    // 이미 처리한 문자 여부를 확인하기 위한 변수 선언
    Map<Character, Boolean> seen = new HashMap<>();
    // 문제 풀이에 필요한 스택 변수 선언
    Deque<Character> stack = new ArrayDeque<>();

    // 문자별 개수 계산
    for (char c : s.toCharArray()) {
      counter.put(c, counter.getOrDefault(c, 0) + 1);
    }

    for (char c : s.toCharArray()) {
      // 현재 처리하는 문자는 counter 에서 -1 처리
      counter.put(c, counter.get(c) - 1);
      // 처리하지 않은 문자만 처리한다.
      // true를 붙인 이유는 seen 변수가 Boolean 변수인지 상기시키려고 집어넣었다.
      if (seen.get(c) == null || seen.get(c) == false) {
        // 스택에 있는 문자가 현재 문자보다 더 뒤에 붙여야할 문자라면 스택에서 제거하고 처리하지 않은걸로 표시
        while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
          seen.put(stack.pop(), false);
        }

        stack.push(c);
        seen.put(c, true);
      }
    }

    // 스택에 있는 문자를 큐 순서대로 추출하여 리턴
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pollLast());
    }

    return sb.toString();
  }
}
