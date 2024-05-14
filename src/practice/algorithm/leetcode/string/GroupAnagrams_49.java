package practice.algorithm.leetcode.string;

import java.util.*;

public class GroupAnagrams_49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> results = new HashMap<>();

    for (String s: strs) {
      // 애너그램 판단하기 위해 단어를 문자 하나씩 쪼개서 정렬한다.
      char[] chars = s.toCharArray();
      Arrays.sort(chars);

      // key가 동일한 값을 map에 집어넣기 위해 charArray -> String으로 변환한다.
      String key = String.valueOf(chars);

      // key 존재하지 않으면 초기화
      if (!results.containsKey(key)) {
        results.put(key, new ArrayList<>());
      }

      // 해당하는 key에 값을 집어 넣는다.
      results.get(key).add(s);
    }

    return new ArrayList<>(results.values());
  }
}
