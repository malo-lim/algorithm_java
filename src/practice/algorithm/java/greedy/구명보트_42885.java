package practice.algorithm.java.greedy;

import java.util.Arrays;

public class 구명보트_42885 {
  public int solution(int[] people, int limit) {
    // 1. 가장 무게가 무거운 사람 + 가장 무게가 가벼운 사람
    // 2. 가장 무거운 사람 순으로 태운다.
    Arrays.sort(people);
    int answer = 0;
    // 가장 무거운, 가벼운 사람 인덱스
    int minPeople = 0;
    int maxPeople = people.length - 1;

    while (minPeople <= maxPeople) {
      if (people[minPeople] + people[maxPeople] <= limit) {
        minPeople++;
      }
      maxPeople--;
      answer++;
    }

    return answer;
  }
}
