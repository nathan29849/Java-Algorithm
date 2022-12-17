package financial;

/*
그리디

[원가, 할인가]
동시에 저장해 놓을까

샀다는 의미 : boolean[] visited 배열로 체크

매일 무조건 하나는 사야함
하나 이상 살 수도 있음
n개의 게임을 사면 그냥 종료

정렬을 어떻게 할까

아예 공백 기간을 채워야해서 할인을 일부러 안받아야 할 수도 있음
어차피 모든 게임을 사야하기 때문에, 공백기간이 있는지 여부에 따라 사려는 개수를 조절해야 할듯?

경우 1. 할인 받지 못하고 그냥 사야하는 경우
경우 2. 할인을 받아 살 수는 있으나, 공백기간이 존재하여 할인 받지 않고 그냥 사는 경우
경우 3. 할인을 받아 살 수 있는 경우(1개 이상)

경우 4. 할인 날짜가 애초에 도래할 수 없는 경우
	->

 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Problem3 {
	public int solution(int[][] games) {
		int answer = 0;
		List<List<int[]>> day = initDay(games.length);
		int dc = 0;

		List<int[]> surplus = new ArrayList<>();
		boolean[] visited = new boolean[games.length];
		int lastDay = 0;
		int cnt = 0;

		for (int[] game:games){
			dc = discount(game[0], game[2]);
			// 할인금액, 할인가, 정가
			day.get(game[1]).add(new int[]{dc, game[0]-dc, game[0]});
		}

		for (int i = 0; i < games.length; i++) {
			if (!day.get(i).isEmpty()){
				Collections.sort(day.get(i),
					(o1, o2) -> o2[0] - o1[0]
				);

				answer += day.get(i).get(0)[1];
				day.get(i).remove(0);
				surplus.addAll(day.get(i));
				visited[i] = true;
				lastDay = i;
				cnt++;
			}
		}

		Collections.sort(surplus,
			(o1, o2) -> o1[2] - o2[2]
		);

		for (int i = 0; i < surplus.size(); i++) {
			answer += surplus.get(i)[2];
		}


		return answer;
	}

	private List<List<int[]>> initDay(int length){
		List<List<int[]>> day = new ArrayList<>();

		for (int i = 0; i < length; i++){
			day.add(new ArrayList<>());
		}

		return day;
	}

	private int discount(int price, int percent){
		return (int) (price * ((double)(percent) / 100));
	}
}
