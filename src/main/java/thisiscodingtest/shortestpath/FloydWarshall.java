package thisiscodingtest.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FloydWarshall {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long[][] graph = new long[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
		}

		for (int i = 1; i < n+1; i++) {
			graph[i][i] = 0;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int k = 1; k < n + 1; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}


		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}

}

//4
//7
//1 2 4
//1 4 6
//2 1 3
//2 3 7
//3 1 5
//3 4 4
//4 3 2
