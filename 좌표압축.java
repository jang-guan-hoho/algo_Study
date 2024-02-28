import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 좌표압축 {
	static int[] ans;
	static Integer[] arr;
	static int[] sortedArr;
	static int N;
	static Set<Integer> num;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		num = new HashSet<>();
		ans = new int[N];
		map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			// integer값은 음수 안됨
			num.add(a);
			ans[i] = a;
		}
		N = num.size();
		arr = num.toArray(new Integer[0]);
		sortedArr = new int[N];
		mergeSort(0, N - 1);
		sort();
		for (int i = 0; i < ans.length; i++) {
			sb.append(map.get(ans[i]) + " ");
		}
		System.out.println(Arrays.toString(sortedArr));
		System.out.println(sb);
	}

	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R])
				sortedArr[idx++] = arr[L++];
			else
				sortedArr[idx++] = arr[R++];
		}
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
	}

	static void sort() {
		for (int i = 0; i < sortedArr.length; i++) {
			map.put(sortedArr[i], i);
		}
	}
}
