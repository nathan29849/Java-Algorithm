package thisiscodingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BasicDisjointSets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		int[] graph = new int[m];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(arr, a, b);
		}

		for (int i = 1; i < n + 1; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void union(int[] arr, int a, int b) {
		int parent1 = find(arr, a);
		int parent2 = find(arr, b);
		if (parent1 != parent2) {
			arr[Math.max(parent1, parent2)] = Math.min(parent1, parent2);
		}

	}

	private static int find(int[] arr, int a) {
		while (arr[a] != a) {
			a = arr[a];
		}
		return a;
	}

}
