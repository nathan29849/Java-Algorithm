package thisiscodingtest.past.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정렬된배열에서특정수의개수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = n-1;
		int mid;
		while (start < end) {
			mid = (start+end) / 2;
			if (arr[mid] >= x) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		int ans = -1;
		if (arr[start] == x) {
			ans++;
			for (int i = start; i < n; i++) {
				if (arr[i] == x) {
					ans++;
					continue;
				}
				break;
			}
		}
		System.out.println(ans);
	}

}


//11 4
//1 2 3 3 4 4 5 5 6 6 6
