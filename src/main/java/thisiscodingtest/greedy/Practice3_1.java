package thisiscodingtest.greedy;

public class Practice3_1 {

	public static void main(String[] args) {
		int n = 1260;
		int cnt = 0;

		int[] coinTypes = {500, 100, 50, 10};

		for (int coin : coinTypes) {
			cnt += n / coin;
			n %= coin;
		}

		System.out.println(cnt);

	}

}
