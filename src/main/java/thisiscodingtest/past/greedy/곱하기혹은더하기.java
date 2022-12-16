package thisiscodingtest.past.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기혹은더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int sum = s.charAt(0) - '0';
		for (int i = 1; i < s.length(); i++) {
			int b = s.charAt(i) - '0';
			if (sum == 0 || b == 0) {
				sum += b;
			} else {
				sum *= b;
			}

		}
		System.out.println(sum);
	}

}

// case 1
// 02984

// case 2
// 567
