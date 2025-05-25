package practice.algorithm.java.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 지형이동_62050 {
  private static class Node {
    int i, j, cost;

    public Node(int i, int j, int cost) {
      this.i = i;
      this.j = j;
      this.cost = cost;
    }
  }

  public int solution(int[][] land, int height) {
    int answer = 0;
    int[] di = {-1, 1, 0, 0};
    int[] dj = {0, 0, -1, 1};
    int n = land.length;
    boolean[][] visited = new boolean[n][n];

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    // 0, 0 부터 시작
    pq.add(new Node(0, 0, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (!visited[now.i][now.j]) {
        visited[now.i][now.j] = true;
        answer += now.cost;

        // 방향 탐색
        for (int i = 0; i < 4; i++) {
          int ni = now.i + di[i];
          int nj = now.j + dj[i];

          if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
            // 비용 계산
            int tempCost = Math.abs(land[now.i][now.j] - land[ni][nj]);
            int newCost = tempCost > height ? tempCost : 0;
            pq.add(new Node(ni, nj, newCost));
          }
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    지형이동_62050 main = new 지형이동_62050();
    int[][] params1 = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
    //int[][] params1 = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
    /*int[][] params2 = new int[][]{
        {80, 20}, {50, 40}, {30, 10}
    };*/
    int params2 = 3;

    int result = main.solution(params1, params2);
    System.out.println(result);
  }
}
