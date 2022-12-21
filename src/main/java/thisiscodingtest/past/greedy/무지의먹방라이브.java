package thisiscodingtest.past.greedy;

import java.util.*;

class 무지의먹방라이브 {

	public static void main(String[] args) {
		무지의먹방라이브 m = new 무지의먹방라이브();
		int result = m.solution(new int[]{2, 1, 2, 3, 4, 2, 1}, 15);
		System.out.println(result);
	}

	public int solution(int[] food_times, long k) {
		int n = food_times.length;

		List<int[]> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(new int[]{i, food_times[i]});
		}
		arr.sort((o1, o2) -> o1[1] - o2[1]);

		int pre = arr.get(0)[1];
		List<Integer> idxArr = new ArrayList<>();
		idxArr.add(0);
		for (int i = 0; i < n; i++) {
			if (pre != arr.get(i)[1]) {
				pre = arr.get(i)[1];
				idxArr.add(i);
			}
		}
		int i = 0;
		long preValue = 0;
		long sum = 0;
		while (k >= 0 && i < idxArr.size()) {
			int index = idxArr.get(i);
			long value = arr.get(index)[1];
			sum = (n-index) * (value-preValue);

			if (sum <= k) {
				k -= sum;
				preValue = value;
				i++;
			} else {
				List<Integer> newArr = new ArrayList<>();
				for (int j = index; j < n; j++) {
					newArr.add(arr.get(j)[0]);
				}
				newArr.sort((o1, o2) -> o1 - o2);
				int newIndex = (int) (k % (long)(n-index));
				// long type을 나머지 연산할 때, long type으로 나머지 연산을 시도하지 않았더니 효율성 테스트에서 런타임 에러가 떴다.

				return newArr.get(newIndex) + 1;
			}
		}
		return -1;
	}
}
