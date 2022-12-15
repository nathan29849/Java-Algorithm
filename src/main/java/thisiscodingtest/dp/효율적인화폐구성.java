package thisiscodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dp = new int[10001];
		for (int i = 0; i < m + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			dp[coin[i]] = 1;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 0; j < n; j++) {
				if (i - coin[j] > 0 && dp[i - coin[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i - coin[j]]+1, dp[i]);
				}
			}
		}
		if (dp[m] == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(dp[m]);
		}

	}

}
