package practice.algorithm.java.set;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기_42861 {
  private static int[] parent;

  private int find(int x) {
    // x가 속한 집합의 루트 노드 찾기
    if (parent[x] == x) {
      return x;
    }

    // 경로 압축 : x의 부모를 루트로 설정
    return parent[x] = find(parent[x]);
  }

  private void union(int x, int y) {
    int root1 = find(x);
    int root2 = find(y);
    parent[root2] = root1; // y가 속한 집합을 x가 속한 집합에 합침
  }

  public int solution(int n, int[][] costs) {
    // 4. 비용을 기준으로 다리를 오름차순 정렬
    Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

    // 5. parent 배열 초기화
    parent = new int[n];
    // 자기 자신으로 초기화
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    int answer = 0; // 최소 신장 트리의 총 비용
    int edges = 0; // 연결된 다리의 수

    for (int[] edge : costs) {
      // 6. n - 1개의 다리가 연결된 경우 모든 섬이 연결됨
      if (edges == n - 1) {
        break;
      }

      // 7. 현재 다리가 연결하는 두 섬이 이미 연결되어 있는지 확인
      if (find(edge[0]) != find(edge[1])) {
        // 8. 두 섬을 하나의 집합으로 연결함
        union(edge[0], edge[1]);
        // 9. 현재 다리의 건설 비용을 총 비용에 추가
        answer += edge[2];
        // 10. 사용된 다리의 수 1 증가
        edges++;
      }
    }

    return answer;
  }
}
