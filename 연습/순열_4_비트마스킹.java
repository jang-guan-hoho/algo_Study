package 연습;

import java.util.Arrays;

public class 순열_4_비트마스킹 {
	static int[] nums;
	static int N;
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		N = nums.length;
		result = new int[N];
	}
	
	// idx : 결과배열에 저장할 위치
	// visited : 사용한 원소를 기록하기 위한 정수
	static void perm(int idx, int visited) {
//		if(visited == (1<<N)-1) return;
		// 이렇게 조건 설정도 가능하다
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 모든 원소를 돌면서 판단 하겠다.
		for(int i = 0; i<N;i++) {
			if((visited & (1<<i)) != 0)continue;
			
			result[idx] = nums[i];
			// 썼다는 표시
			visited = visited | (1<<i);
			// 재귀
			perm(idx+1, visited);
			// 안썼다는 표시
		}
	}
}
