package practice.algorithm.programmers.linear.hash;

import java.util.HashMap;
import java.util.Map;

public class PlayersWhoCouldNotParticipate_42576 {
  public String solution(String[] participant, String[] completion) {
    String answer = "";
    Map<String, Integer> map = new HashMap<>();

    for (String p : participant) {
      map.put(p, map.getOrDefault(p, 0) + 1);
    }

    for (String c : completion) {
      int count = map.get(c);

      if (count == 1) {
        map.remove(c);
      } else {
        map.put(c, count - 1);
      }
    }

    answer = map.entrySet().iterator().next().getKey();
    return answer;
  }
}
