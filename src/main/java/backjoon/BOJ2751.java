package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(arr);
		for (int i = 0; i < n; i++) {
			sb.append(arr.get(i)).append("\n");
		}
		System.out.println(sb);
	}

	private static int binarySearch(int target, LinkedList<Integer> arr) {
		int start = 0;
		int end = arr.size()-1;
		int mid;
		while (start <= end) {
			mid = (start+end)/2;
			if (arr.get(mid) >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

}
