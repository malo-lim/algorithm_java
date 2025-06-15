package practice.algorithm.java.sort;

public class 계수정렬구현 {
  public String solution(String s) {
    int[] result = new int[26];

    for (char c: s.toCharArray()) {
      result[c - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (result[i] > 0) {
        for (int j = 0; j < result[i]; j++) {
          sb.append((char) ('a' + i));
        }
      }
    }

    return sb.toString();
  }
}
