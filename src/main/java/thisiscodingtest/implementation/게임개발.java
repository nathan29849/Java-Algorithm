package thisiscodingtest.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] location = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

		// 북, 동, 남, 서
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] visited = new boolean[n][m];
		Deque<int[]> queue = new LinkedList<>();
		queue.add(location);
		visited[location[0]][location[1]] = true;
		int answer = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			answer++;
			boolean flag = false;
			int nx = 0;
			int ny = 0;
			int d = 0;
			for (int i = now[2]+3; i < now[2]+3 + 4; i++) {
				d = i % 4;
				nx = now[0] + dx[d];
				ny = now[1] + dy[d];
				if (checkLocation(new int[]{nx, ny}, n, m, map)) {
					if (!visited[nx][ny]){
						visited[nx][ny] = true;
						queue.add(new int[]{nx, ny, d});
						flag = true;
					}
				}
			}

			if (!flag) {
				int back = (d + 2) % 2;
				if (checkLocation(new int[]{nx+dx[back], ny+dy[back]}, n, m, map)) {
					queue.addFirst(new int[]{nx+dx[back], ny+dy[back]});
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean checkLocation(int[] next, int n, int m, int[][] matrix) {
		if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
			return false;
		}
		return matrix[next[0]][next[1]] != 1;
	}

}
