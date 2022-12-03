package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		List<int[]> gems = new ArrayList<>();
		long[] knapsack = new long[K];
		int m, v;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			gems.add(new int[]{m, v});
		}



		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);

		for (int i = 0; i < K; i++) {
			knapsack[i] = Integer.parseInt(br.readLine());
		}

		gems.sort((o1, o2) -> o1[0] - o2[0]);
		Arrays.sort(knapsack);

		int now = 0;
		long answer = 0;
		for (long bag : knapsack) {
			while (now < N) {
				if (bag >= gems.get(now)[0]) {
					priorityQueue.add(gems.get(now));
					now++;
				} else {
					break;
				}
			}
			if (!priorityQueue.isEmpty()){
				answer += priorityQueue.poll()[1];
			}
		}
		System.out.println(answer);
	}

}

