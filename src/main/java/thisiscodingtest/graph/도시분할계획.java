package thisiscodingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 도시분할계획 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<int[]> edges = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new int[]{c, a, b});
		}
		int[] parents = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parents[i] = i;
		}
		edges.sort(Comparator.comparingInt(o -> o[0]));
		int sum = 0;
		int maxEdge = 0;
		for (int i = 0; i < m; i++) {
			int[] node = edges.get(i);
			if (find(parents, node[1]) != find(parents, node[2])) {
				union(parents, node[1], node[2]);
				sum += node[0];
				maxEdge = node[0];
				for (int j = 1; j < n + 1; j++) {
					System.out.print(parents[j]+" ");
				}
				System.out.println();
			}
		}
		System.out.println(sum-maxEdge);
	}

	private static void union(int[] parents, int a, int b) {
		a = find(parents, a);
		b = find(parents, b);
		if (a > b) {
			parents[a] = b;
		} else {
			parents[b] = a;
		}

	}

	private static int find(int[] parents, int i) {
		if (parents[i] != i) {
			parents[i] = find(parents, parents[i]);
		}

		return parents[i];
	}

}

//7 12
//1 2 3
//1 3 2
//3 2 1
//2 5 2
//3 4 4
//7 3 6
//5 1 5
//1 6 2
//6 4 1
//6 5 3
//4 5 3
//6 7 4


//1 2 2 4 5 6 7
//1 2 2 4 5 4 7
//1 1 2 4 5 4 7
//1 1 2 4 1 4 7
//1 1 2 1 1 4 7
//1 1 1 1 1 1 1

//1 2 2 4 5 6 7
//1 2 2 4 5 4 7
//1 2 1 4 5 4 7
//1 2 1 4 2 4 7
//1 2 1 4 2 1 7
//1 1 1 4 2 1 7
//1 1 1 1 1 1 7
//1 1 1 1 1 1 1
