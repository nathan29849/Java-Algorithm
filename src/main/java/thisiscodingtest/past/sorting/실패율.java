package thisiscodingtest.past.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 실패율 {

	public static void main(String[] args) {
		실패율 m = new 실패율();
		int[] result = m.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}


	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int total = stages.length;
		Map<Integer, Integer> stageMap = new HashMap<>();
		for (int i = 0; i < total; i++) {
			stageMap.put(
				stages[i], stageMap.getOrDefault(stages[i], 0)+1
			);
		}

		List<double[]> failure = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			int tmp = stageMap.getOrDefault(i, 0);

			if (tmp == 0 || total == 0) {
				failure.add(new double[]{0, i});
				continue;
			}
			double f = (double) tmp / total;
			total -= stageMap.getOrDefault(i, 0);
			failure.add(new double[]{f, i});
		}

		failure.sort((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Double.compare(o1[1], o2[1]);
			}
			return Double.compare(o2[0], o1[0]);
		});


		for (int i = 0; i < failure.size(); i++) {
			answer[i] = (int) failure.get(i)[1];
		}
		return answer;
	}
}
