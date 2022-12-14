package thisiscodingtest.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		boolean[][] visited = new boolean[n][m];
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j]==0) {
					visited[i][j] = true;
					bfs(n, m, map, visited, i, j);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int n, int m, int[][] map, boolean[][] visited, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x, y});
		int[] dx = {0, 0, 1, -1};
		int[] dy = {-1, 1, 0, 0};
		int nx, ny;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				nx = now[0] + dx[i];
				ny = now[1] + dy[i];
				if (check(n, m, map, visited, nx, ny)) {
					queue.add(new int[]{nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

	private static boolean check(int n, int m, int[][] map, boolean[][] visited, int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		return !visited[x][y] && map[x][y] == 0;
	}

}



//15 14
//00000111100000
//11111101111110
//11011101101110
//11011101100000
//11011111111111
//11011111111100
//11000000011111
//01111111111111
//00000000011111
//01111111111000
//00011111111000
//00000001111000
//11111111110011
//11100011111111
//11100011111111
