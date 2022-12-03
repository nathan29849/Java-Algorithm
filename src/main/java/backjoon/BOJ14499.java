package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14499 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 변수 초기화
		int N, M, x, y, K;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		// matrix(=지도) 초기화
		int[][] matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		List<Integer> nums = new ArrayList<>();
		while (st.hasMoreTokens()) {
			nums.add(Integer.parseInt(st.nextToken()));
		}

		int[] dice = new int[6];


		// 동1 서2 북3 남4
		int direction, nx, ny;
		for (int i = 0; i < nums.size(); i++) {
			nx = x;
			ny = y;
			direction = nums.get(i);
			switch (direction) {
				case 1:
					ny=y+1;
					break;
				case 2:
					ny=y-1;
					break;
				case 3:
					nx=x-1;
					break;
				default:
					nx=x+1;
			}
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				x = nx;
				y = ny;
				dice = throwTheDice(dice, direction);
				if (matrix[x][y] == 0) {
					// 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
					matrix[x][y] = dice[5];
				} else {
					// 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
					dice[5] = matrix[x][y];
					matrix[x][y] = 0;
				}
				System.out.println(dice[0]);
			}
		}

	}
	private static int[] throwTheDice(int[] dice, int direction){
		int[] thrownDice;
		switch (direction) {
			case 1:
				thrownDice = new int[]{dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]};
				break;
			case 2:
				thrownDice = new int[]{dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]};
				break;
			case 3:
				thrownDice = new int[]{dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]};
				break;
			default:
				thrownDice = new int[]{dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]};
		}
		return thrownDice;
	}

}
