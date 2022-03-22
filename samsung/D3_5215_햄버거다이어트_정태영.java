package samsung;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
//
//public class D3_5215_햄버거다이어트_정태영 {
//	static StringBuffer sb = new StringBuffer();
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//	static int TC, N, L;
//	static int[] nArr, lArr;
//
//	public static void main(String args[]) throws Exception {
//		StringTokenizer st;
//		TC = Integer.parseInt(br.readLine());
//
//		for (int tc = 1; tc <= TC; tc++) {
//			st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			L = Integer.parseInt(st.nextToken());
//			nArr = lArr = new int[N];
//
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				nArr[i] = Integer.parseInt(st.nextToken());
//				lArr[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			bw.append('\n');
//		}
//		bw.flush();
//	}
//}

import java.io.FileInputStream;
import java.util.Scanner;

public class D3_5215_햄버거다이어트_정태영 {

	static int bestScore = 0;
	static int T, N, L;
	static int arr[][];

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][2];

			for (int i = 0; i < arr.length; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}

			bestScore = 0;
			getBestHamburger(0, 0, 0);

			System.out.printf("#%d %d\n", test_case, bestScore);
			System.out.println(cnt);
		}

		sc.close();

	}

	static int cnt = 0;
	public static void getBestHamburger(int cur, int score, int calorie) {
		cnt++;
		if (N == cur) {
			bestScore = Math.max(bestScore, score);
			return;
		}

		// 재료 추가시 점수와 칼로리가 증가한다.
		int newScore = score + arr[cur][0];
		int newCalorie = calorie + arr[cur][1];

		getBestHamburger(cur + 1, score, calorie);
		// 새칼로리 불만족이면 안들어감~
		if (newCalorie <= L) {
			getBestHamburger(cur + 1, newScore, newCalorie);
		}
	}

}
