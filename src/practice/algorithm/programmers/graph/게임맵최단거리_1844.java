package practice.algorithm.programmers.graph;

import java.util.ArrayDeque;

public class 게임맵최단거리_1844 {
  // 좌, 우 배열
  private static final int[] dx = {0, 0, -1, 1};

  // 상, 하 배열
  private static final int[] dy = {-1, 1, 0, 0};

  private static class Node {
    int row, col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public int solution(int[][] maps) {
    int rowSize = maps.length;
    int colSize = maps[0].length;

    // 거리를 저장할 배열 생성
    int[][] dist = new int[rowSize][colSize];

    // 큐 생성
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0, 0));
    dist[0][0] = 1;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int row = now.row + dx[i];
        int col = now.col + dy[i];

        // 상하좌우로 움직일 수 있을때만
        if (row >= 0 && row < rowSize && col >= 0 && col < colSize) {
          // 벽이 아니면서 거리가 0인 경우만 방문
          if (maps[row][col] == 1 && dist[row][col] == 0) {
            queue.add(new Node(row, col));
            dist[row][col] = dist[now.row][now.col] + 1;
          }
        }
      }
    }

    return dist[rowSize - 1][colSize - 1] == 0 ? -1 : dist[rowSize - 1][colSize - 1];
  }
}
