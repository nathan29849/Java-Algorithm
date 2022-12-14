package thisiscodingtest.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		int[] find = new int[m];
		st = new StringTokenizer(br.readLine());
		Integer answer;
		for (int i = 0; i < m; i++) {
			answer = binarySearch(arr, Integer.parseInt(st.nextToken()), 0, n - 1);
			if (answer == null) {
				System.out.print("no ");
			} else {
				System.out.print("yes ");
			}
		}

	}

	private static Integer binarySearch(int[] arr, int target, int start, int end) {
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return null;
	}

}
