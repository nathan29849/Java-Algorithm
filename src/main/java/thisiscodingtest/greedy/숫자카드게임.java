package thisiscodingtest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int pre, tmp;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			pre = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if (tmp < pre) {
					pre = tmp;
				}
			}
			if (answer < pre) {
				answer = pre;
			}
		}

		System.out.println(answer);
	}

}
