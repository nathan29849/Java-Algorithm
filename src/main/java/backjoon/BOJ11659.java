package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 구간 합 구하기 4
public class BOJ11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer> arr = new ArrayList<>();
		arr.add(0);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr.add(arr.get(i) + Integer.parseInt(st.nextToken()));
		}


		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(arr.get(b)-arr.get(a-1)).append("\n");
		}

		System.out.println(sb);
	}
}
