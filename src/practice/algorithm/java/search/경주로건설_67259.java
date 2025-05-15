package practice.algorithm.java.search;

import practice.algorithm.Main;

import java.util.ArrayDeque;
import java.util.Queue;

public class 경주로건설_67259 {
  private static class Node {
    int x, y, direction, cost;

    public Node(int x, int y, int direction, int cost) {
      this.x = x;
      this.y = y;
      this.direction = direction;
      this.cost = cost;
    }
  }

  // 순서는 반드시 다음과 같이 해야 한다. (상, 좌, 하, 우)
  private static final int[] rx = {0, -1, 0, 1};
  private static final int[] ry = {-1, 0, 1, 0};
  private static int N;
  private static int[][][] visited;

  // 1. 주어진 좌표가 보드의 범위 내에 있는지 확인
  private boolean isValid(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }

  // 2. 주어진 좌표가 차단되었거나 이동할 수 없는지 확인
  private boolean isBlocked(int[][] board, int x, int y) {
    // 첫번째는 시작점 재방문 인지, 두번째는 범위 내에 들어오지 않는지, 세번째는 벽에 막힌건지 확인한다.
    return (x == 0 && y == 0) || !isValid(x, y) || board[x][y] == 1;
  }

  // 3. 이전 방향과 현재 방향에 따라 비용 계산
  private int calculateCost(int direction, int prevDirection, int cost) {
    if (prevDirection == -1 || (prevDirection - direction) % 2 == 0) {
      return cost + 100;
    } else {
      return cost + 600;
    }
  }

  // 4. 주어진 좌표와 방향이 아직 방문하지 않았거나 새 비용이 더 작은 경우
  private boolean isShouldUpdate(int x, int y, int direction, int newCost) {
    return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
  }

  public int solution(int[][] board) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0, 0, -1, 0));
    N = board.length;
    visited = new int[N][N][4];

    int answer = Integer.MAX_VALUE;

    // 5. 큐가 빌때까지 탐색
    while (!queue.isEmpty()) {
      Node now = queue.poll();

      // 6. 4방향 탐색
      for (int i = 0; i < 4; i++) {
        int nx = now.x + rx[i];
        int ny = now.y + ry[i];

        // 7. 이동할 수 없는 좌표는 건너뛰기
        if (isBlocked(board, nx, ny)) {
          continue;
        }

        int newCost = calculateCost(i, now.direction, now.cost);

        // 8. 도착지에 도달한 경우 최소 비용 업데이트
        if (nx == N - 1 && ny == N - 1) {
          answer = Math.min(answer, newCost);
        } else if (isShouldUpdate(nx, ny, i, newCost)) {
          queue.add(new Node(nx, ny, i, newCost));
          visited[nx][ny][i] = newCost;
        }
      }
    }

    return answer;
  }
}
