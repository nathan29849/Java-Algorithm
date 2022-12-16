package thisiscodingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 커리큘럼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] indegree = new int[n + 1];
		int[] costs = new int[n + 1];
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			costs[i] = cost;
			while (st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == -1) {
					break;
				}
				indegree[i] += 1;
				graph.get(tmp).add(i);
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 1; i < n + 1; i++) {
			if (indegree[i] == 0) {
				queue.offer(new int[]{costs[i], i});
			}
		}
		int[] ans = new int[n + 1];
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int cost = now[0];
			int node = now[1];
			ans[node] = cost;
			for (int i : graph.get(node)) {
				indegree[i] -= 1;
				if (indegree[i] == 0) {
					queue.offer(new int[]{cost + costs[i], i});
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			System.out.println(ans[i]);
		}

	}

}
