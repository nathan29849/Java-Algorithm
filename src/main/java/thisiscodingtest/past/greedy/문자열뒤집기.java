package thisiscodingtest.past.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char now = s.charAt(0);
		int oneCnt = 0;
		int zeroCnt = 0;
		if (now == '0') {
			zeroCnt++;
		} else {
			oneCnt++;
		}

		for (int i = 1; i < s.length(); i++) {
			if (now != s.charAt(i)) {
				now = s.charAt(i);
				if (now == '0') {
					zeroCnt++;
				} else {
					oneCnt++;
				}
			}
		}

		System.out.println(Math.min(zeroCnt, oneCnt));
	}

}

//1010000
//0001100
//11001100110011000001
