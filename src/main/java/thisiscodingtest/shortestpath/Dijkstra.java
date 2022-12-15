package thisiscodingtest.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int index;
	int distance;

	public Node(int idx, int dist) {
		this.index = idx;
		this.distance = dist;
	}

}

public class Dijkstra {


	public static List<List<Node>> graph = new ArrayList<>();
	public static boolean[] visited = new boolean[100001];
	public static int[] d = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m, start;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
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
		d[start] = 0;
		visited[start] = true;
		for (int i = 0; i < graph.get(start).size(); i++) {
			d[graph.get(start).get(i).index] = graph.get(start).get(i).distance;
		}

		for (int i = 0; i < n - 1; i++) {
			int now = getSmallestNode(n);
			visited[now] = true;
			for (int j = 0; j < graph.get(now).size(); j++) {
				int cost = d[now] + graph.get(now).get(j).distance;
				if (cost < d[graph.get(now).get(j).index]) {
					d[graph.get(now).get(j).index] = cost;
				}
			}
		}
	}


	private static int getSmallestNode(int n) {
		int minValue = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 1; i <= n; i++) {
			if (d[i] < minValue && !visited[i]) {
				minValue = d[i];
				index = i;
			}
		}
		return index;
	}

}

//6 11
//1
//1 2 2
//1 3 5
//1 4 1
//2 3 3
//2 4 2
//3 2 3
//3 6 5
//4 3 3
//4 5 1
//5 3 1
//5 6 2
