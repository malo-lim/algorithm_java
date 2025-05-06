package practice.algorithm.java.set;

import java.util.HashSet;

public class 영어끝말잇기_12981 {
  public int[] solution(int n, String[] words) {
    HashSet<String> usedWords = new HashSet<>();
    // 이전 단어의 마지막 글자, 최초 상태는 첫 번째 사람이 말하는 첫 번째 글자로 초기화
    char prevWord = words[0].charAt(0);

    for (int i = 0; i < words.length; i++) {
      // 이미 사용한 단어이거나 첫 글자가 이전 단어와 일치하지 않으면
      if (usedWords.contains(words[i])
          || words[i].charAt(0) != prevWord) {
        return new int[]{(i % n) + 1, (i / n) + 1};
      }
      usedWords.add(words[i]);
      prevWord = words[i].charAt(words[i].length() - 1);
    }

    // 모두 통과했을 경우 반환 값
    return new int[]{0, 0};
  }
}
