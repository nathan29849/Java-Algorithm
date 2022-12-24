package programmers;

public class 푸드파이트대회 {

	public String solution(int[] food) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < food.length; i++) {
			sb.append(String.valueOf(i).repeat(food[i]/2));
		}

		String tmp = sb.toString();
		sb.append("0");
		for (int i = tmp.length()-1; i > -1; i--) {
			sb.append(tmp.charAt(i));
		}

		return sb.toString();
	}
}
