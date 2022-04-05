package DP;

import java.util.Scanner;

/*
4
0 2 0 15
0 0 10 4
3 0 0 0
0 0 7 0

==>
0	2	12	6
13	0	10	4
3	5	0	9
10	12	7	0


5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
2 0 0 0 2
0 3 3 1 0

==>
0	4	2	3	4
2	0	1	2	3
1	3	0	1	2
2	5	4	0	2
3	3	3	1	0


5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
-2 0 0 0 2
0 -3 3 1 0

==>
0	1	2	3	4
0	0	1	2	3
-1	-1	0	1	2
-2	-1	0	0	2
-3	-3	-2	-1	0

5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
-8 0 0 0 2
0 -9 3 1 0

==>
0	-12	-14	-8	-1
-17	0	-15	-9	-2
-18	-14	0	-10	-3
-19	-15	-17	0	-4
-15	-11	-13	-7	0
 */
public class DP_FloydWarshall {
    static final int INF = 9999999;
    static int N, adjMatrix[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adjMatrix = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                adjMatrix[i][j] = sc.nextInt();
                if (i != j && adjMatrix[i][j] == 0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
                    adjMatrix[i][j] = INF;
                }
            }
        }
        System.out.println("===========입력==========");
        print();
        // 출발지-->경유지-->목적지로 3중 루프 돌리면 오답
        // 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                if (i == k) continue; // 출발지와 경유지가 같다면 다음 출발지
                for (int j = 0; j < N; ++j) {
                    if (i == j || k == j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
                    // 간선이 양수이면 위의 if 2개(continue) 빼도 됨
                    // 양의 간선일때만 동작, 간선이 음수이면 갈 수 있는지 - + INF = 값이 나올 수 있음! 조건검사 해야 됨
                    if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                    }
                }
            }
            print();
        }

    }

    private static void print() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(adjMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=====================================");

    }
}
