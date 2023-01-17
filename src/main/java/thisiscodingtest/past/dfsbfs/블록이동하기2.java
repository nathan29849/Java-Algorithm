package thisiscodingtest.past.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기2 {

	int N;
	boolean[][] VISITED;
	int[][] BOARD;
	Queue<int[]> PQ = new LinkedList<>();;
	int[] DX = new int[]{-1, 1, 0, 0};
	int[] DY = new int[]{0, 0, -1, 1};
	int ANSWER = 0;
	boolean FLAG = true;
	public static void main(String[] args) {
		블록이동하기2 m = new 블록이동하기2();
		int result = m.solution(new int[][]{
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 1, 1, 1, 1, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1},
			{0, 0, 1, 1, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 1, 0}
		});
		System.out.println(result);
	}

	public int solution(int[][] board) {
		N = board.length;
		VISITED = new boolean[N][N];
		BOARD = board;
		PQ = new LinkedList<>();

		PQ.add(new int[]{0, 0, 0, 0, 1}); // dist, x1, y1, x2, y2
		VISITED[0][0] = true;
		VISITED[0][1] = true;
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

			// 상하좌우
			normalMove(x1, y1, x2, y2, d);

			// 회전
			rotateMove(x1, y1, x2, y2, d);

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
				if (VISITED[nx1][ny1] && VISITED[nx2][ny2]) {
					continue;
				}
				if (isBlank(nx1, ny1) && isBlank(nx2, ny2)) {
					if (isLast(nx1, ny1, nx2, ny2, d)) {
						return;
					}
					VISITED[nx1][ny1] = true;
					VISITED[nx2][ny2] = true;
					PQ.add(new int[]{d+1, nx1, ny1, nx2, ny2});

				}
			}
		}
	}

	private void rotateMove(int x1, int y1, int x2, int y2, int d) {
		// 회전
		int start, end;
		if (isVertical(x1, x2)) {
			start = 2;
			end = 4;
		} else {
			start = 0;
			end = 2;
		}
		int nx1, ny1, nx2, ny2;
		for (int i = start; i < end; i++) {
			nx1 = x1+DX[i];
			ny1 = y1+DY[i];
			nx2 = x2+DX[i];
			ny2 = y2+DY[i];
			if (rangeCheck(nx1, ny1) && rangeCheck(nx2, ny2)) {
				if (isBlank(nx1, ny1) && isBlank(nx2, ny2)) {
					if (!(VISITED[nx1][ny1] && VISITED[x1][y1])) {
						VISITED[nx1][ny1] = true;
						VISITED[x1][y1] = true;
						if (isLast(nx1, ny1, x1, y1, d)) {
							return;
						}
						PQ.add(new int[]{d+1, nx1, ny1, x1, y1});
					}

					if (!(VISITED[nx2][ny2] && VISITED[x2][y2])) {
						if (isLast(nx2, ny2, x2, y2, d)) {
							return;
						}
						VISITED[nx2][ny2] = true;
						VISITED[x2][y2] = true;
						PQ.add(new int[]{d+1, nx2, ny2, x2, y2});
					}
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
