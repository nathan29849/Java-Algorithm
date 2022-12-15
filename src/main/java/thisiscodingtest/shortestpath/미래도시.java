package thisiscodingtest.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미래도시 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[][] matrix = new long[n+1][n+1];
		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(matrix[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n + 1; i++) {
			matrix[i][i] = 0;
 		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int l = 1; l < n + 1; l++) {
					matrix[j][l] = Math.min(matrix[j][l], matrix[j][i] + matrix[i][l]);
				}
			}
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

		long ans = matrix[1][k] + matrix[k][x];
		if (ans >= Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

}

//5 7
//1 2
//1 3
//1 4
//2 4
//3 4
//3 5
//4 5
//4 5

//4 2
//1 3
//2 4
//3 4
