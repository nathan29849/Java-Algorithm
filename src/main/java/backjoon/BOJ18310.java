package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18310 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] home = new int[n];
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			home[i] = tmp;
		}

		Arrays.sort(home);
		if (n % 2 == 0) {
			System.out.println(home[(n/2) - 1]);
		} else {
			System.out.println(home[(n/2)]);
		}
	}

}
