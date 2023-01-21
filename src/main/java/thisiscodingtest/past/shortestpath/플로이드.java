package thisiscodingtest.past.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		long[][] matrix = new long[n][n];
		for (long[] arr : matrix) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}

		StringTokenizer st;
		int start, end, cost;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			matrix[start - 1][end - 1] = Math.min(matrix[start - 1][end - 1], cost);
		}

		for (int j = 0; j < n; j++) {
			matrix[j][j] = 0;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (matrix[j][k] == Integer.MAX_VALUE) {
					sb.append(0);
				} else {
					sb.append(matrix[j][k]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
