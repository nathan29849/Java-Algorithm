package thisiscodingtest.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int answer = binarySearch(arr, m, 0, arr[n-1]);
		System.out.println(answer);

	}

	private static int binarySearch(int[] arr, int sum, int start, int end) {
		int mid;
		int result = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (slicing(arr, sum, mid)) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

	private static boolean slicing(int[] arr, int sum, int c) {
		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += Math.max(arr[i] - c, 0);
		}
		return result >= sum;
	}

}
