
public class 분할정복04_이진검색_재귀 {
	static int[] arr;
	static int key;
	
	public static void main(String[] args) {
		// 정렬된 상태라고 가정, 정렬을 따로 해줘야한다!!
		arr = new int[] {2, 4, 6, 8, 9, 17, 28};
		key = 8;
		System.out.println(binarySearch(0, 7));
		// st= 시작 인덱스, ed = 배열이 끝나는 인덱스
	}
	
	public static boolean binarySearch(int st, int ed) {
		if(st > ed) return false; // 못찾는 경우
		
		int mid = (st + ed) / 2;
		// 항목의 가운데 값을 설정
		// 이미 정렬이 되어 있다는 것을 명심하자!
		// 같다면
		if(arr[mid] == key) return true;
		// 크다면 (왼쪽으로)
		else if(arr[mid]>key) {
			return binarySearch(st, mid-1);
		}
		// 작다면 (오른쪽으로)
		else return binarySearch(mid+1, ed);
		
		
	}
}
