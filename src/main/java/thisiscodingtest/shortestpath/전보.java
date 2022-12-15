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

class Node3 {

	int idx;
	int dist;

	public Node3(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}
}

public class 전보 {

	private static int[] d = new int[30001];
	private static List<List<Node3>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Node3(e, w));
		}
		Arrays.fill(d, Integer.MAX_VALUE);
		dijkstra(c);
		int cnt = -1;
		int sum = 0;
		for (int i = 1; i < n+1; i++) {
			if (d[i] >= Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				cnt++;
				sum = Math.max(sum, d[i]);
				System.out.println(d[i]);
			}
		}

		System.out.println(cnt+" "+sum);

	}

	private static void dijkstra(int start) {
		Queue<Node3> pq = new PriorityQueue<>(
			Comparator.comparingInt(o -> o.dist)
		);

		pq.offer(new Node3(start, 0));
		d[start] = 0;

		while (!pq.isEmpty()) {
			Node3 now = pq.poll();
			int index = now.idx;
			int distance = now.dist;
			if (d[index] < distance) {
				continue;
			}

			for (int i = 0; i < graph.get(index).size(); i++) {
				int cost = d[index] + graph.get(index).get(i).dist;
				if (cost < d[graph.get(index).get(i).idx]) {
					d[graph.get(index).get(i).idx] = cost;
					pq.offer(new Node3(graph.get(index).get(i).idx, cost));
				}
			}
		}
	}
}
