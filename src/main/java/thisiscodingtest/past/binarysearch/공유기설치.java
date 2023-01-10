package thisiscodingtest.past.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);

		int start = 0;
		int end = nums[n - 1];
		int ans = 0;
		while (start < end) {
			int mid = (start + end) / 2;
			int cnt = check(nums, mid);
			if (cnt >= c) {
				start = mid+1;
				ans = mid;
			} else {
				end = mid;
			}
		}
		System.out.println(ans);
	}

	private static int check(int[] nums, int mid) {
		int cnt = 1;
		int pre = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[pre] >= mid) {
				pre = i;
				cnt++;
			}
		}
		return cnt;
	}
}


//9 3
//1
//2
//3
//4
//10
//20
//30
//40
//50
// 정답 : 20

//9 4
//1
//2
//3
//4
//10
//20
//30
//40
//50
// 정답 : 10

//3 3
//0
//1000
//1333
//333

//4 3
//11
//13
//16
//18
//2
