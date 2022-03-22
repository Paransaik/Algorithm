package samsung;

import java.io.*;
import java.util.stream.Stream;

public class TE_4012_요리사_정태영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int TC, N, ans;
	static int[][] board;
	static String line;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			ans = 20000;
			N = Integer.parseInt(br.readLine());
			board = new int[N][];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				line = br.readLine();
				board[i] = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			combination(0, 0);
			bw.append("#" + tc + " " + ans + "\n");
		}
		bw.flush();
	}
	public static void combination(int cnt, int start) {
		if (start >= N || cnt > N / 2) return;
		if (cnt == N / 2) {
			int vS = 0, nvS = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					for (int j = 0; j < N; j++) if (visited[j]) vS += board[i][j];
				} else {
					for (int j = 0; j < N; j++) if (!visited[j]) nvS += board[i][j];
				}
			}
			ans = Math.min(ans, Math.abs(vS - nvS));
			return;
		}
		visited[start] = true;
		combination(cnt + 1, start + 1);
		visited[start] = false;
		combination(cnt, start + 1);
	}
}