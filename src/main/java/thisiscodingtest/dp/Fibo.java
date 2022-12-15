package thisiscodingtest.dp;

public class Fibo {

	public static void main(String[] args) {
		int ans = fib(50);
		System.out.println(ans);

		long[] dp = new long[51];
		long answer = fibWithDP(50, dp);
		System.out.println(answer);
	}

	private static int fib(int n) {
		if (n <= 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	private static long fibWithDP(int n, long[] dp) {
		if (n <= 2) {
			return 1;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		dp[n] = fibWithDP(n - 1, dp) + fibWithDP(n - 2, dp);
		return dp[n];
	}

	private static long fibWithDP2(int n, long[] dp) {
		if (n <= 2) {
			return 1;
		}
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}
