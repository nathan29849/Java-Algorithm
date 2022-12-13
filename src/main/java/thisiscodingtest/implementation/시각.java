package thisiscodingtest.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int h = 0;
		int m = 0;
		int s = 0;
		int answer = 0;
		while (h <= n) {
			s++;
			if (s == 60) {
				s = 0;
				m++;
			}

			if (m == 60) {
				m = 0;
				h++;
			}
			if (checkNumber3(h) || checkNumber3(m) || checkNumber3(s)) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static boolean checkNumber3(int now) {
		if (now > 10) {
			if (String.valueOf(now).charAt(0) == '3' || String.valueOf(now).charAt(1) == '3') {
				return true;
			}
		}

		return now == 3;
	}

}
