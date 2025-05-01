package practice.algorithm.java.tree;

import java.util.Arrays;

public class 배열_트리순회 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6, 7})));
  }

  private static String[] solution(int[] nodes) {
    String[] result = new String[3];
    // 전위 순회
    result[0] = preorder(nodes, 0).trim(); // 마지막 공백 제거
    // 중위 순회
    result[1] = inorder(nodes, 0).trim(); // 마지막 공백 제거
    // 후위 순회
    result[2] = postorder(nodes, 0).trim(); // 마지막 공백 제거
    return result;
  }

  private static String preorder(int[] nodes, int idx) {
    if (idx >= nodes.length) {
      return "";
    }

    // 루트 노드 -> 왼쪽 서브 트리 -> 오른쪽 서브 트리 순으로 재귀 호출
    return nodes[idx] + " " +
        preorder(nodes, 2 * idx + 1) + preorder(nodes, 2 * idx + 2);
  }

  private static String inorder(int[] nodes, int idx) {
    if (idx >= nodes.length) {
      return "";
    }

    // 왼쪽 서브 트리 -> 루트 노드 -> 오른쪽 서브 트리 순으로 재귀 호출
    return inorder(nodes, 2 * idx + 1) + nodes[idx] + " "
        + inorder(nodes, 2 * idx + 2);
  }

  private static String postorder(int[] nodes, int idx) {
    if (idx >= nodes.length) {
      return "";
    }

    // 왼쪽 서브 트리 -> 오른쪽 서브 트리 -> 루트 노드 순으로 재귀 호출
    return postorder(nodes, 2 * idx + 1) + postorder(nodes, 2 * idx + 2) + nodes[idx] + " ";
  }
}
