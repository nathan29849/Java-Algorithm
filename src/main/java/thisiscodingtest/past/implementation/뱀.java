package thisiscodingtest.past.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {

	public static void main(String[] args) throws IOException {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n]; // 0: blank, 1: snake, 2: apple
		board[0][0] = 1;
		// setting apple
		int k = Integer.parseInt(br.readLine());
		int x, y;
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			board[x-1][y-1] = 2;
		}

		// add to queue
		Queue<int[]> queue = new LinkedList<>();
		Deque<int[]> snakeQueue = new LinkedList();

		int l = Integer.parseInt(br.readLine());
		int sec;
		char direction;

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			sec = Integer.parseInt(st.nextToken());
			direction = st.nextToken().charAt(0);
			queue.add(new int[]{sec, direction - 'D'}); // 0: 오른쪽, 0이 아니면 왼쪽
		}

		// run
		int[] dx = new int[]{0, 1, 0, -1};
		int[] dy = new int[]{1, 0, -1, 0};
		int px = 0;
		int py = 0;
		int nx = 0;
		int ny = 0;
		snakeQueue.add(new int[]{0, 0});

		boolean flag = true;
		while (!queue.isEmpty() && flag) {
			int[] now = queue.poll();
			sec = now[0];
			while (answer < sec) {
				answer++;
				nx += dx[px];
				ny += dy[py];

				if (rangeCheck(board, nx, ny)) {
					if (appleCheck(board, nx, ny)) {
						board[nx][ny] = 1;
						snakeQueue.addFirst(new int[]{nx, ny});
						continue;
					}
					if (nonSnakeCheck(board, nx, ny)) {
						int[] delete = snakeQueue.pollLast();
						board[delete[0]][delete[1]] = 0;
						board[nx][ny] = 1;
						snakeQueue.addFirst(new int[]{nx, ny});
						continue;
					}
				}
				flag = false;
				break;
			}

			// 방향 전환
			if (now[1] == 0) {
				px += 1;
				py += 1;
			} else {
				px += 3;
				py += 3;
			}
			px %= 4;
			py %= 4;
		}

		while (flag) {
			answer++;
			nx += dx[px];
			ny += dy[py];
			if (rangeCheck(board, nx, ny)) {
				if (!nonSnakeCheck(board, nx, ny)) {
					flag = false;
				}
			} else {
				flag = false;
			}
		}

		System.out.println(answer);
	}

	private static boolean rangeCheck(int[][] board, int nx, int ny) {
		return 0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length;
	}

	private static boolean appleCheck(int[][] board, int nx, int ny) {
		return board[nx][ny] == 2;
	}

	private static boolean nonSnakeCheck(int[][] board, int nx, int ny) {
		return board[nx][ny] == 0;
	}

}


