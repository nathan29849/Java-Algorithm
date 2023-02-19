package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 치즈 - 골드3
 * https://www.acmicpc.net/problem/2638
 */
public class BOJ2638 {

	static int answer = 0;
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (solution(n, m)) {
			answer++;
		}
		System.out.println(answer);
	}

	public static boolean solution(int n, int m) {

		int[][] visited = new int[n][m];
		// 외곽 탐색
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			if (matrix[x][y] == 1) {
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (matrix[nx][ny] == 1 && visited[nx][ny] >= 0) {
						visited[nx][ny]++;
					}
					if (matrix[nx][ny] == 0 && visited[nx][ny] == 0) {
						visited[nx][ny] = -1;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}

		boolean flag = false;
		for (int i = 1; i < n-1; i++) {
			for (int j = 1; j < m-1; j++) {
				if (visited[i][j] >= 2) {
					matrix[i][j] = 0;
					flag = true;
				}
			}
		}
		return flag;
	}

}
