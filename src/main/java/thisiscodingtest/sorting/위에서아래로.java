package thisiscodingtest.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 위에서아래로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] numbers = new Integer[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(numbers, Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			System.out.print(numbers[i]+" ");
		}
	}

}
