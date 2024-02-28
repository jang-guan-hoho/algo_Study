import java.util.Arrays;

public class 분할정복06_병합정렬 {
	static int[] arr = {5,3,6,1,7,4,8,2};
	
	static int[] sortedArr = new int[arr.length]; // 임시로 저장할 배열
	
	public static void main(String[] args) {
		System.out.println("정럴전 : "+Arrays.toString(arr));
		mergeSort(0, arr.length-1);
		System.out.println("정렬후 : "+Arrays.toString(arr));
	}
	
	static void mergeSort(int left, int right) {
		// if(left >= right) return ; 이렇게 컷 하거나
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽구간의 시작 표인트
		int R = mid+1; // 오른쪽구간의 시작 포인트
		int idx = left; // 정렬된 원소 저장할 위치
		
		// 서로 아직 비교할 수 있는 값들이 남아있을 경우
		while(L <= mid && R <= right) {
			if(arr[L]<=arr[R]) sortedArr[idx++] = arr[L++];
			else sortedArr[idx++] = arr[R++];
		}
		
		// 위에 결과로 sortedArr에 마지막 인덱스를 제외하고 정렬됨
		// 따라서 마지막 인덱스를 채워야한다.
		if(L <=mid) {
			for(int i=L;i<=mid;i++)
				sortedArr[idx++] = arr[i];
		}
		else {
			for(int i=R; i<=right; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		// 배열 갱신
		for(int i= left; i<=right;i++)
			arr[i] = sortedArr[i];
	}
}
