package financial;

/*
그리디

하나의 게이트에 같은 소속사 항공기만 배정
매일 배정하는 비행기 수 달라짐
게이트에 배정할 비행기 총 합은 일정 = 세 항공사의 총 비행기 수의 합

우선순위 큐를 통해서 남은 비행기의 수가 많을 수록 먼저 가져와질 수 있도록 해보자.

 */

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

class Problem2 {

	public static void main(String[] args) {
		Problem2 p = new Problem2();
		int[][] gates = new int[1][4];
		gates[0] = new int[]{5, 4, 4, 2};
		int[] airlines = {8, 5, 2};
		int[] result = p.solution(gates, airlines);
		System.out.println(result[0]);
	}

	public int[] solution(int[][] gates, int[] airlines) {
		int[] answer = {};
		List<Integer> result = new ArrayList<>();
		// 게이트 내림차순 정렬
		List<Integer> tmpGate;
		Queue<int[]> pq;
		int cnt = 1;
		for (int[] gate : gates){
			tmpGate = sortGate(gate);

			pq =  new PriorityQueue<>(
				(o1, o2) -> o2[1] - o1[1]
			);
			for (int i = 0; i < 3; i++){
				pq.add(new int[]{i, airlines[i]});
			}

			boolean flag = true;

			for (int g:tmpGate){
				int[] now = pq.poll();
				if (g <= now[1]){
					now[1] -= g;
					pq.add(now);
				} else {
					flag = false;
					break;
				}
			}
			if (flag) {
				result.add(cnt);
			}
			cnt++;
		}


		int length = result.size();
		answer = new int[length];
		if (length > 0){
			for (int i = 0; i < length; i++){
				answer[i] = result.get(i);
			}
			return answer;
		}
		return new int[]{-1};
	}

	private List<Integer> sortGate(int[] gate){
		List<Integer> tmpGate = new ArrayList<>();
		for (int g: gate){
			tmpGate.add(g);
		}
		Collections.sort(tmpGate, Collections.reverseOrder());
		return tmpGate;
	}
}
