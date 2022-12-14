package thisiscodingtest.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 성적이낮은순서로학생출력하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Map<Integer, List<String>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());

			List<String> tmp = map.getOrDefault(score, new ArrayList<>());
			tmp.add(name);
			map.put(score, tmp);
		}

		List<Integer> scores = new ArrayList<>(map.keySet());
		Collections.sort(scores);
		for (int s : scores) {
			List<String> arr = map.get(s);
			Collections.sort(arr);
			for (int i = 0; i < arr.size(); i++) {
				System.out.print(arr.get(i)+ " ");
			}
		}

	}

}
