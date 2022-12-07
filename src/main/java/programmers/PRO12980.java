package programmers;

public class PRO12980 {

	public int solution(int n) {
		int answer = 0;
		String binaryString = Integer.toBinaryString(n);
		for (int i = 0; i < binaryString.length(); i++){

			if (binaryString.charAt(i) == '1') {
				answer++;
			}
		}

		return answer;
	}

}
