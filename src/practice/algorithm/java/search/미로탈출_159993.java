package practice.algorithm.java.search;

import practice.algorithm.Main;

import java.util.ArrayDeque;

public class 미로탈출_159993 {

  // 위치 정보를 저장할 클래스 생성
  private static class Point {
    int nx, ny;

    public Point(int nx, int ny) {
      this.nx = nx;
      this.ny = ny;
    }
  }

  private int N;
  private int M;
  private char[][] map;

  public int solution(String[] maps) {
    int answer = -1;
    N = maps.length;
    M = maps[0].length();

    // 미로에 대한 정보를 배열로 저장
    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = maps[i].toCharArray();
    }

    Point start = null, end = null, lever = null;

    // 시작 지점, 출구, 그리고 레버의 위치를 찾음
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'S') {
          start = new Point(i, j);
        } else if (map[i][j] == 'L') {
          lever = new Point(i, j);
        } else if (map[i][j] == 'E') {
          end = new Point(i, j);
        }
      }
    }

    // 시작 지점 -> 레버, 레버 -> 출구 까지의 최단 거리를 각각 구함
    int startLever = bfs(start, lever);
    int leverEnd = bfs(lever, end);

    // 도착 불가능한 경우는 -1, 도착 가능한 경우는 최단 거리를 반환
    if (startLever != -1 && leverEnd != -1) {
      answer = startLever + leverEnd;
    }

    return answer;
  }

  // start -> end로 너비 우선 탐색하여 최단거리 반환
  private int bfs(Point start, Point end) {
    // 좌, 우 배열
    int[] dx = {0, 0, -1, 1};
    // 상, 하 배열
    int[] dy = {-1, 1, 0, 0};
    int[][] visited = new int[N][M];
    ArrayDeque<Point> queue = new ArrayDeque<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      Point now = queue.poll();

      if (now.nx == end.nx && now.ny == end.ny) {
        return visited[now.nx][now.ny];
      }

      // 네방향 탐색
      for (int i = 0; i < 4; i++) {
        int nx = now.nx + dx[i];
        int ny = now.ny + dy[i];

        // 범위를 벗어나지 않는 곳만 탐색
        // 미로의 범위 밖, 벽, 이미 방문한 경우 생략
        if (nx >= 0 && nx < N && ny >= 0 && ny < M
            && map[nx][ny] != 'X' && visited[nx][ny] == 0) {
          // 이동 거리 +1
          visited[nx][ny] = visited[now.nx][now.ny] + 1;
          queue.add(new Point(nx, ny));
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    미로탈출_159993 main = new 미로탈출_159993();
    String[] params1 = new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
    //String[] params1 = new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
    //int[][] params2 = new int[][]{{1, 1, 0}, {1, 1, 0},{0, 0, 1}};

    int result = main.solution(params1);
    System.out.println(result);
  }

}
