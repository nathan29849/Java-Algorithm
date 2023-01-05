package thisiscodingtest.past.implementation;

public class 자물쇠와열쇠 {

	public static void main(String[] args) {
		자물쇠와열쇠 m = new 자물쇠와열쇠();
		boolean result = m.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
			new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
		System.out.println(result);
	}

	public boolean solution(int[][] key, int[][] lock) {
		int m = key.length;
		int n = lock.length;
		int matrixLength = 2*m + n;
		int lockX = m;
		int lockY = m;
		int[][] matrix = new int[matrixLength][matrixLength];

		init(matrix, lock, lockX, lockY);
		for (int k = 0; k < 4; k++) { // rotate 90º
			key = rotate90(key);
			for (int i = 1; i < matrixLength-m; i++) {
				for (int j = 1; j < matrixLength-m; j++) {
					unlock(matrix, key, i, j);
					if (check(matrix, lockX, lockY, n)) {
						return true;
					}
					reset(matrix, key, i, j);
				}
			}
		}


		return false;
	}

	public void print(int[][] key) {
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(key[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------");
	}

	public void init(int[][] matrix, int[][] lock, int lockX, int lockY) {
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				matrix[lockX + i][lockY + j] += lock[i][j];
			}
		}
	}

	public int[][] rotate90(int[][] key) {
		int[][] tmpKey = new int[key.length][key.length];

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				tmpKey[i][j] = key[j][(key.length-1)-i];
			}
		}
		return tmpKey;
	}

	public void unlock(int[][] matrix, int[][] key, int startX, int startY) {
		int x = key.length;
		int y = key[0].length;

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				matrix[startX + i][startY + j] += key[i][j];
			}
		}
	}

	public void reset(int[][] matrix, int[][] key, int startX, int startY) {
		int x = key.length;
		int y = key[0].length;

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				matrix[startX + i][startY + j] -= key[i][j];
			}
		}
	}

	public boolean check(int[][] matrix, int lockX, int lockY, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[lockX + i][lockY + j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

}
