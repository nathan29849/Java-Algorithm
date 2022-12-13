package thisiscodingtest.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 상하좌우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Character> chars = new ArrayList<>();
		while (st.hasMoreTokens()) {
			chars.add(st.nextToken().charAt(0));
		}

		int[] now = {0, 0};
				//  R, L, D, U
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		char[] directions = {'R', 'L', 'D', 'U'};
		char direction;
		for (int i = 0; i < chars.size(); i++) {
			direction = chars.get(i);
			for (int j = 0; j < directions.length; j++) {
				if (directions[j] == direction) {
					if (checkDirection(new int[]{now[0] + dx[j], now[1] + dy[j]}, n)) {
						now = new int[]{now[0] + dx[j], now[1] + dy[j]};
					}
				}
			}
//			if (direction == 'R') {
//				if (checkDirection(new int[]{now[0] + dx[0], now[1] + dy[0]}, n)) {
//					now = new int[]{now[0] + dx[0], now[1] + dy[0]};
//				}
//			} else if (direction == 'L') {
//				if (checkDirection(new int[]{now[0] + dx[1], now[1] + dy[1]}, n)) {
//					now = new int[]{now[0] + dx[1], now[1] + dy[1]};
//				}
//			} else if (direction == 'D') {
//				if (checkDirection(new int[]{now[0] + dx[2], now[1] + dy[2]}, n)) {
//					now = new int[]{now[0] + dx[2], now[1] + dy[2]};
//				}
//			} else {
//				if (checkDirection(new int[]{now[0] + dx[3], now[1] + dy[3]}, n)) {
//					now = new int[]{now[0] + dx[3], now[1] + dy[3]};
//				}
//			}
		}
		System.out.println((now[0]+1)+" "+(now[1]+1));

	}

	private static boolean checkDirection(int[] newDirection, int n) {
		if (newDirection[0] < 0 || newDirection[1] < 0 || newDirection[0] >= n
			|| newDirection[1] >= n) {
			return false;
		}
		return true;
	}

}
