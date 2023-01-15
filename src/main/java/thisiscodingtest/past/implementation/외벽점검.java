package thisiscodingtest.past.implementation;

import java.util.*;

public class 외벽점검 {

	public static void main(String[] args) {
		외벽점검 m = new 외벽점검();
//		int result = m.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4});
//		int result = m.solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7});
		int result = m.solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{1, 10, 5, 40, 30});
		System.out.println(result);
	}

	private int[] Dist;
	private int[] Weak;
	private int N;
	private List<List<Integer>> P = new ArrayList<>();
	public int solution(int n, int[] weak, int[] dist) {
		int answer = Integer.MAX_VALUE;
		Arrays.sort(dist);
		Dist = dist;
		Weak = weak;
		N = n;
		boolean[] visited = new boolean[dist.length];
		permutations(new ArrayList<>(), visited);
		for (int i = 0; i < Weak.length; i++) {
			for (int p = 0; p < P.size(); p++) {
				answer = Math.min(run(i, P.get(p)), answer);
			}
		}
		if (answer == Integer.MAX_VALUE) {
			return -1;
		}
		return answer;
	}


	private int run(int start, List<Integer> newDist) {
		int cnt = 0;
		int startIdx = start;
		int minDist = Integer.MAX_VALUE;
		for (int i = newDist.size()-1; i >= 0; i--) {
			int d = newDist.get(i);
			for (int j = 0; j < Weak.length; j++) {
				if (cnt == Weak.length) {
					break;
				}
				int idx = (startIdx+j) % Weak.length;
				int diff = Weak[idx] - Weak[startIdx];
				if (startIdx+j >= Weak.length) {
					diff = N+Weak[idx] - Weak[startIdx];
				}

				if (diff <= d) {
					cnt++;
				} else {
					startIdx = idx;
					break;
				}
			}
			if (cnt == Weak.length) {
				minDist = Math.min(minDist, newDist.size() - i);
				return minDist;
			}
		}
		return Integer.MAX_VALUE;
	}

	private void permutations(List<Integer> arr, boolean[] visited) {
		if (arr.size() == Dist.length) {
			P.add(arr);
			return;
		}

		for (int i = 0; i < Dist.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				List<Integer> tmp = new ArrayList<>(arr);
				tmp.add(Dist[i]);
				permutations(tmp, visited);
				visited[i] = false;
			}
		}
	}
}

/*
* 풀이 과정
* 1. dist의 순열을 구한다. (시계방향 순서에 따라서 담을 수 있는 개수가 달라진다.)
* 2. weak 배열을 하나씩 순회하여 시작점을 정하고, 시작점으로 부터 dist의 순열만큼 for문을 돌며, 취약지점을 모두 순회할 수 있는지 체크한다.
* 3. 최솟값을 도출한다.
* 원형 배열을 해결한 포인트 : % 연산
* */
