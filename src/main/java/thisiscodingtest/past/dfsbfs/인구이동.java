package thisiscodingtest.past.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {

	private static int[][] LAND;
	private static boolean[][] VISITED;
	private static int N;
	private static int L;
	private static int R;
	private static int ANSWER = 0;
	private static List<List<int[]>> ARRAY = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		LAND = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				LAND[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (!solve()) {
				break;
			}
		}
		System.out.println(ANSWER);

	}

	private static boolean solve() {
		boolean changed = false;
		VISITED = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (VISITED[i][j]) {
					continue;
				}
				if (dfs(new int[]{i, j})) {
					changed = true;
				}
			}
		}
		if (!changed) {
			return false;
		}
		for (List<int[]> arr : ARRAY) {
			calc(arr);
		}
		ARRAY = new ArrayList<>();
		ANSWER++;
		return true;
	}
	private static boolean dfs(int[] start) {
		int[] dx = new int[]{0, 0, 1, -1};
		int[] dy = new int[]{1, -1, 0, 0};
		if (VISITED[start[0]][start[1]]) {
			return false;
		}
		VISITED[start[0]][start[1]] = true;
		List<int[]> arr = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();

		queue.add(start);
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int cost = LAND[x][y];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (VISITED[nx][ny]){
						continue;
					}
					int abs = Math.abs(cost - LAND[nx][ny]);
					if (L <=  abs && abs <= R) {
						arr.add(new int[]{nx, ny});
						queue.add(new int[]{nx, ny});
						VISITED[nx][ny] = true;
					}
				}
			}
		}
		if (arr.isEmpty()) {
			return false;
		}
		arr.add(start);
		ARRAY.add(arr);
		return true;
	}

	private static void calc(List<int[]> arr) {
		int sum = 0;
		int size = arr.size();
		for (int[] now : arr) {
			sum += LAND[now[0]][now[1]];
		}
		int average = sum/size;
		for (int[] now : arr) {
			LAND[now[0]][now[1]] = average;
		}
	}

}
