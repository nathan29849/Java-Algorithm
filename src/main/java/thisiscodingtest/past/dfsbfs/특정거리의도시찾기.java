package thisiscodingtest.past.dfsbfs;

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

public class 특정거리의도시찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a - 1).add(b - 1);
		}

		int[] dist = dijkstra(x-1, graph);
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (dist[i] == k) {
				flag = true;
				System.out.println(i+1);
			}
		}
		if (!flag) {
			System.out.println(-1);
		}
	}

	private static int[] dijkstra(int start, List<List<Integer>> graph) {

		// init
		int[] dist = new int[graph.size()];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		// pq
		Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[]{start, 0});

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int nowNode = now[0];
			int nowDist = now[1];

			if (nowDist > dist[nowNode]) {
				continue;
			}

			for (int node:graph.get(nowNode)) {
				int cost = nowDist + 1;
				if (cost < dist[node]) {
					dist[node] = cost;
					pq.offer(new int[]{node, cost});
				}
			}
		}

		return dist;

	}

}
