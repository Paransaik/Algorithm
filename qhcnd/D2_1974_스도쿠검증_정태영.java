package qhcnd;

import java.util.HashSet;
import java.util.Scanner;

public class D2_1974_스도쿠검증_정태영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			// 1. 입력
			int[][] map = new int[9][9];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//			System.out.println(Arrays.deepToString(map));
			// 2. 체크
			int result = check(map);

			// 3. 결과 출력
			System.out.println("#" + tc + " " + result);
		}

	}

	// 전달된 배열 조사
	public static int check(int[][] map) {
		// HashSet 사용, 중복 x
		HashSet<Integer> set = new HashSet<>();

		// 행 체크
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				set.add(map[i][j]);
			}
			if (set.size() < 9) {
				return 0;
			}
			set.clear();
		}

		// 열 체크
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				set.add(map[j][i]);
			}
			if (set.size() < 9) {
				return 0;
			}
			set.clear();
		}

		// 작은 사각형
		for (int i = 0; i < 3; i++) { // 큰 사각형 행
			for (int j = 0; j < 3; j++) { // 큰 사각형 열
				for (int k = 0; k < 3; k++) { // 작은 사각형 행
					for (int l = 0; l < 3; l++) {
						set.add(map[i * 3 + k][j * 3 + l]);
					}
				}
				if (set.size() < 9) {
					return 0;
				}
				set.clear();
			}
		}
		return 1;
	}
}
