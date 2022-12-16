package thisiscodingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Kruskal {

	private static final List<int[]> edges = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] parents = new int[n+1];
		for (int i = 1; i < n + 1; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new int[]{c, a, b});
		}
		int ans = 0;
		Collections.sort(edges, Comparator.comparingInt(o -> o[0]));
		for (int i = 0; i < m; i++) {
			int[] arr = edges.get(i);
			int cost = arr[0];
			int a = arr[1];
			int b = arr[2];
			if (!(find(parents, a) == find(parents, b))) {
				union(parents, a, b);
				ans += cost;
			}

		}
		System.out.println(ans);
	}

	private static void union(int[] arr, int a, int b) {
		int parent1 = find(arr, a);
		int parent2 = find(arr, b);
		if (parent1 != parent2) {
			arr[Math.max(parent1, parent2)] = Math.min(parent1, parent2);
		}

	}

	private static int find(int[] arr, int a) {
		if (arr[a] != a) {
			arr[a] = find(arr, arr[a]);
		}
		return arr[a];
	}

}
