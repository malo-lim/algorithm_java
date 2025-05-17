package practice.algorithm.java.search;

public class 네트워크_43162 {

  private static boolean[] visited;
  private static int[][] computer;

  private void dfs(int now) {
    visited[now] = true;

    for (int i = 0; i < computer[now].length; i++) {
      if (computer[now][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

  public int solution(int n, int[][] computers) {
    int answer = 0;

    // 모든 요소를 탐색하기 때문에 dfs로 구현했다.
    visited = new boolean[n];
    computer = computers;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i);
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    네트워크_43162 main = new 네트워크_43162();
    int params1 = 3;
    int[][] params2 = new int[][]{{1, 1, 0}, {1, 1, 0},{0, 0, 1}};

    int result = main.solution(params1, params2);
    System.out.println(result);
  }
}
