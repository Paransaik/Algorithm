package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D5_1247_최적경로_정태영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int TC, N, ans;

	static boolean[] isSelected;
	static int[] numbers;
	static int[][] coor;

	public static void main(String[] args) throws Exception {
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			coor = new int[N + 2][2];
			numbers = new int[N + 2];
			isSelected = new boolean[N + 2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				coor[i][0] = Integer.parseInt(st.nextToken());
				coor[i][1] = Integer.parseInt(st.nextToken());
			}
			permutation(2);
			bw.append("#").append(tc + " ").append(ans + "\n");
		}
		bw.flush();
	}

	public static void permutation(int cnt) {
		int sum = 0;
		if (cnt == N + 2) {
			for (int i = 2; i < N + 1; i++) {
				sum += Math.abs(coor[numbers[i]][0] - coor[numbers[i + 1]][0])
						+ Math.abs(coor[numbers[i]][1] - coor[numbers[i + 1]][1]);
			}
			sum += Math.abs(coor[0][0] - coor[numbers[2]][0]) 
					+ Math.abs(coor[0][1] - coor[numbers[2]][1]);
			sum += Math.abs(coor[1][0] - coor[numbers[N + 1]][0]) 
					+ Math.abs(coor[1][1] - coor[numbers[N + 1]][1]);

			ans = Math.min(sum, ans);
			return;
		}
		for (int i = 2; i < N + 2; i++) {
			if (isSelected[i])continue;

			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}