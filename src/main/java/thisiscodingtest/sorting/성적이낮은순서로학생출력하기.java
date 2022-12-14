package thisiscodingtest.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 성적이낮은순서로학생출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<List<String>> scores = new ArrayList<>();
		for (int i = 0; i < 101; i++) {
			scores.add(new ArrayList<>());
		}

		String name;
		int score;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			score = Integer.parseInt(st.nextToken());
			scores.get(score).add(name);
		}

		for (int i = 0; i < 101; i++) {
			if (!scores.get(i).isEmpty()) {
				List<String> tmp = scores.get(i);
				Collections.sort(tmp, Collections.reverseOrder());
				for (String s : tmp) {
					System.out.print(s + " ");
				}
			}
		}
	}

}
