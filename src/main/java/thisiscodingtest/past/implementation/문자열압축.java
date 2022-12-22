package thisiscodingtest.past.implementation;

public class 문자열압축 {

	public static void main(String[] args) {
		문자열압축 m = new 문자열압축();
		int result = m.solution("aabbaccc");
		System.out.println(result);
	}

	public int solution(String s) {
		int answer = s.length();
		int length = s.length();
		StringBuilder sb;
		for (int i = 1; i <= length/2; i++) {

			int cnt = 1;
			String pre = s.substring(0, i);
			sb = new StringBuilder();
			int j = length;
			for (j = i; j <= length-i; j+=i) {
				String substring = s.substring(j, j + i);
				if (pre.equals(substring)) {
					cnt++;
				} else {
					if (cnt != 1){
						sb.append(cnt);
					}
					sb.append(pre);
					pre = substring;
					cnt = 1;
				}
			}
			if (cnt != 1){
				sb.append(cnt);
			}
			sb.append(pre);
			sb.append(s.substring(j));
			answer = Math.min(sb.length(), answer);
		}

		return answer;
	}
}
