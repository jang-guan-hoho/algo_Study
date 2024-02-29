package 연습;

import java.util.Scanner;

public class N_Queen {
	static int N;
	static int[][] map;
	static boolean[] ans;
	static int[] nr = { -1, 1, -1, 1 };
	static int[] nc = { -1, 1, 1, -1 };
	static int cnt = 0;
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			map = new int[N][N];
			ans = new boolean[N * N];
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					setting(r, c);
//				}
//			}
			setting(0,0);
			System.out.println("#" + test + " ");
		}
	}

	static void setting(int r, int c) {
		if (cnt>=N) {
			cnt=0;
			result++;
			return;
		}
		if (map[r][c] == 0) {
			cnt++;
			map[r][c] = 1;
			for (int j = 0; j < N; j++) {
				map[r][j] = 1;
			}
			for (int j = 0; j < N; j++) {
				map[j][c] = 1;
			}
			for (int j = 0; j < 4; j++) {
				int l = 1;
				int dr = r + nr[j] * l;
				int dc = c + nc[j] * l;
				while (dr < N && dr >= 0 && dc < N && dc >= 0) {
					map[dr][dc] = 1;
					dr = r + nr[j] * l;
					dc = c + nc[j] * l;
					l++;
				}
			}
			setting(r+2, c+1);
			setting(r+1, c+2);
			
		}
		return;
	}

	
}
