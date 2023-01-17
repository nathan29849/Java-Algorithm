package thisiscodingtest.past.dfsbfs;

import java.util.*;

public class 블록이동하기 {
	// visited 체크를 꼭 boolean으로 하지 않아도 된다.
	int N;
	int[][] VISITED;
	int[][] BOARD;
	Queue<int[]> PQ = new LinkedList<>();
	int[] DX = new int[]{-1, 0, 1, 0};
	int[] DY = new int[]{0, -1, 0, 1};
	int ANSWER = 0;
	boolean FLAG = true;
	public static void main(String[] args) {
		블록이동하기 m = new 블록이동하기();
		int result = m.solution(new int[][]{
			{0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 1, 1, 1},
			{0, 0, 0, 0, 0}
		});
//		int result = m.solution(new int[][]{
//			{0, 0, 0, 0, 0, 0, 0, 0, 0},
//			{1, 1, 1, 1, 1, 1, 1, 0, 0},
//			{1, 1, 1, 1, 1, 1, 1, 1, 0},
//			{0, 0, 0, 0, 0, 0, 0, 0, 0},
//			{0, 0, 1, 1, 1, 1, 1, 0, 0},
//			{0, 1, 1, 1, 1, 1, 1, 1, 1},
//			{0, 0, 1, 1, 1, 1, 1, 0, 0},
//			{0, 0, 0, 0, 0, 0, 0, 0, 0},
//			{1, 1, 1, 1, 1, 1, 1, 1, 0}
//		});
		System.out.println(result);
	}



	public int solution(int[][] board) {
		N = board.length;
		VISITED = new int[N][N];
		BOARD = board;

		PQ.add(new int[]{0, 0, 0, 0, 1}); // dist, x1, y1, x2, y2
		VISITED[0][0] = 3;
		VISITED[0][1] = 3;
		bfs();

		return ANSWER;
	}

	private void bfs() {
		while(!PQ.isEmpty() && FLAG) {
			int[] now = PQ.poll();
			int d = now[0];
			int x1 = now[1];
			int y1 = now[2];
			int x2 = now[3];
			int y2 = now[4];
			normalMove(x1, y1, x2, y2, d);
		}
	}

	private void normalMove(int x1, int y1, int x2, int y2, int d) {
		// 상하좌우
		int nx1, ny1, nx2, ny2;
		for (int i = 0; i < 4; i++) {
			nx1 = x1+DX[i];
			ny1 = y1+DY[i];
			nx2 = x2+DX[i];
			ny2 = y2+DY[i];
			if (rangeCheck(nx1, ny1) && rangeCheck(nx2, ny2)) {
				if (VISITED[nx1][ny1] > 2 && VISITED[nx2][ny2] > 2){
					continue;
				}

				if (isBlank(nx1, ny1) && isBlank(nx2, ny2)) {
					PQ.add(new int[]{d+1, nx1, ny1, nx2, ny2});
					if (isVertical(x1, x2)) { // 세로
						if (i % 2 != 0) { // 횡 이동 (회전 가능 여부 체크)
							PQ.add(new int[]{d+1, x1, y1, nx1, ny1});
							PQ.add(new int[]{d+1, x2, y2, nx2, ny2});
						}
					} else {	// 가로
						if (i % 2 == 0) { // 수직 이동 (회전 가능 여부 체크)
							PQ.add(new int[]{d+1, x1, y1, nx1, ny1});
							PQ.add(new int[]{d+1, x2, y2, nx2, ny2});
						}
					}
					if (isLast(nx1, ny1, nx2, ny2, d)) {
						return;
					}
					VISITED[nx1][ny1] += 1;
					VISITED[nx2][ny2] += 1;
				}
			}
		}
	}
	private boolean rangeCheck(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
	private boolean isBlank(int nx, int ny) {
		return BOARD[nx][ny] == 0;
	}
	private boolean isVertical(int x1, int x2) {
		return Math.abs(x1 - x2) != 0;
	}

	private boolean isLast(int x1, int y1, int x2, int y2, int d) {
		if ((x1 == N-1 && y1 == N-1) || (x2 == N-1 && y2 == N-1)) {
			ANSWER = d+1;
			FLAG = false;
			return true;
		}
		return false;
	}
}

/*

input :
[[0, 0, 0, 0, 0, 0, 1],
 [1, 1, 1, 1, 0, 0, 1],
 [0, 0, 0, 0, 0, 0, 0],
 [0, 0, 1, 1, 1, 1, 0],
 [0, 1, 1, 1, 1, 1, 0],
 [0, 0, 0, 0, 0, 1, 1],
 [0, 0, 1, 0, 0, 0, 0]]
result : 21

input : [[0, 0, 0, 0, 0, 0, 1], [1, 1, 1, 1, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0], [0, 0, 1, 1, 1, 0, 0], [0, 1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 1, 0], [0, 0, 1, 0, 0, 0, 0]]
result : 11

input:
[[0, 0, 0, 0, 0, 0, 0, 0, 0],
 [1, 1, 1, 1, 1, 1, 1, 0, 0],
 [1, 1, 1, 1, 1, 1, 1, 1, 0],
 [0, 0, 0, 0, 0, 0, 0, 0, 0],
 [0, 0, 1, 1, 1, 1, 1, 0, 0],
 [0, 1, 1, 1, 1, 1, 1, 1, 1],
 [0, 0, 1, 1, 1, 1, 1, 0, 0],
 [0, 0, 0, 0, 0, 0, 0, 0, 0],
 [1, 1, 1, 1, 1, 1, 1, 1, 0]]
result : 33

*/
