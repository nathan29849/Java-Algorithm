package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] matrix = new int[str2.length()+1][str1.length()+1];
		for (int i = 0; i <= str2.length(); i++) {
			for (int j = 0; j <= str1.length(); j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else if (str2.charAt(i-1) == str1.charAt(j-1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				}
			}
		}

		System.out.println(matrix[str2.length()][str1.length()]);

	}

//AAACATCGT
//TACCTAAAA

}
