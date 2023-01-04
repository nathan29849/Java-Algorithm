package thisiscodingtest.past.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 카드정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Long> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o));
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		long ans = 0;
		while (pq.size() > 1) {
			Long first = pq.poll();
			Long second = pq.poll();
			pq.add(first + second);
			ans += first + second;
		}
		System.out.println(ans);
	}

}
