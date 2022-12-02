package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 1		(1개)
		// 2 ~ 7 	(6개)
		// 8 ~ 19 	(12개)
		// 20 ~ 37 	(18개)
		// 24 30 36 42 ...

		int start = 1;
		int cnt = 1;
		while (start < n){
			start += (6*cnt);
			cnt += 1;
		}
		System.out.println(cnt);


	}

}
