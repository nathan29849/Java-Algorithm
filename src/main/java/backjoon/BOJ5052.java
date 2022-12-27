package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ5052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());
			List<String> numbers = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				numbers.add(br.readLine());
			}

			if (check(numbers)){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean check(List<String> arr) {
		arr.sort(String::compareTo);
		String pre = arr.get(0);
		int preLength = pre.length();

		for (int i = 1; i < arr.size(); i++) {
			String now = arr.get(i);
			boolean flag = true;
			if (preLength < now.length()) {
				for (int j = 0; j < preLength; j++) {
					if (pre.charAt(j) != now.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					return false;
				}
			}
			pre = now;
			preLength = pre.length();
		}
		return true;
	}
}
