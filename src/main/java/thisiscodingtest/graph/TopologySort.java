package thisiscodingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[v + 1];
		for (int i = 0; i < v + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			indegree[b] += 1;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < v + 1; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		List<Integer> ans = new ArrayList<>();

		while (!queue.isEmpty()) {
			Integer now = queue.poll();
			ans.add(now);
			for (int node: graph.get(now)) {
				indegree[node] -= 1;
				if (indegree[node] == 0) {
					queue.offer(node);
				}
			}
		}

		for (int a : ans) {
			System.out.println(a);
		}

	}

}

//7 8
//1 2
//1 5
//2 3
//2 6
//3 4
//4 7
//5 6
//6 4
