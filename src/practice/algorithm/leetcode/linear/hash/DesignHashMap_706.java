package practice.algorithm.leetcode.linear.hash;

public class DesignHashMap_706 {

  // 개별 체이닝 방식으로 구현

  static class Node {
    int key, val;
    Node next;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  final Node[] nodes = new Node[1000000];

  public DesignHashMap_706() {

  }

  public void put(int key, int value) {
    // 해싱 결과를 인덱스로 지정
    int index = key % nodes.length;

    // 해당 인덱스에 노드가 없다면 신규 생성 후 종료
    if (nodes[index] == null) {
      nodes[index] = new Node(key, value);
      return;
    }

    // 인덱스에 노드가 존재한다면 연결리스트로 처리
    Node node = nodes[index];
    while (node != null) {
      // 동일한 키가 있다면 값을 업데이트하고 종료
      if (node.key == key) {
        node.val = value;
        return;
      }

      // 다음 노드가 없다면 종료
      if (node.next == null) {
        break;
      }

      node = node.next;
    }

    node.next = new Node(key, value);

  }

  public int get(int key) {
    // 해싱 결과를 인덱스로 저장
    int index = key % nodes.length;

    // 인덱스에 노드가 존재하지 않으면 -1
    if (nodes[index] == null) {
      return -1;
    }

    // 인덱스에 노드가 존재한다면 키 탐색
    Node node = nodes[index];
    while (node != null) {
      // 동일한 키가 있다면 값을 return
      if (node.key == key) {
        return node.val;
      }

      // 다음 노드로 진행
      node = node.next;
    }

    // 인덱스를 모두 순히해도 없다면 -1 리턴
    return -1;
  }

  public void remove(int key) {
    // 해싱 결과를 인덱스로 저장
    int index = key % nodes.length;

    // 해당 인덱스에 값이 없다면 종료
    if (nodes[index] == null) {
      return;
    }

    // 첫번째 노드일 때의 삭제 처리
    Node node = nodes[index];
    // 일치하는 키가 있다면
    if (node.key == key) {
      // 다음 노드가 없다면 해당 인덱스는 null 처리
      if (node.next == null) {
        nodes[index] = null;
      } else {
        // 다음 노드가 있다면 다음 노드를 인덱스로 지정
        nodes[index] = node.next;
      }
    }

    // 연결 리스트 노드일 때의 삭제 처리
    Node prev = node;
    while (node != null) {
      // 일치하는 키가 있다면
      if (node.key == key) {
        // 이전 노드의 다음에 현재 노드의 다음을 연결하고 리턴
        prev.next = node.next;
        return;
      }
      // 노드 한칸 씩 이동
      prev = node;
      node = node.next;
    }
  }
}
