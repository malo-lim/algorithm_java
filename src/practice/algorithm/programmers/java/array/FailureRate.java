package practice.algorithm.programmers.java.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FailureRate {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
  }

  public static int[] solution(int N, int[] stages) {
    // 1. 스테이지별 도전자 수를 구함
    int[] challenger = new int[N + 2];
    for (int stage : stages) {
      challenger[stage]++;
    }

    // 2. 스테이지별 실패한 사용자 수 계산
    HashMap<Integer, Double> fails = new HashMap<>();
    double total = stages.length;

    // 3. 각 스테이지를 순회하며, 실패율 계산
    for (int i = 1; i <= N; i++) {
      if (challenger[i] == 0) { // 4. 도전한 사람이 없는 경우 실패율은 0
        fails.put(i, 0.);
      } else {
        fails.put(i, challenger[i] / total); // 5. 실패율 구함
        total -= challenger[i]; // 6. 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
      }
    }

    // 7. 실패율이 높은 스테이지부터 내림차순 정렬 (실패율이 같으면 스테이지 번호 낮은 순)
    return fails.entrySet()
        .stream()
        .sorted((o1, o2)
            -> o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey())
            : Double.compare(o2.getValue(), o1.getValue()))
        .mapToInt(Map.Entry::getKey).toArray();
  }
}
