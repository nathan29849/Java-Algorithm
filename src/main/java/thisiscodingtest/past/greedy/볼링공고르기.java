package thisiscodingtest.past.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 볼링공고르기 {

	private static final List<List<Integer>> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] balls = new int[n];
		boolean[] visited = new boolean[n];
		List<Integer> arr = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			balls[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(balls);
		dfs(balls, visited, arr);
		System.out.println(ans.size());

	}


	private static void dfs(int[] balls, boolean[] visited, List<Integer> arr) {
		if (arr.size() == 2) {
			ans.add(arr);
			return;
		}

		for (int i = 0; i < balls.length; i++) {
			if (!visited[i]) {
				if (!arr.isEmpty()) {
					if (arr.get(arr.size() - 1) >= balls[i]) {
						continue;
					}
				}
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(balls[i]);
				visited[i] = true;
				dfs(balls, visited, tmp);
				visited[i] = false;
			}
		}
	}

}

//5 3
//1 3 2 3 2

//8 5
//1 5 4 3 2 4 5 2

//5 2
//1 1 1 1 2
