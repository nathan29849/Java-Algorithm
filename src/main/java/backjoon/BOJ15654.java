package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15654 {

	private final static List<List<Integer>> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);
		boolean[] visited = new boolean[n];
		List<Integer> arr = new ArrayList<>();

		dfs(numbers, m, arr, visited);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answer.size(); i++) {
			for (int j = 0; j < m; j++) {
				sb.append(answer.get(i).get(j))
					.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int[] numbers, int m, List<Integer> arr, boolean[] visited) {

		if (arr.size() == m) {
			answer.add(arr);
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(numbers[i]);
				dfs(numbers, m, tmp, visited);
				visited[i] = false;
			}
		}
	}
}
