package thisiscodingtest.past.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

	private static final List<int[]> chicken = new ArrayList<>();
	private static final List<int[]> home = new ArrayList<>();
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int tmp;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					home.add(new int[]{i, j});
				}
				if (tmp == 2) {
					chicken.add(new int[]{i, j});
				}
			}
		}
		boolean[] visited = new boolean[chicken.size()];
		List<Integer> arr = new ArrayList<>();
		dfs(0, m, visited, arr);
		System.out.println(answer);
	}

	private static void dfs(int start, int m, boolean[] visited, List<Integer> arr) {
		if (arr.size() == m) {
			int a = 0;
			for (int[] h : home) {
				int t = Integer.MAX_VALUE;
				for (int j :
					arr) {
					t = Math.min(t, getDist(h, chicken.get(j)));
				}
				a += t;
			}
			answer = Math.min(answer, a);
			return;
		}

		List<Integer> tmp;
		for (int i = start; i < chicken.size(); i++) {
			if (!visited[i]) {
				tmp = new ArrayList<>(arr);
				visited[i] = true;
				tmp.add(i);
				// 시작점 계속 바꿔주는 것으로 백트레킹 가지치기 하기
				dfs(i + 1, m, visited, tmp);
				visited[i] = false;
			}
		}
	}

	private static int getDist(int[] h, int[] c) {
		return Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
	}

}
