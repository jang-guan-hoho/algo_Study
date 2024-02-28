

public class 분할정복02_거듭제곱_재귀 {
	public static void main(String[] args) {
		int C = 2;
		int N = 20;

		System.out.println(pow(C, N));
		System.out.println(pow2(C, N));
	}
	
	public static int pow2(int C, int N) {
		// 기저조건
		if (N == 1)
			return C;
		
		int tmp;
		// 재귀 부분 : 짝수일때와 아닐때를 나누어서 생각 하겠다.
		if (N % 2 == 0) {
			tmp = pow2(C, N/2);// 절반의 값을 이미 구해놓고 그값을 곱한다!
			return tmp * tmp;
		} else {
			tmp = pow2(C, (N-1) /2);
			return tmp*tmp*C;
		}


	}
	
	

	
	
	

	public static int pow(int C, int N) {
		// 기저조건
		if (N == 1)
			return C;
		// 재귀 부분 : 짝수일때와 아닐때를 나누어서 생각 하겠다.
		if (N % 2 == 0) {
			return pow(C, N / 2) * pow(C, N / 2);
		} else {
			return pow(C, (N - 1) / 2) * pow(C, (N - 1) / 2)*C;
		}


	}
}
