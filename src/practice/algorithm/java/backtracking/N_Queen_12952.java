package practice.algorithm.java.backtracking;

public class N_Queen_12952 {

  private int N;
  private boolean[] width;
  private boolean[] diagonal1;
  private boolean[] diagonal2;

  // 퀸이 서로 공격할 수 없는 위치에 놓이는 경우의 수를 구하는 메서드
  public int backtrack(int y) {
    int answer = 0;

    // 모든 행에 대해서 퀸의 위치가 결정 되었을 경우
    if (y == N) {
      // 해결 가능한 경우의 수를 1 증가 시킴
      answer++;
    } else {
      // 현재 행에서 퀸이 놓일 수 있는 모든 위치를 시도
      for (int i = 0; i < N; i++) {
        // 해당 위치에 이미 퀸이 없으면서, 대각선상에 퀸이 있는 없는 경우
        /*
         width[i] : 같은 열
         diagonal1[i + y] : 좌상향 대각선(↙↗)
         diagonal2[i - y + N] : 우상향 대각선(↖↘)
         대각선 인덱스 계산 원리
         - 좌상향 대각선(↙↗): 같은 대각선의 모든 칸은 행 + 열 값이 동일
           예: (0,2), (1,1), (2,0) → 모두 0+2 = 1+1 = 2+0 = 2

         - 우상향 대각선(↖↘): 같은 대각선의 모든 칸은 열 - 행 + N 값이 동일
           예: (0,1), (1,2), (2,3) → 1-0 + 4 = 2-1 + 4 = 3-2 + 4 = 5 (N=4일 때)
         */
        if (!(width[i] || diagonal1[i + y] || diagonal2[i - y + N])) {
          // 해당 위치에 퀸을 놓음
          width[i] = diagonal1[i + y] = diagonal2[i - y + N] = true;
          // 다음 행으로 이동하여 재귀적으로 해결 가능한 경우의 수를 찾기
          answer += backtrack(y + 1);
          // 해당 위치에 놓인 퀸을 제거함
          width[i] = diagonal1[i + y] = diagonal2[i - y + N] = false;
        }
      }
    }

    return answer;
  }

  public int solution(int n) {
    N = n;
    width = new boolean[n];
    diagonal1 = new boolean[n * 2];
    diagonal2 = new boolean[n * 2];
    return backtrack(0);
  }

  public static void main(String[] args) {
    N_Queen_12952 main = new N_Queen_12952();
    int params1 = 4;
    /*int[][] params2 = new int[][]{
        {80, 20}, {50, 40}, {30, 10}
    };*/
    //int params3 = 3;

    int result = main.solution(params1);
    System.out.println(result);
  }
}
