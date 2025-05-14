package practice.algorithm.java.search;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 게임_맵_최단거리_1844 {

  private static class Node {
    int row, col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  // 좌, 우 배열
  private static int[] rx = {0, 0, -1, 1};
  // 상, 하 배열
  private static int[] ry = {-1, 1, 0, 0};

  public int solution(int[][] maps) {
    int rowSize = maps.length;
    int colSize = maps[0].length;

    // 거리를 저장할 배열
    int[][] dist = new int[rowSize][colSize];

    // 큐 처음 초기화
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0, 0));
    dist[0][0] = 1;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      // 4방향 탐색
      for (int i = 0; i < 4; i++) {
        int row = now.row + rx[i];
        int col = now.col + ry[i];

        // 4방향으로 움직일 수 있는 경우에만
        if (row >= 0 && row < colSize && col >= 0 && col < colSize) {
          // 벽이 아니면서, 처음 방문한 곳인 경우
          if (maps[row][col] == 1 && dist[row][col] == 0) {
            queue.add(new Node(row, col));
            dist[row][col] = dist[now.row][now.col] + 1;
          }
        }
      }
    }

    // 결국 마지막에 갱신이 될 텐데, 마지막을 방문하지 못했으면 탐색이 안되는 것이므로 -1 리턴
    return dist[rowSize - 1][colSize - 1] == 0 ? -1 : dist[rowSize - 1][colSize - 1];
  }

  public static void main(String[] args) {
    게임_맵_최단거리_1844 main = new 게임_맵_최단거리_1844();
    //int[][] params1 = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
    int[][] params1 = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

    int result = main.solution(params1);
    System.out.println(result);
  }
}
