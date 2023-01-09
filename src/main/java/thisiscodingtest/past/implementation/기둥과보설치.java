package thisiscodingtest.past.implementation;

import java.util.*;

public class 기둥과보설치 {

	public static void main(String[] args) {

		기둥과보설치 m = new 기둥과보설치();
		int[][] ans = m.solution(5, new int[][]{
			{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4,
			2, 1, 1}, {3, 2, 1, 1}});
		System.out.println(ans);

	}

	public int[][] solution(int n, int[][] build_frame) {
		List<int[]> arr = new ArrayList<>();

		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];

			if (b == 0) { // destroy
				arr.removeIf(
					o -> (o[0] == x && o[1] == y && o[2] == a)
				);
				if (!checkAvailable(arr)) {
					arr.add(new int[]{x, y, a});
				}
			} else {      // build
				arr.add(new int[]{x, y, a});
				if (!checkAvailable(arr)) {
					arr.remove(arr.size()-1);
				}
			}
		}
		arr.sort(
			(o1, o2) -> {
				if (o1[0] == o2[0]) {
					if (o1[1] == o2[1]) {
						return o1[2] - o2[2];
					}
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		);

		int[][] answer = new int[arr.size()][3];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}

	private boolean checkAvailable(List<int[]> arr) {

		for (int i = 0; i < arr.size(); i++) {
			int x = arr.get(i)[0];
			int y = arr.get(i)[1];
			int z = arr.get(i)[2];
			if (z == 0) { // 기둥
				if (y == 0 || available(arr, x-1, y, 1) ||
					available(arr, x, y, 1) ||
					available(arr, x, y-1, 0)) {
					continue;
				} else {
					return false;
				}
			} else { // 보
				if (available(arr, x, y-1, 0) ||
					available(arr, x+1, y-1, 0) ||
					(available(arr, x-1, y, 1) && available(arr, x+1, y, 1))) {
					continue;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	private boolean available(List<int[]> arr, int x, int y, int z) {
		for (int[] a:arr) {
			if (a[0] == x && a[1] == y && a[2] == z) {
				return true;
			}
		}
		return false;
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
