package thisiscodingtest.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySaerch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		Integer answer = binarySearchWithRecursion(arr, target, 0, n - 1);
		if (answer == null) {
			System.out.println("값이 존재하지 않습니다.");
			return;
		}
		System.out.println(answer);

		Integer answer2 = binarySearchWithRepeat(arr, target, 0, n - 1);
		System.out.println(answer2);
	}

	private static Integer binarySearchWithRecursion(int[] arr, int target, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;

		if (arr[mid] == target) {
			return mid;
		}

		if (arr[mid] < target) {
			return binarySearchWithRecursion(arr, target, mid + 1, end);
		}
		return  binarySearchWithRecursion(arr, target, start, mid-1);
	}

	private static Integer binarySearchWithRepeat(int[] arr, int target, int start, int end) {
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return mid;
	}

}


//10 7
//1 19 3 5 7 11 9 17 13 15

//10 7
//1 19 3 5 6 11 9 17 13 15
