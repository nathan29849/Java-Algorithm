package thisiscodingtest.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UpgradeDisjointSets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
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
		a = find(arr, a);
		b = find(arr, b);
		if (a != b) {
			arr[Math.max(a, b)] = Math.min(a, b);
		}

	}

	private static int find(int[] arr, int a) {
		if (arr[a] != a) {
			arr[a] = find(arr, arr[a]);
		}
		return arr[a];
	}

}

//6 4
//1 4
//2 3
//2 4
//5 6


//5 4
//4 5
//3 4
//2 3
//1 2
