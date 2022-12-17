package financial;


/*
1. period(가입기간)이 23 미만인 경우 -> 제외
2. 원래 VIP였는지 아닌지 판별하기
	2-1. 23개월 < period < 60개월, 90만원 <= payment
	2-2. 60개월 <= period,  60만원 <= payment
3. VIP 아니었던 사람들 계산 (VIP가 되는 경우만)
	3-1. 23개월 < period+1 < 60개월, 90만원 <= payment[1:] + estimate
	3-2. 60개월 < period+1, 60만원 <= payment[1:] + estimate
4. VIP 였던 사람들 계산 (VIP가 되지 않는 경우만)
	3-1. 23개월 < period+1 < 60개월, 90만원 > payment[1:] + estimate
	3-2. 60개월 < period+1, 60만원 > payment[1:] + estimate
 */

/*
값 조건 : payment, estimate : 각 최대 100만
-> 12달이므로 최대 1200만임 : int 자료형 이용

 */
class Problem1 {
	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] answer = new int[]{0, 0};
		int n = periods.length;
		int paymentSum, nowPaymentSum, period;
		for (int i = 0; i < n; i++) {
			period = periods[i];
			paymentSum = 0;

			for (int p:payments[i]){
				paymentSum += p;
			}

			nowPaymentSum = paymentSum - payments[i][0] + estimates[i]; // 현재 금액

			if (checkVIP(period, paymentSum)){
				// 이전 달까지 VIP인 경우
				if (!checkVIP(period+1, nowPaymentSum)){
					answer[1]++;
				}
			} else {
				// 이전 달에 VIP가 아니었던 경우
				if (checkVIP(period+1, nowPaymentSum)){
					answer[0]++;
				}
			}
		}


		return answer;
	}

	private boolean checkVIP(int period, int paymentSum) {

		if (23 < period && period < 60 && 900000 <= paymentSum) {
			return true;
		}

		if (60 <= period && 600000 <= paymentSum) {
			return true;
		}

		return false;
	}
}

