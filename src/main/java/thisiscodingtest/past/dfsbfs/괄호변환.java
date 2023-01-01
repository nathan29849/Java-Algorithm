package thisiscodingtest.past.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class 괄호변환 {

	public static void main(String[] args) {
		괄호변환 m = new 괄호변환();
		String result = m.solution("(()())()");
		System.out.println(result);
	}

	public String solution(String p) {
		return check(p);
	}

	private String check(String tmp) {

		if (tmp.length() == 0) {
			return tmp;
		}

		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();
		boolean flag  = true;
		int left = 0;
		int right = 0;

		for (int i = 0; i < tmp.length(); i++) {
			if (flag) {
				if (tmp.charAt(i) == '(') {
					left++;
				} else {
					right++;
				}
				u.append(tmp.charAt(i));

				if (left == right) {
					flag = false;
				}
			} else {
				v.append(tmp.charAt(i));
			}
		}
		System.out.println("u:"+u);
		System.out.println("v:"+v);

		if (checkProperString(u.toString())) {
			u.append(check(v.toString()));
			return u.toString();
		}

		return makeProperString(u.toString(), v.toString());
	}

	private String makeProperString(String u, String v) {
		StringBuilder sb = new StringBuilder();
		sb.append('(');
		sb.append(check(v));
		sb.append(')');
		for (int i = 1; i < u.length()-1; i++) {
			if (u.charAt(i) == '(') {
				sb.append(')');
				continue;
			}
			sb.append('(');
		}
		return sb.toString();
	}

	private boolean checkProperString(String u) {
		List<Character> q = new ArrayList<>();
		for (int i = 0; i < u.length(); i++) {
			if (q.isEmpty()) {
				q.add(u.charAt(i));
				continue;
			}

			if (q.get(q.size()-1) =='(' && u.charAt(i) == ')') {
				q.remove(q.size()-1);
				continue;
			}
			q.add(u.charAt(i));
		}

		if (q.isEmpty()) {
			return true;
		}
		return false;
	}
}
