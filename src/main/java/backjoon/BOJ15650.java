package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15650 {

	private static final List<List<Integer>> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] numbers = new int[n];
		boolean[] visited = new boolean[n];
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			numbers[i] = i + 1;
		}

		dfs(numbers, visited, m, arr);

		for (int i = 0; i < answer.size(); i++) {
			for (int j = 0; j < answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j)+" ");
			}
			System.out.println();
		}



	}

	private static void dfs(int[] nums, boolean[] visited, int m, List<Integer> arr) {

		if (arr.size() >= m) {
			answer.add(arr);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				int arrSize = arr.size();
				if (arrSize > 0) {
					if (arr.get(arrSize-1) > nums[i]) {
						continue;
					}
				}
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(nums[i]);
				visited[i] = true;
				dfs(nums, visited, m, tmp);
				visited[i] = false;
			}
		}
	}

}
