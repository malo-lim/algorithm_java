package practice.algorithm.leetcode.linear.queue;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateLettersByRecursion_316 {

  public Set<Character> toSortedSet(String s) {
    // 문자열을 문자 단위 집합으로 저장할 변수 선언하면서, 오름차순 정렬로 들어가게 만든다.
    // HashSet으로 하지 않은 이유는 정렬이 안되기 때문이다.
    Set<Character> set = new TreeSet<>(Character::compareTo);

    // 문자열을 문자 단위로 집합에 저장, 즉 정렬된 상태로 저장된다.
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
    }

    return set;
  }

  public String removeDuplicateLetters(String s) {
    // 정렬된 문자열 집합 순회
    for (char c : toSortedSet(s)) {
      // 해당 문자가 포함된 위치부터 접미사로 지정
      String suffix = s.substring(s.indexOf(c));

      // 전체 집합과 접미사 집합이 일치하면 해당 문자 정답에 추가하고 재귀 호출 진행
      if (toSortedSet(s).equals(toSortedSet(suffix))) {
        return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
      }
    }

    return "";
  }
}
