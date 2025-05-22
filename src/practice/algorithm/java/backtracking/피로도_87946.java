package practice.algorithm.java.backtracking;

public class 피로도_87946 {

  private int answer;
  private boolean[] visited;

  private void backtrack(int[][] dungeons, int k, int count) {
    for (int i = 0; i < dungeons.length; i++) {
      if (!visited[i] && k >= dungeons[i][0]) {
        visited[i] = true;
        backtrack(dungeons, k - dungeons[i][1], count + 1);
        // 방문했던곳은 다시 초기화(또 방문 해야하니까)
        visited[i] = false;
      }
    }
    answer = Math.max(answer, count);
  }

  public int solution(int k, int[][] dungeons) {
    answer = 0;
    visited = new boolean[dungeons.length];
    backtrack(dungeons, k, 0);

    return answer;
  }

  public static void main(String[] args) {
    피로도_87946 main = new 피로도_87946();
    int params1 = 80;
    int[][] params2 = new int[][]{
        {80, 20}, {50, 40}, {30, 10}
    };
    //int params3 = 3;

    int result = main.solution(params1, params2);
    System.out.println(result);
  }
}
