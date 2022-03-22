package bytemark;

import java.util.Arrays;
import java.util.Scanner;

//nPr
//n개의 수 입력받아 처리
public class PermutationTest {

	static int N, R; // N이 32보다 작음
	static int[] input, numbers; // input : 입력수 배열, numbers : 선택수 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N];
		numbers = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		permutation(0, 0);
		sc.close();
	}

	// 현재 자리에 수 뽑기
	public static void permutation(int cnt, int flag) { // cnt: 직전까지 뽑은 수 개수

		// # 기본파트
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// # 유도파트
		// 입력받은 모든 수를 현재 자리에 넣어보기
		for (int i = 0; i < N; i++) {
			// 기존자리의 수들과 중복되는지 체크
			if ((flag & 1 << i) != 0)
				continue;

			numbers[cnt] = input[i]; // 다음수 뽑으러 가기
			permutation(cnt + 1, flag | 1 << i);
		}
	}
}