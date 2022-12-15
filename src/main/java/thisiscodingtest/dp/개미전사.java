package thisiscodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미전사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] feeds = new int[n];
		for (int i = 0; i < n; i++) {
			feeds[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n];
		dp(dp, n, feeds);
		System.out.println(dp[n-1]);
	}

	private static void dp(int[] dp, int n, int[] feeds) {
		dp[0] = feeds[0];
		dp[1] = Math.max(feeds[0], feeds[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+feeds[i]);
		}
	}

}
