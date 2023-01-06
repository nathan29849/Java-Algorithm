package thisiscodingtest.past.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고정점찾기 {
	private static int answer = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		binarySearch(0, n-1, arr);
		System.out.println(answer);
	}

//5
//-15 -6 1 3 7

//7
//-15 -4 2 8 9 13 15

//7
//-15 -4 3 8 9 13 15

//7
//-2 -1 1 2 3 4 6

//6
//0 3 4 5 8 7
	private static void binarySearch(int start, int end, int[] arr) {
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] == mid) {
				answer = mid;
				return;
			} else if (arr[mid] < mid) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		if (arr[end] == end) {
			answer = end;
		}
	}

}
