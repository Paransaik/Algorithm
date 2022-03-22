package AdjMatrixTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1260_DFS와BFS3 {

	static int N, M, start;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		start = Integer.parseInt(st.nextToken()); // 시작 번호

		ArrayList<Integer>[] list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>(); // 정점 수 크기로 생선
		}

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			list[to].add(from);
			list[from].add(to);
		}

		for (ArrayList<Integer> it : list) {
			Collections.sort(it);
		}

//		for(int i = 0 ; i < 3; i ++) System.out.println(list[1].get(i));
//		for (ArrayList<Integer> it : list) {
//			for (Integer i : it) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		dfs(list, new boolean[N + 1], start);
		System.out.println();
		bfs(list, start);
	}

	public static void bfs(ArrayList<Integer>[] list, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
//			System.out.println((char) (current + 65));
			System.out.print(current + " ");
			for (int i = 0; i < list[current].size(); i++) {
				if (!visited[list[current].get(i)]) {
					queue.offer(list[current].get(i));
					visited[list[current].get(i)] = true;
				}
			}
		}
	}

	public static void dfs(ArrayList<Integer>[] list, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print((current) + " ");

		for (int i = 0; i < list[current].size(); i++) {
			if (!visited[list[current].get(i)]) {
				dfs(list, visited, list[current].get(i));
			}
		}
	}
}
