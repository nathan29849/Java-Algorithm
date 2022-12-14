package thisiscodingtest.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기dfs {

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
				if (dfs(i, j, map, n, m, visited)){
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean dfs(int x, int y, int[][] map, int n, int m, boolean[][] visited) {
		if (check(n, m, map, visited, x, y)) {
			visited[x][y] = true;
			dfs(x + 1, y, map, n, m, visited);
			dfs(x, y+1, map, n, m, visited);
			dfs(x - 1, y, map, n, m, visited);
			dfs(x, y - 1, map, n, m, visited);
			return true;
		}
		return false;
	}


	private static boolean check(int n, int m, int[][] map, boolean[][] visited, int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		return !visited[x][y] && map[x][y] == 0;
	}
}
