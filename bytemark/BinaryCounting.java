package bytemark;

import java.util.Scanner;

public class BinaryCounting {
	static int N, input[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		generateSubset(input);

	}

	private static void generateSubset(int[] input) {
		int N = input.length; // 원소 수
		for (int flag = 0, caseCount = 1 << N; flag < caseCount; flag++) {
			// flag: 원소들의 선택상태의 비트열
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					System.out.print(input[i] + " ");
				}

			}
			System.out.println();
		}
	}

}
