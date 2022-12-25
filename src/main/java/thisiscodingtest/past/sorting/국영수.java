package thisiscodingtest.past.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 국영수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			people.add(new Person(name, k, e, m));
		}

//		people.sort((o1, o2) -> {
//			if (o2.k > o1.k) {
//				return 1;
//			} else if (o2.k < o1.k) {
//				return -1;
//			} else {
//				if (o1.e > o2.e) {
//					return 1;
//				} else if (o1.e < o2.e) {
//					return -1;
//				} else {
//					if (o2.m > o1.m) {
//						return 1;
//					} else if (o2.m < o1.m) {
//						return -1;
//					} else {
//						if (o1.name.compareTo(o2.name) > 0) {
//							return 1;
//						} else {
//							return -1;
//						}
//					}
//				}
//			}
//		});

		people.sort(
			(o1, o2) ->
			{
				if (o1.k == o2.k) {
					if (o1.e == o2.e) {
						if (o1.m == o2.m) {
							return o1.name.compareTo(o2.name);
						}
						return o2.m - o1.m;
					}
					return o1.e - o2.e;
				}
				return o2.k - o1.k;
			}
		);

		for (Person p:people) {
			System.out.println(p.name);
		}
	}

	static class Person {

		String name;
		int k;
		int e;
		int m;

		public Person(String name, int k, int e, int m) {
			this.name = name;
			this.k = k;
			this.e = e;
			this.m = m;
		}
	}

}
