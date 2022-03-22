package bytemark;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {
	// 3
	// 1 2 3
	static int N; // N이 32보다 작음
	static int[] input; // input : 입력수 배열, numbers : 선택수 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

//		1. 오름차순 정렬
		Arrays.sort(input);

		do {
			System.out.println(Arrays.toString(input));
		} while (np());
	}

	// 현재 자리에 수 뽑기
	public static boolean np() {
		// 1. 교환 위치 찾기
		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i]) --i;

		// i가 0과 같은 경우
		if (i == 0) return false;

		// 꼭대기를 찾은 경우
		// 2. 교환 위치에 교환할 값을 찾자
		int j = N - 1;
		while (input[i - 1] >= input[j]) --j;

		// 3. 교환 위치와 교환할 값 교환하기
		swap(i - 1, j);

		// 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순정렬)
		int k = N - 1;
		while (i < k) swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}