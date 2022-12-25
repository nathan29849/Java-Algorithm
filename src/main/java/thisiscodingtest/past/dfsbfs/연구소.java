package thisiscodingtest.past.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

	private static final List<List<int[]>> zeros = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[n][m];
		List<int[]> two = new ArrayList<>();
		List<int[]> zero = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j] == 0) {
					zero.add(new int[]{i, j});
				} else if (matrix[i][j] == 2) {
					two.add(new int[]{i, j});
				}
			}
		}
		int ans = 0;
		dfs(3, new ArrayList<>(), new boolean[zero.size()], zero);
		for (List<int[]> tmpArr:zeros) {
			int[][] tmpMatrix = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					tmpMatrix[i][j] = matrix[i][j];
				}
			}
			for (int[] e:tmpArr) {
				tmpMatrix[e[0]][e[1]] = 1;
			}
			bfs(tmpMatrix, n, m, two);
			ans = Math.max(countSafeArea(tmpMatrix), ans);
		}
		System.out.println(ans);
	}

	private static int countSafeArea(int[][] matrix) {

		int cnt = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void bfs(int[][] matrix, int n, int m, List<int[]> two) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		for (int[] t:two) {
			queue.add(t);
			visited[t[0]][t[1]] = true;
		}

		int[] dx = new int[]{0, 0, 1, -1};
		int[] dy = new int[]{1, -1, 0, 0};
		int nx, ny;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 4; i++) {
				nx = now[0] + dx[i];
				ny = now[1] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (!visited[nx][ny] && matrix[nx][ny] == 0) {
						matrix[nx][ny] = 2;
						visited[nx][ny] = true;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}
	}

	private static void dfs(int target, List<int[]> arr, boolean[] visited, List<int[]> zero) {
		if (arr.size() == target) {
			zeros.add(arr);
			return;
		}

		for (int i = 0; i < zero.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				List<int[]> tmp = new ArrayList<>(arr);
				tmp.add(zero.get(i));
				dfs(target, tmp, visited, zero);
				visited[i] = false;
			}
		}
	}

}
