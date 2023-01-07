package thisiscodingtest.past.implementation;

import java.util.*;

public class 기둥과보설치 {
	private static final List<int[]> result = new ArrayList<>();
	private static int[] nums = {};

	public static void main(String[] args) {

		기둥과보설치 m = new 기둥과보설치();
		int[][] ans = m.solution(5, new int[][]{
			{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4,
			2, 1, 1}, {3, 2, 1, 1}});
	}
	public int[][] solution(int n, int[][] build_frame) {
		int[][] matrix = new int[n+1][n+1]; // 기둥: 1, 보: 2, 둘다 설치: 3
		nums = new int[n+1];
		int t = n;
		for (int i = 0; i <= n; i++) {
			nums[i] = t;
			t--;
		}

		for (int i = 0; i < build_frame.length; i++) {
			construct(matrix, build_frame[i]);
		}

		result.sort(
			(o1, o2) -> {
				if (o1[0] == o2[0]) {
					if (o1[1] == o2[0]) {
						return o1[2] - o2[2];
					}
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		);

		int[][] answer = new int[result.size()][3];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}

	// 범위 체크
	private boolean checkRange(int[][] matrix, int x, int y) {
		return 0 <= x && x < matrix.length && 0 <= y &&  y < matrix.length;
	}

	// 기둥 조건 체크
	private boolean checkPillar(int[][] matrix, int[] frame) {
		int x = frame[0];
		int y = nums[frame[1]];
		int a = frame[2];
		int b = frame[3];

		// 바닥 위에 있는 경우
		if (frame[1] == 0 && checkRange(matrix, x, y) && (matrix[y][x] == 0 || matrix[y][x] == 2)) {
			return true;
		}
		// 보의 한쪽 끝 부분에 있는 경우
		if (checkRange(matrix, x-1, y)) {
			if (matrix[y][x-1] >= 2) {
				return true;
			}
		}

		// 다른 기둥 위에 있는 경우
		if (checkRange(matrix, x, y+1)) {
			if (matrix[y+1][x] == 1 || matrix[y+1][x] == 3) {
				return true;
			}
		}

		return false;
	}

	// 보 조건 체크
	private boolean checkBeam(int[][] matrix, int[] frame) {
		int x = frame[0];
		int y = nums[frame[1]];
		int a = frame[2];
		int b = frame[3];

		// 보 한쪽 끝 부분이 기둥 위에 있는 경우
		if (checkRange(matrix, x, y+1)) {
			if (matrix[y+1][x] == 1 || matrix[y+1][x] == 3) {
				return true;
			}
		}

		if (checkRange(matrix, x+1, y+1)) {
			if (matrix[y+1][x+1] == 1 || matrix[y+1][x+1] == 3) {
				return true;
			}
		}

		// 양쪽 끝 부분이 보인 경우
		if (checkRange(matrix, x-1, y) && checkRange(matrix, x+1, y)) {
			if (matrix[y][x-1] >= 2 && matrix[y][x+1] >= 2) {
				if (matrix[y][x] <= 1) {
					return true;
				}
			}
		}

		return false;
	}

	// 기둥 or 보 설치
	private void construct(int[][] matrix, int[] frame) {
		int x = frame[0];
		int y = nums[frame[1]];
		int a = frame[2];
		int b = frame[3];

		if (a == 0) { // 기둥
			if (b == 0) { // 삭제
				if (matrix[y][x] == 1 || matrix[y][x] == 3) {
					// 삭제 조건 체크
					if(checkPillar(matrix, frame) && checkBeam(matrix, frame) == false) {
						return;
					}

					matrix[y][x] -= 1;
					removeConstruction(x, frame[1], a);
				}
			} else { // 설치
				if (checkPillar(matrix, frame)) {
					matrix[y][x]++;
					result.add(new int[]{x, frame[1], a});
				}
			}
		} else { // 보
			if (b == 0) { // 삭제
				if (matrix[y][x] >= 2) {
					// 삭제 조건 체크
					if(checkPillar(matrix, frame) && checkBeam(matrix, frame) == false) {
						return;
					}

					matrix[y][x] -= 2;
					removeConstruction(x, frame[1], a);
				}
			} else { // 설치
				if (checkBeam(matrix, frame)) {
					matrix[y][x] += 2;
					result.add(new int[]{x, frame[1], a});
				}
			}
		}
	}

	private void removeConstruction(int x, int y, int a) {
		for (int i = 0; i < result.size(); i++) {
			int[] tmp = result.get(i);
			if (tmp[0] == x && tmp[1] == y && tmp[2] == a) {
				result.remove(i);
				break;
			}
		}
	}
}

// [[1,0,0,1],
//  [1,1,1,1],
//  [2,1,0,1],
//  [2,2,1,1],
//  [5,0,0,1],
//  [5,1,0,1],
//  [4,2,1,1],
//  [3,2,1,1]]

// [[1,0,0],
//  [1,1,1],
//  [2,1,0],
//  [2,2,1],
//  [3,2,1],
//  [4,2,1],
//  [5,0,0],
//  [5,1,0]]
