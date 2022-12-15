package thisiscodingtest.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node2 {

	int idx;
	int dist;

	public Node2(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}
}

public class UpgradeDijkstra {

	private static final List<List<Node2>> graph = new ArrayList<>();
	private static final int[] d = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node2(b, c));
		}

		Arrays.fill(d, Integer.MAX_VALUE);
		dijkstra(start, n);

		for (int i = 1; i < n+1; i++) {
			if (d[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(d[i]);
			}
		}
	}

	private static void dijkstra(int start, int n) {
		Queue<Node2> pq = new PriorityQueue<>(
			Comparator.comparingInt(o -> o.dist)
		);

		pq.offer(new Node2(start, 0));
		d[start] = 0;

		while (!pq.isEmpty()) {
			Node2 node = pq.poll();
			int dist = node.dist;
			int now = node.idx;
			if (d[now] < dist) {
				continue;
			}
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).dist;
				if (cost < d[graph.get(now).get(i).idx]) {
					d[graph.get(now).get(i).idx] = cost;
					pq.offer(new Node2(graph.get(now).get(i).idx, cost));
				}
			}
		}
	}


}
