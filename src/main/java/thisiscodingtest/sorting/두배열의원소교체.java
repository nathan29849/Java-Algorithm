package thisiscodingtest.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두배열의원소교체 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arrA = new int[n];
		Integer[] arrB = new Integer[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}


		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrA);

		for (int i = 0; i < n; i++) {
			System.out.print(arrA[i]+" ");
		}

		System.out.println();

		Arrays.sort(arrB, Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			arrA[i] = arrB[i];
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arrA[i]+" ");
		}
		System.out.println();

		System.out.println(Arrays.stream(arrA).sum());
	}
//5 3
//1 2 5 4 3
//5 5 6 6 5
}
