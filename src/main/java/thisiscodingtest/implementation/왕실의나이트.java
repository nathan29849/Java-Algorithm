package thisiscodingtest.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] target = new int[]{s.charAt(0)-'a', s.charAt(1)-'1'};

		int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
		int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
		int nx, ny;
		int answer = 0;
		for (int j = 0; j < 8; j++) {
			nx = target[0] + dx[j];
			ny = target[1] + dy[j];
			if (checkToMove(new int[]{nx, ny})){
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static boolean checkToMove(int[] next) {
		if (next[0] < 0 || next[1] < 0 || next[0] > 7 || next[1] > 7) {
			return false;
		}
		return true;
	}

}
