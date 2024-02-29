package 연습;

import java.util.Arrays;

public class 순열_2_swap {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		perm(0);
	}

	public static void perm(int idx) {
		// 기저 조건
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		// 재귀 조건
		for(int i = idx ; i < N ; i++) {
			// (i, idx)의 위치를 변경해줘야한다.
			swap(i, idx);
			perm(idx+1);
			// 원상 복구를 위해 다시 swap
			swap(i, idx);
		}
	}
	
	public static void swap(int i, int idx) {
		int tmp = nums[i];
		nums[i] = nums[idx];
		nums[idx] = tmp;
	}
}
