package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_2805_농작물수확하기_정태영 {
	static int N, sum;
	static int[][] board;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws IOException {
		int Tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < Tc; ++i) {
			sum = 0;
			String line;
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			for (int j = 0; j < N; j++) {
				line = br.readLine();
				for (int k = 0; k < N; k++) board[j][k] = Character.getNumericValue(line.charAt(k));
			}
			for (int x = 0; x < N / 2 + 1; x++) for (int y = N / 2 - x; y <= (x * 2) + (N / 2) - x; y++) sum += board[x][y];
			for (int x1 = N / 2 + 1; x1 < N; x1++) for (int y1 = x1 - N / 2; y1 <= (N - 2) - (x1 - (N / 2) - 1); y1++) sum += board[x1][y1];
			bw.append("#" + (i + 1) + " " + sum + "\n");
		}
		bw.flush();
		System.out.println();
	}
}