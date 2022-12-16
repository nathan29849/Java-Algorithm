package thisiscodingtest.past.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 모험가길드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> arr = new ArrayList<>();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				ans++;
			} else {
				arr.add(a);
			}
		}

		Collections.sort(arr);
		List<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			tmp.add(arr.get(i));
			if (tmp.size() >= arr.get(i)) {
				tmp.clear();
				ans++;
			}
		}

		System.out.println(ans);
	}

}

// case 1
//6
//1 1 1 2 3 3

// answer 1
//4

// case2
//5
//2 3 1 2 2
//
// answer2
//2
