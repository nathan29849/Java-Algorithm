package programmers;

import java.util.*;

public class 큰수만들기 {

	public static void main(String[] args) {
		큰수만들기 m = new 큰수만들기();
		String result = m.solution("93939", 3);
		System.out.println(result);
	}

	public String solution(String number, int k) {
		List<Integer> stack = run(number, k);
		StringBuilder sb = new StringBuilder();
		for (int e:stack) {
			sb.append(e);
		}
		return sb.toString();
	}

	private List<Integer> run(String number, int k) {
		List<Integer> tmpStack = new ArrayList<>();
		int length = number.length();
		int targetLength = length - k;
		int i = 0;

		for (i = 0; i < length && k > 0; i++) {
			int n = number.charAt(i) - '0';

			// stack이 비어있는 경우 그냥 원소 추가
			if (tmpStack.isEmpty()) {
				tmpStack.add(n);
				continue;
			}
			int top = tmpStack.get(tmpStack.size()-1);

			// 만약 stack의 마지막 원소가 현재 숫자보다 작은 경우
			if (top < n) {
				while (k > 0 && !tmpStack.isEmpty()) {
					if (tmpStack.get(tmpStack.size()-1) < n) {
						tmpStack.remove(tmpStack.size()-1);
						k -= 1;
					} else {
						break;
					}
				}
			}
			tmpStack.add(n);
		}

		// 목표 길이보다 짧게 끝났을 경우
		if (targetLength > tmpStack.size()) {
			for (int j = i; j < length; j++) {
				tmpStack.add(number.charAt(j)-'0');
			}
		}

		// 목표 길이보다 더 길게 끝났을 경우
		if (tmpStack.size() > targetLength) {
			while (tmpStack.size() > targetLength) {
				tmpStack.remove(tmpStack.size()-1);
			}
		}

		return tmpStack;
	}
}
