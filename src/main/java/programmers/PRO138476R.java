package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PRO138476R {

	public int solution(int k, int[] tangerine) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int t : tangerine) {
			map.put(t, map.getOrDefault(t, 0) + 1);
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		list.sort((o1, o2) -> map.get(o2) - map.get(o1));

		for (Integer key : list) {
			k -= map.get(key);
			answer++;
			if (k <= 0) {
				break;
			}
		}
		return answer;
	}

}
