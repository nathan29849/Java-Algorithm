package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1039 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, k;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		boolean[][] visited = new boolean[1000001][k+1];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{n, 0});
		int length = ("" + n).length();
		List<Integer> arr = new ArrayList<>();

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int cnt = now[1];
			if (cnt == k) {
				arr.add(now[0]);
				continue;
			}
			String nowString = "" + now[0];
			char a, b;
			for (int i = 0; i < length-1; i++) {
				for (int j = i+1; j < length; j++) {
					a = nowString.charAt(i);
					b = nowString.charAt(j);
					char[] chars = nowString.toCharArray();
					if (i== 0 && b == '0') {
						continue;
					}
					int tmp = swap(chars, a, b, i, j);

					if (visited[tmp][cnt+1]) {
						continue;
					}
					queue.add(new int[]{tmp, cnt + 1});
					visited[tmp][cnt+1] = true;
				}
			}
		}
		if (arr.isEmpty()) {
			System.out.println(-1);
			return;
		}
		Collections.sort(arr, Collections.reverseOrder());
		System.out.println(arr.get(0));
	}

	private static int swap(char[] arr, char a, char b, int idx1, int idx2) {
		arr[idx1] = b;
		arr[idx2] = a;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}

}
