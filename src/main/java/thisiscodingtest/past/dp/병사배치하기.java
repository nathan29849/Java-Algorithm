package thisiscodingtest.past.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 병사배치하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[2000];
		dp[0] = arr[0];
		int idx = 0;
		for (int i = 1; i < n; i++) {
			if (dp[idx] > arr[i]) {
				dp[++idx] = arr[i];
			} else {
				for (int j = idx; j >= 0; j--) {
					if (dp[j] > arr[i]) {
						dp[j+1] = arr[i];
						break;
					}
				}
				if (dp[0] < arr[i]) {
					dp[0] = arr[i];
				}
			}
		}
		System.out.println(n - idx - 1);
	}
}
