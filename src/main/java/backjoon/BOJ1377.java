package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 버블 소트
public class BOJ1377 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int tmp = 0;
		boolean changed = false;
		for (int i = 0; i < n; i++) {
			changed = false;
			for (int j = 0; j < n-1; j++) {
				if (arr[j] > arr[j + 1]) {
					changed = true;
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			if (changed == false) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
