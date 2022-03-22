package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
프림
정점 중심 해결 -> 인접 행렬, 인접 리스트

정점수:
간선수: 간선리스트(크루스칼) 오버헤드 상승 따라서 간선이 적으면 크루스칼, 간선이 많으면 프림
-> 짜는 건 크루스칼이 쉬워서 둘다 가능하면 크루스칼 추천

 */
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
 */
public class MST2_PrimTest {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		int[][] adjMatrix = new int[N][N];
		int[] minEdge = new int[N]; // 타정점에서 자신으로의 간선비용 중 최소 비용
		boolean[] visited = new boolean[N]; // 신장트리에 선택된 여부

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		System.out.println(Arrays.toString(minEdge));
		
		int result = 0; // MST 비용
		minEdge[0] = 0;

		for (int c = 0; c < N; c++) { // N개의 정점을 모두 연결
			// 신장 트리에 연결되지 않은 장점 중 가장 유리한 비용의 정점을 선택
			int min = Integer.MAX_VALUE;
			int minVertex = 0;

			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
					System.out.println(Arrays.toString(minEdge));
				}
			}

			// 선택된 정점을 신장틜에 포함시킴
			visited[minVertex] = true;
			result += min;

			// 선택된 정점 기준으로 신장틜에 포함되지 않은 다른 정점으로의 간선비용을 따져보고 최솟값 갱신
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
			
		}
		System.out.println(result);
	}
}
