package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 절댓값 힙
public class BOJ11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int now;
		PriorityQueue<Integer> queue = new PriorityQueue<>(
			(o1, o2) -> {
				if (Math.abs(o1) != Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				}
				return (o1 - o2);
			}
		);

		for (int i = 0; i < n; i++) {
			now = Integer.parseInt(br.readLine());
			if (now != 0){
				// push
				queue.offer(now);
			} else {
				// print
				if (queue.size() == 0) {
					sb.append(0);
				} else {
					sb.append(queue.poll());
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}
