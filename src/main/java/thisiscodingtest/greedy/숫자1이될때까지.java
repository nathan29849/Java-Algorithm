package thisiscodingtest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자1이될때까지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while (n > 1) {
			if (n < k) {
				break;
			}
			cnt++;
			if (n % k == 0) {
				n /= k;
			} else {
				n -= 1;
			}
		}

		cnt += (n - 1);

		System.out.println(cnt);
	}

}
