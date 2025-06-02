package practice.algorithm.java.simulation;

public class 행렬구현 {
  public int[][] 행렬의곱(int[][] arr1, int[][] arr2) {
    int n = arr1.length;
    int[][] result = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < arr1.length; j++) {
        for (int k = 0; k < arr2.length; k++) {
          result[i][j] += (arr1[i][k] * arr2[k][j]);
        }
      }
    }

    return result;
  }

  public int[][] 전치행렬(int[][] arr) {
    int n = arr.length;
    int[][] result = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = arr[j][i];
      }
    }

    return result;
  }

  public int[][] 대칭연산(int[][] arr) {
    int n = arr.length;
    int[][] result = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = arr[i][n - 1 - j];
      }
    }

    return result;
  }
}
