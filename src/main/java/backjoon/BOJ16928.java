package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ16928 {

	private static final Map<Integer, Integer> ladder = new HashMap<>();
	private static final Map<Integer, Integer> snake = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m, u, v;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// ladder
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			ladder.put(u, v);
		}

		// snake
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			snake.put(u, v);
		}

		Deque<List<Integer>> queue = new LinkedList<>();
		List<Integer> tmp = new ArrayList<>();
		tmp.add(1);
		queue.add(tmp);
		int answer = 0;
		boolean[] visited = new boolean[101];
		visited[1] = true;
		while (!queue.isEmpty()){
			answer += 1;
			List<Integer> locations = queue.pollLast();
			List<Integer> newLocations = new ArrayList<>();
			for (Integer location : locations) {
				if (check(location, newLocations, visited)){
					System.out.println(answer);
					return;
				}
			}

			queue.addFirst(newLocations);
		}

	}

	private static boolean check(Integer now, List<Integer> newLocations, boolean[] visited) {
		for (int i = 1; i < 7; i++) {
			if ((now + i) > 100) {
				break;
			}

			if (ladder.containsKey(now + i)) {
				if (visited[ladder.get(now+i)]) {
					continue;
				}
				newLocations.add(ladder.get(now+i));
				visited[ladder.get(now+i)] = true;
				if (ladder.get(now + i) == 100) {
					return true;
				}
			}

			if (!snake.containsKey(now + i)) {
				if (visited[now+i]) {
					continue;
				}
				newLocations.add(now + i);
				visited[now+i] = true;

				if ((now+i) == 100){
					return true;
				}
			} else {
				if (visited[snake.get(now + i)]) {
					continue;
				}

				newLocations.add(snake.get(now + i));
				visited[snake.get(now + i)] = true;
			}
		}
		return false;
	}

}
