package thisiscodingtest.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		int result = bfs(visited, map, new int[]{0, 0}, n, m);
		System.out.println(result);

	}

	private static int bfs(boolean[][] visited, int[][] map, int[] now, int n, int m) {
		int answer = 0;
		Queue<List<int[]>> queue = new LinkedList<>();
		List<int[]> arr = new ArrayList<>();
		arr.add(now);
		queue.add(arr);
		int[] dx = {0, 0, 1, -1};
		int[] dy = {-1, 1, 0, 0};
		int nx, ny;
		boolean flag = true;
		while (!queue.isEmpty() && flag) {
			List<int[]> popArr = queue.poll();
			List<int[]> tmpArr = new ArrayList<>();
			for (int[] point : popArr) {
				if (point[0] == n - 1 && point[1] == m - 1) {
					flag = false;
					break;
				}

				for (int i = 0; i < 4; i++) {
					nx = point[0] + dx[i];
					ny = point[1] + dy[i];
					if (check(n, m, map, visited, nx, ny)) {
						tmpArr.add(new int[]{nx, ny});
						visited[nx][ny] = true;
					}
				}
			}

			queue.add(tmpArr);
			answer++;
		}
		return answer;
	}

	private static boolean check(int n, int m, int[][] map, boolean[][] visited, int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		return !visited[x][y] && map[x][y] == 1;
	}


}
