package practice.algorithm.leetcode.string;

import java.util.*;

public class MostCommonWord_819 {
  public String mostCommonWord(String paragraph, String[] banned) {
    String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

    Map<String, Integer> counts = new HashMap<>();
    Set<String> ban = new HashSet<>(Arrays.asList(banned));

    for (String word: words) {
      if (!ban.contains(word)) {
        counts.put(word, counts.getOrDefault(word, 0) + 1);
      }
    }

    return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
  }
}
