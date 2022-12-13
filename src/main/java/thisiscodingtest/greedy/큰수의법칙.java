package thisiscodingtest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 큰수의법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Integer[] numbers = new Integer[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers, Collections.reverseOrder());

		int answer = 0;
//		int cnt = 0;
//		for (int i = 0; i < m; i++) {
//			if (cnt == k) {
//				answer += numbers[1];
//				cnt = 0;
//				continue;
//			}
//			answer += numbers[0];
//			cnt++;
//		}
		answer += (m / (k + 1)) * ((numbers[0] * k) + numbers[1]);
		answer += (m % (k + 1)) * numbers[0];

		System.out.println(answer);
	}

}
