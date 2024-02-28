import java.util.Arrays;

public class 분할정복07_퀵정렬_호어파티션 {
	static int[] arr= {5,22,32,26,57,19,32,55,84};
	public static void main(String[] args) {
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int left, int right) {
		if(left < right) {
			int pivot= partition(left, right);
			// 피봇을 설정 우리는 맨 왼쪽 요소를 피봇으로 했다.
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}

	private static int partition(int left, int right) {
		int pivot = arr[left];
		int L = left+1, R= right;
		// 우리가 왼쪽에 피봇을 설정 했으니 그보다 한칸 오른쪽에서 시작
		while(L<=R) {
			while(L<=R && arr[L] <=pivot) L++;
			// 값이 피봇보다 크거나 같으면
			while(arr[R]> pivot) R--;
			// 값이 피봇보다 작으면
			if(L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
			// 서로 교환
		}
		
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		return R;  // 피봇값의 위치
	}
}
