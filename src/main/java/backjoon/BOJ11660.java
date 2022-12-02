package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class BOJ11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int[] tmpArr = new int[n + 1];
			for (int j = 1; j < n + 1; j++) {
				tmpArr[j] = Integer.parseInt(st.nextToken());
			}
			matrix[i] = tmpArr;
		}

		for (int i = 0; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				matrix[i][j] += matrix[i][j - 1];
			}
		}

		for (int i = 1; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				matrix[i][j] += matrix[i-1][j];
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(
					matrix[x2][y2] - (matrix[x2][y1-1] + matrix[x1-1][y2]) + matrix[x1-1][y1-1])
				.append("\n");


		}

		System.out.println(sb);
	}
}
