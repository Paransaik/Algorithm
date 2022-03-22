package backtraking;

import java.util.Scanner;

// 부분집합 합 문제
public class SubSetTest {

	static int N, S, input[], ans;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 집합의 크기
		S = sc.nextInt(); // 목표 합
		ans = 0;
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println(ans);
	}

	// 5 0
	// -7 -3 -2 5 8
	public static void generateSubset(int cnt) { // 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수

		if (cnt == N) { // 마지막 원소까지 부분집합에 다 고려된 상황
			int sum = 0;
			int elementCnt = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += input[i];
					elementCnt++;
				}
			}

			if (sum == S && elementCnt > 0) {
				++ans;
				for (int i = 0; i < N; i++) {
					System.out.print(isSelected[i] ? input[i] + " " : "");
				}
				System.out.println();
			}
			return;
		}
		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
}
