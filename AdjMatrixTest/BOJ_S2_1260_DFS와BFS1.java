package AdjMatrixTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1260_DFS와BFS1 {

	static int N, M, start;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		start = Integer.parseInt(st.nextToken()) - 1; // 시작 번호

		int[][] adjMatrix = new int[N][N]; // 정점 수 크기로 생선

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken()) - 1;
			to = Integer.parseInt(st.nextToken()) - 1;

			// 무향이므로 간선 하나로 양뱡향 처리
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}

		for (int[] is : adjMatrix) {
			System.out.println(Arrays.toString(is));
		}
		dfs(adjMatrix, new boolean[N], start);
		System.out.println();
		bfs(adjMatrix, start);
	}

	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
//			System.out.println((char) (current + 65));
			System.out.print((current + 1) + " ");
			// current 정점의 인접정점 처리(단, 방문하지 않는 인접정점만)
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[current][i] != 0) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}

	}

	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print((current + 1) + " ");

		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjMatrix[current][i] != 0) {
				dfs(adjMatrix, visited, i);
			}
		}
	}
}
