package 연습;

import java.util.Arrays;

public class 순열_3_방문체크 {
	static int[] nums;
	static int N;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2, };
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		
		perm(0);

	}

	// idx : 결과 배열에 저장할 위치
	static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// N개의 원소를 가지고 판단하려한다
		for (int i = 0; i < N; i++) {
			if(visited[i]) {
				// 방문했으면 아래 코드를 실행하지 않는다
				continue;
			}
			result[idx] = nums[i];
			visited[i] = true;
			
			// 다음 자리 판단
			perm(idx+1);
			// 방문 초기화
			visited[i] = false;
//			result[idx] = 0; 이렇게 초기화를 안하는 이유 : 어저피 값이 덮어진다.
			
		}
	}
}
