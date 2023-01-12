package thisiscodingtest.past.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {

	private static int[][] matrix;
	private static int n;
	private static int m;
	private static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			init(br);
			dp();
			sb.append(answer).append("\n");
			answer = 0;
		}
		System.out.println(sb);
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void dp(){

		for (int j = 1; j < m; j++) {
			for (int i = 0; i < n; i++) {
				if (i == 0) {
					matrix[i][j] += Math.max(matrix[i][j - 1], matrix[i+1][j - 1]);
				} else if (i == n-1) {
					matrix[i][j] += Math.max(matrix[i - 1][j - 1], matrix[i][j - 1]);
				} else {
					int tmpMax = Math.max(matrix[i - 1][j - 1], matrix[i][j - 1]);
					matrix[i][j] += Math.max(tmpMax, matrix[i + 1][j - 1]);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			answer = Math.max(matrix[i][m - 1], answer);
		}
	}


}

//2
//3 4
//1 3 3 2 2 1 4 1 0 6 4 7
//4 4
//1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
