package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1043 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] parents = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int k;
		k = Integer.parseInt(st.nextToken());
		if (k == 0) {
			System.out.println(m);
			return;
		}

		List<Integer> truth = new ArrayList<>();
		while (st.hasMoreTokens()) {
			truth.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer[]> meetings = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			Integer[] tmp = new Integer[num];
			for (int j = 0; j < num; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(tmp);
			for (int j = 1; j < tmp.length; j++) {
				unionParent(parents, tmp[j-1], tmp[j]);
			}
			meetings.add(tmp);
		}

		Set<Integer> truthMember = new HashSet<>();
		for (int i : truth) {
			truthMember.add(getParent(parents, i));
		}
		int answer = 0;
		for (Integer[] t : meetings) {
			if (!truthMember.contains(getParent(parents, t[0]))) {
				answer += 1;
			}
		}
		System.out.println(answer);

	}

	private static int getParent(int[] parents, int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = getParent(parents, parents[x]);
	}

	private static void unionParent(int[] parents, int a, int b) {
		a = getParent(parents, a);
		b = getParent(parents, b);
		if (a < b) {
			parents[b] = a;
			return;
		}
		parents[a] = b;
	}

	private static int findParent(int[] parents, int a, int b) {
		a = getParent(parents, a);
		b = getParent(parents, b);
		if (a == b) {
			return 1;
		}
		return 0;
	}

}
