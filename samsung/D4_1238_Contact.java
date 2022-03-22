package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238_Contact {

	static Queue<int[]> q = new LinkedList<>();

	static int TC, N, start, ans, size = 101;
	static int[][] graph;
	static boolean[] visited;
	static int[] node;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		TC = 10;

		for (int tc = 1; tc <= TC; tc++) {
			graph = new int[size][size];
			visited = new boolean[size];

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int from, to;
			for (int i = 0; i < N / 2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());

				graph[from][to] = 1;
			}

			dfs(start);
			bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
		}
		bw.flush();
	}

	public static void dfs(int s) {
		int level = 0;
		ans = 0;
		q.offer(new int[] { s, 0 });
		visited[s] = true;
		
		while (!q.isEmpty()) {
			node = q.poll();
			if (level != node[1]) {
				level++;
				ans = 0;
			}
			if (level == node[1]) {
				ans = Math.max(ans, node[0]);
			}
			for (int i = 1; i < size; i++) {
				if (graph[node[0]][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(new int[] { i, node[1] + 1 });
				}
			}

		}

	}

}
