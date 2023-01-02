package thisiscodingtest.past.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

	private static int[] numbers = new int[0];
	private static List<Integer> results = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] operator = new int[4];
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> arr = new ArrayList<>();
		dfs(operator, arr, n);
		results.sort(Comparator.comparingInt(o -> o));
		System.out.println(results.get(results.size()-1));
		System.out.println(results.get(0));
	}

	private static void dfs(int[] operator, List<Integer> arr, int n) {
		if (arr.size() == (n - 1)) {
			results.add(calculate(arr));
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(i);
				dfs(operator, tmp, n);
				operator[i]++;
			}
		}
	}

	private static int calculate(List<Integer> arr) {
		int result = numbers[0];
		int now = 0;

		for (int i = 0; i < arr.size(); i++) {
			now++;
			if (arr.get(i) == 0) { // +
				result += numbers[now];
			} else if (arr.get(i) == 1) { // -
				result -= numbers[now];
			} else if (arr.get(i) == 2) { // *
				result *= numbers[now];
			} else {
				boolean flag = true;
				if (numbers[now] < 0) {
					numbers[now] *= -1;
					flag = false;
				}
				result /= numbers[now];
				if (!flag) {
					numbers[now] *= -1;
					result *= -1;
				}
			}
		}

		return result;
	}

}
