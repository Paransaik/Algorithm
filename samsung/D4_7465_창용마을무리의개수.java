package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수 {
	static int N, M;
	static int[] parents;

	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[N + 1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]); // path compression
	}

	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			makeSet();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for (int i = 1; i <= N; i++) {
				findSet(i);
			}
			Arrays.sort(parents);
			int pivot = parents[1];
			int result = 1;
			for (int i = 2; i <= N; i++) {
				if(parents[i] != pivot) {
					result++;
					pivot = parents[i];
				}
			}
			bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(result)).append("\n");
		}
		bw.flush();
		bw.close();
	}
}
