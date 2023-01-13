package thisiscodingtest.past.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 정수삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<int[]> arr = new ArrayList<>();
		StringTokenizer st;
		int c = 1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] tmp = new int[c];
			for (int j = 0; j < c; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			c++;
			arr.add(tmp);
		}

		for (int i = 1; i < n; i++) {
			int[] tmp = arr.get(i);
			int length = tmp.length;
			for (int j = 0; j < length; j++) {
				if (j == 0) {
					tmp[j] += arr.get(i - 1)[j];
				} else if (j == length - 1) {
					tmp[j] += arr.get(i - 1)[j - 1];
				} else {
					tmp[j] += Math.max(arr.get(i - 1)[j - 1], arr.get(i - 1)[j]);
				}
			}
		}
		int ans = 0;
		for (int a : arr.get(arr.size() - 1)) {
			ans = Math.max(a, ans);
		}
		System.out.println(ans);
	}

}
