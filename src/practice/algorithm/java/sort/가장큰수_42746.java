package practice.algorithm.java.sort;

import java.util.ArrayList;
import java.util.List;

public class 가장큰수_42746 {
  public String solution(int[] numbers) {
    List<String> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(String.valueOf(number));
    }

    list.sort(((o1, o2) -> {
      // 두 개의 값을 붙였을 때 큰 값을 비교
      int a = Integer.parseInt(o1 + o2);
      int b = Integer.parseInt(o2 + o1);
      // 두 개의 값을 붙였을 때 큰 값으로 내림차순
      return Integer.compare(b, a);
    }));

    StringBuilder sb = new StringBuilder();
    for (String s: list) {
      sb.append(s);
    }

    return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
  }
}
