package thisiscodingtest.past.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 퇴사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int t, p;
		List<List<Integer>> arr = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}
		int[] dp = new int[n + 1];
		int[] date = new int[n + 1];
		int[] price = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken()); // 상담일
			p = Integer.parseInt(st.nextToken()); // 상담 금액
			date[i] = t;
			price[i] = p;
			if (i + t - 1<= n) {
				arr.get(i + t - 1).add(i);
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {
				int d = i - date[arr.get(i).get(j)] + 1;
				dp[i] = Math.max(dp[i], dp[d-1] + price[d]);
			}
			dp[i] = Math.max(dp[i - 1], dp[i]);
		}

		System.out.println(dp[n]);
	}

}
