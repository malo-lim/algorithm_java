package practice.algorithm.leetcode.linear.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses_20 {
  public boolean isValid(String s) {
    // Deque로 선언한 이유는 Stack의 경우 1.2에 나왔으며 싱글 코어용이라서 문제가 됨.
    // 대신 Thread safe 하지 않으므로 Thread safe 는 ConcurrentDeque 로 선언해주면 된다.
    Deque<Character> stack = new ArrayDeque<>();

    // 비교를 위한 매핑 테이블
    Map<Character, Character> table = new HashMap<>() {{
      put(')', '(');
      put('}', '{');
      put(']', '[');
    }};

    for (int i = 0; i < s.length(); i++) {
      // 닫힘 괄호가 아닌 경우(즉 열림 괄호인 경우에만) 스택에 push
      if (!table.containsKey(s.charAt(i))) {
        stack.push(s.charAt(i));
        // 중간에 스택이 비거나 팝 결과가 열림 괄호가 아닌 경우 유효하지 않음
      } else if (stack.isEmpty() || table.get(s.charAt(i)) != stack.pop()) {
        return false;
      }
    }

    return stack.isEmpty();
  }
}
