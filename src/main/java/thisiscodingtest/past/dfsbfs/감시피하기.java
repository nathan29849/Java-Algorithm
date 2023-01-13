package thisiscodingtest.past.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시피하기 {

	private static List<int[]> teachers = new ArrayList<>();
	private static List<int[]> blanks = new ArrayList<>();
	private static List<List<int[]>> barrier = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 빈칸 0, 학생 1, 선생 2, 장애물 3
			for (int j = 0; j < n; j++) {
				String s = st.nextToken();
				if (s.charAt(0) == 'X') {
					matrix[i][j] = 0;
					blanks.add(new int[]{i, j});
				} else if (s.charAt(0) == 'S') {
					matrix[i][j] = 1;
				} else {
					matrix[i][j] = 2;
					teachers.add(new int[]{i, j});
				}
			}
		}

		boolean flag = true;
		boolean[] visited = new boolean[blanks.size()];
		comb(0, new ArrayList<>(), visited);

		for (List<int[]> b : barrier) {
			for (int i = 0; i < 3; i++) {
				matrix[b.get(i)[0]][b.get(i)[1]] = 3;
			}
			flag = true;
			for (int[] teacher : teachers) {
				int x = teacher[0];
				int y = teacher[1];
				if (check(x, y, matrix)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				break;
			}
			for (int i = 0; i < 3; i++) {
				matrix[b.get(i)[0]][b.get(i)[1]] = 0;
			}
		}

		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean check(int x, int y, int[][] matrix) {
		for (int i = x + 1; i < matrix.length; i++) {
			if (matrix[i][y] == 1) {
				return true;
			} else if (matrix[i][y] == 3) {
				break;
			}
		}

		for (int i = y + 1; i < matrix.length; i++) {
			if (matrix[x][i] == 1) {
				return true;
			} else if (matrix[x][i] == 3) {
				break;
			}
		}

		for (int i = x - 1; i >= 0; i--) {
			if (matrix[i][y] == 1) {
				return true;
			} else if (matrix[i][y] == 3) {
				break;
			}
		}

		for (int i = y - 1; i >= 0; i--) {
			if (matrix[x][i] == 1) {
				return true;
			} else if (matrix[x][i] == 3) {
				break;
			}
		}

		return false;
	}

	private static void comb(int start, List<int[]> arr, boolean[] visited) {
		if (arr.size() == 3) {
			barrier.add(arr);
			return;
		}

		for (int i = start; i < blanks.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				List<int[]> tmp = new ArrayList<>(arr);
				tmp.add(blanks.get(i));
				comb(i + 1, tmp, visited);
				visited[i] = false;
			}
		}
	}

}
