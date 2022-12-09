package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 순열
public class BOJ15649 {

	private static final List<List<Integer>> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		dfs(arr, visited, m, result);

		for (int i = 0; i < answer.size(); i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(answer.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

	private static void dfs(int[] arr, boolean[] visited, int m, List<Integer> result) {

		if (result.size() >= m) {
			answer.add(result);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]){
				visited[i] = true;
				List<Integer> tmp = new ArrayList<>(result);
				tmp.add(arr[i]);
				dfs(arr, visited, m, tmp);
				visited[i] = false;
			}
		}
	}

}
