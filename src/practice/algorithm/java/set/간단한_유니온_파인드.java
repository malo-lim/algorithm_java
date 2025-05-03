package practice.algorithm.java.set;

import java.util.ArrayList;
import java.util.List;

public class 간단한_유니온_파인드 {
  // 부모 저장을 위한 배열
  private static int[] parent;

  // 루트 노드를 찾는 메서드
  private int find(int x) {
    // 만약 x의 부모가 자기 자신이면, 즉 x가 루트 노드라면 x를 반환
    if (parent[x] == x) {
      return x;
    }

    // 그렇지 않다면 x의 부모를 찾아서 parent[x]에 저장한다.
    parent[x] = find(parent[x]);
    return parent[x]; // 찾은 루트 노드를 반환
  }

  private void union(int x, int y) {
    int root1 = find(x); // x가 속한 집합의 루트 노드 찾기
    int root2 = find(y); // y가 속한 집합의 루트 노드 찾기
    parent[root2] = root1; // y가 속한 집합을 x가 속한 집합에 합침
  }

  public Boolean[] solution(int k, int[][] operations) {
    // 노드의 수 만큼 배열 생성
    parent = new int[k];

    // 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
    for (int i = 0; i < k; i++) {
      parent[i] = i;
    }

    List<Boolean> answer = new ArrayList<>();

    for (int[] op: operations) {
      if (op[0] == 0) {
        // 0 연산이면
        union(op[1], op[2]);
      } else {
        // 1 연산이면
        answer.add(find(op[1]) == find(op[2]));
      }
    }

    return answer.toArray(new Boolean[0]);
  }
}
