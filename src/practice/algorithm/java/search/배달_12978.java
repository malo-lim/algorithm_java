package practice.algorithm.java.search;

import java.util.*;

public class 배달_12978 {
  private static class Node {
    int dest, cost;

    public Node(int dest, int cost) {
      this.dest = dest;
      this.cost = cost;
    }
  }

  public int solution(int N, int[][] road, int K) {
    // 가중치를 이용한건 다익스트라 또는 벨만포드로 구하면 된다.
    // 인접 리스트를 저장할 ArrayList 배열 초기화
    List<Node>[] adjList = new ArrayList[N + 1];
    for (int i = 0; i <= N; i++) {
      adjList[i] = new ArrayList<>();
    }

    // road 정보를 인접 리스트로 저장
    // 양방향이므로 각각 추가해준다.
    for (int[] edge : road) {
      adjList[edge[0]].add(new Node(edge[1], edge[2]));
      adjList[edge[1]].add(new Node(edge[0], edge[2]));
    }

    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    // 오름차순으로 정렬
    Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    pq.add(new Node(1, 0));

    // 1부터 시작
    dist[1] = 0;

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (dist[now.dest] < now.cost) {
        continue;
      }

      for (Node next : adjList[now.dest]) {
        if (dist[next.dest] > now.cost + next.cost) {
          dist[next.dest] = now.cost + next.cost;
          pq.add(new Node(next.dest, dist[next.dest]));
        }
      }
    }

    int answer = 0;
    for (int i = 0; i <= N; i++) {
      if (dist[i] <= K) {
        answer++;
      }
    }

    return answer;
  }
}
