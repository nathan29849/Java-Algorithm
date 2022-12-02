package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = s.charAt(j) - '0';
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0, 1}); // x, y, visitCount
		int[] dx = {0, 0, +1, -1};
		int[] dy = {+1, -1, 0, 0};
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		int nx, ny;
		int[] now = {0, 0, 0};
		while (!queue.isEmpty()) {
			now = queue.poll();
//			visited[now[0]][now[1]] = true; -> 큐에 담기고 나서 visited를 true로 바꿔주면 메모리 초과가 뜬다.
			if (now[0] == n - 1 && now[1] == m - 1) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				nx = now[0] + dx[i];
				ny = now[1] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (!visited[nx][ny] && matrix[nx][ny] == 1) {
						queue.add(new int[]{nx, ny, now[2] + 1});
						visited[nx][ny] = true;	// 여기에 true를 하면 메모리 초과가 뜨지 않는다.
					}
				}
			}
		}
		System.out.println(now[2]);
	}
}
