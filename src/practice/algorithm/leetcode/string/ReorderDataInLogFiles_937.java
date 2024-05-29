package practice.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class ReorderDataInLogFiles_937 {
  public String[] reorderLogFiles(String[] logs) {
    List<String> letterList = new ArrayList<>();
    List<String> digitList = new ArrayList<>();

    // 숫자 리스트와 문자 리스트로 분리
    for (String log: logs) {
      if (Character.isDigit(log.split(" ")[1].charAt(0))) {
        digitList.add(log);
      } else {
        letterList.add(log);
      }
    }

    // 정렬 하는데, 조건에 맞게
    letterList.sort((s1, s2) -> {
      // 식별자와 식별자가 아닌 나머지 문자들 분리
      String[] s1x = s1.split(" ", 2);
      String[] s2x = s2.split(" ", 2);

      // 문자열 비교
      int compared = s1x[1].compareTo(s2x[1]);

      // 문자가 같다면 식별자 비교
      if (compared == 0) {
        return s1x[0].compareTo(s2x[0]);
      }

      return compared;
    });

    letterList.addAll(digitList);

    return letterList.toArray(new String[0]);
  }
}
