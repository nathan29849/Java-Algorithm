package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		List<Integer> arr = new ArrayList<>();
		for (int i = 1; i < n+1; i++) {
			arr.add(i);
		}

		Deque<Integer> popList = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			popList.add(Integer.parseInt(st.nextToken()));
		}
		int answer = 0;
		while (!popList.isEmpty()) {
			Integer now = popList.pollFirst();
			int idx = arr.indexOf(now);
			int arrSize = arr.size();
			arr = getIntegers(arr, idx);
			if (idx >= (arrSize - idx)) {
				answer += (arr.size() - idx)+1;
			} else {
				answer += idx;
			}
		}

		System.out.println(answer);
	}

	private static List<Integer> getIntegers(List<Integer> arr, int idx) {
		List<Integer> firstArr = arr.subList(0, idx);
		List<Integer> secondArr = arr.subList(idx + 1, arr.size());
		secondArr.addAll(firstArr);
		arr = secondArr;
		return arr;
	}

}
