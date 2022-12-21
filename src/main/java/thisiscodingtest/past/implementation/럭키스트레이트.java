package thisiscodingtest.past.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키스트레이트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() / 2) {
				left += s.charAt(i)-'0';
			} else {
				right += s.charAt(i)-'0';
			}
		}

		if (left == right) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}
	}

}
