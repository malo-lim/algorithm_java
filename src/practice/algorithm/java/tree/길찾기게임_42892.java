package practice.algorithm.java.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 길찾기게임_42892 {
  // 1. Node 클래스 정의
  private static class Node {
    int x, y, num; // 노드의 좌표, 번호 저장
    Node left, right;

    public Node(int num, int x, int y) {
      this.x = x;
      this.y = y;
      this.num = num;
    }
  }

  // 2. 이진 트리 생성 메서드
  public Node makeBT(int[][] nodeInfo) {
    // 3. 각 노드에 대한 좌표, 번호를 배열에 저장
    Node[] nodes = new Node[nodeInfo.length];
    for (int i = 0; i < nodeInfo.length; i++) {
      nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
    }

    // 4. y 기준으로 내림차순 정렬, y가 같다면 x를 기준으로 오름차순 정렬
    Arrays.sort(nodes, ((o1, o2) -> {
      if (o1.y == o2.y) {
        // 오름차순
        return Integer.compare(o1.x, o2.x);
      }
      // 내림차순
      return Integer.compare(o2.y, o1.y);
    }));

    // 맨 처음 노드는 무조건 루트 노드
    Node root = nodes[0];
    for (int i = 1; i < nodes.length; i++) {
      Node parent = root;
      while (true) {
        // 5. 부모의 노드의 x좌표가 더 크면 왼쪽으로
        if (nodes[i].x < parent.x) {
          if (parent.left == null) {
            parent.left = nodes[i];
            break;
          } else {
            parent = parent.left;
          }
        } else {
          // 6. 부모의 노드의 x좌표가 더 작거나 같으면 오른쪽으로
          if (parent.right == null) {
            parent.right = nodes[i];
            break;
          } else {
            parent = parent.right;
          }
        }
      }
    }
    return nodes[0];
  }

  // 전위 순회 메서드
  public void preOrder(Node current, List<Integer> answer) {
    if (current == null) {
      return;
    }
    answer.add(current.num);
    preOrder(current.left, answer);
    preOrder(current.right, answer);
  }

  // 후위 순회 메서드
  public void postOrder(Node current, List<Integer> answer) {
    if (current == null) {
      return;
    }
    postOrder(current.left, answer);
    postOrder(current.right, answer);
    answer.add(current.num);
  }

  public int[][] solution(int[][] nodeinfo) {
    Node root = makeBT(nodeinfo); // 이진 트리 생성
    List<Integer> preOrderList = new ArrayList<>();
    preOrder(root, preOrderList);
    List<Integer> postOrderList = new ArrayList<>();
    postOrder(root, postOrderList);

    int[][] answer = new int[2][nodeinfo.length];
    answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
    answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

    return answer;
  }
}
