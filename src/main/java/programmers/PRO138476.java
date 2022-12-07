package programmers;

import java.util.*;
import java.util.Map.Entry;

public class PRO138476 {

	public static void main(String[] args) {
		PRO138476 p = new PRO138476();
		System.out.println(p.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(p.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
		System.out.println(p.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
	}

	public int solution(int k, int[] tangerine) {
		int answer = 0;
		Map<Integer, Tanger> tmpMap = new HashMap<>();
		for (int i = 0; i < tangerine.length; i++) {
			if (tmpMap.containsKey(tangerine[i])){
				Tanger tanger = tmpMap.get(tangerine[i]);
				tanger.num++;
			} else {
				tmpMap.put(tangerine[i], new Tanger(tangerine[i], 1));
			}
		}
		ArrayList<Tanger> arr = new ArrayList<>();
		for (Map.Entry<Integer, Tanger> tanger :tmpMap.entrySet()) {
			arr.add(tanger.getValue());
		}
		Collections.sort(arr);

		for (Tanger t:arr) {
			k -= t.num;
			answer++;
			if (k <= 0) {
				break;
			}
		}


		return answer;
	}

	class Tanger implements Comparable {

		int value;
		int num;

		public Tanger(int value, int num) {
			this.value = value;
			this.num = num;
		}

		@Override
		public int compareTo(Object o) {
			Tanger t = (Tanger) o;
			return t.num - this.num;
		}
	}

}
