package thisiscodingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀결성 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] parents = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (cmd == 0) {
				union(parents, a, b);
			} else {
				System.out.println(find(parents, a) == find(parents, b));
			}
		}

	}

	private static int find(int[] parents, int a) {
		if (parents[a] != a) {
			parents[a] = find(parents, parents[a]);
		}
		return parents[a];
	}

	private static void union(int[] parents, int a, int b) {
		int parentA = find(parents, a);
		int parentB = find(parents, b);

		if (parentA > parentB) {
			parents[a] = parentB;
		} else {
			parents[b] = parentA;
		}
	}

}


//7 8
//0 1 3
//1 1 7
//0 7 6
//1 7 1
//0 3 7
//0 4 2
//0 1 1
//1 1 1
