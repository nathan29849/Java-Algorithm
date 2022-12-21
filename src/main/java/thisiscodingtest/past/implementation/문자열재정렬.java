package thisiscodingtest.past.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열재정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alphabet = new int[26];
		int number = 0;

		for (int i = 0; i < s.length(); i++) {
			int tmp = s.charAt(i);
			if (tmp < 65) {
				number+= tmp-48;
			} else {
				alphabet[tmp-65]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < alphabet[i]; j++) {
				sb.append((char)(i+65));
			}
		}
		sb.append(number);
		System.out.println(sb);
	}

}

// K1KA5CB7
// ABCKK13

// AJKDLSI412K4JSJ9D
// ADDIJJJKKLSS20
