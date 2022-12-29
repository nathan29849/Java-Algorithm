package thisiscodingtest.past.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경쟁적전염 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[n][n];
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				matrix[i][j] = tmp;
				if (tmp != 0) {
					queue.add(new int[]{tmp, i, j});
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int[] dx = new int[]{1, -1, 0, 0};
		int[] dy = new int[]{0, 0, 1, -1};
		int nx, ny;
		Queue<int[]> newQueue;
		for (int i = 0; i < s; i++) {
			newQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				int value = now[0];
				for (int j = 0; j < 4; j++) {
					nx = now[1] + dx[j];
					ny = now[2] + dy[j];
					if (0 <= nx && nx < n && 0 <= ny && ny < n) {
						if (matrix[nx][ny] == 0) {
							matrix[nx][ny] = value;
							newQueue.add(new int[]{value, nx, ny});
						}
					}
				}
			}
			queue = new PriorityQueue<>(newQueue);
		}
		System.out.println(matrix[x-1][y-1]);
	}

}
