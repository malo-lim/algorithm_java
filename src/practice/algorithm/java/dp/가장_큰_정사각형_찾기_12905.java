package practice.algorithm.java.dp;

public class 가장_큰_정사각형_찾기_12905 {
  public int solution(int[][] board) {
    int rowSize = board.length;
    int colSize = board[0].length;

    for (int i = 1; i < rowSize; i++) {
      for (int j = 1; j < colSize; j++) {
        // 현재 위치의 값이 1인 경우 확인
        if (board[i][j] == 1) {
          // 위, 왼쪽, 대각선 왼쪽 위의 값들을 가져옴
          int up = board[i - 1][j];
          int left = board[i][j - 1];
          int upLeft = board[i - 1][j - 1];

          // 현재 위치의 값을 이전 위치들의 값들 중
          // 가장 작은 값에 1을 더한 값으로 업데이트
          board[i][j] += Math.min(up, Math.min(upLeft, left));
        }
      }
    }

    int answer = 0;
    // 보드에서 가장 큰 값(최대 정사각형의 한 변의 길이) 찾기
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        answer = Math.max(answer, board[i][j]);
      }
    }

    // 정사각형의 넓이를 반환한다.
    return answer * answer;
  }
}
