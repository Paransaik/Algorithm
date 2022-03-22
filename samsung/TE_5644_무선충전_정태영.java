package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class TE_5644_무선충전_정태영 {
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int TC, M, A, ans;
    static int xA, yA, xB, yB;
    static int[] userA, userB;
    static int[][] map;
    static int[][] Ap;
    static int[][] moves = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= TC; tc++) {
        	ans = 0;
            int size = 11;
            map = new int[size][size];

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            userA = new int[M];
            userB = new int[M];

            Ap = new int[A][4];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                userA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                userB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                Ap[i][0] = Integer.parseInt(st.nextToken());
                Ap[i][1] = Integer.parseInt(st.nextToken());
                Ap[i][2] = Integer.parseInt(st.nextToken());
                Ap[i][3] = Integer.parseInt(st.nextToken());
            }
            xA = 1; yA = 1; xB = 10; yB = 10; 
            for (int i = 0; i <= M; i++) {
                int sum = 0;
                for (int j = 0; j < A; j++) {
                    for (int k = 0; k < A; k++) {
                        if (!isValidRangeA(Ap[j]) && !isValidRangeB(Ap[k])) continue;
                        if (j == k) {   // 같은 AP 를 바라볼 때
                            sum = Math.max(sum, Ap[j][3]);
                        } else if (isValidRangeA(Ap[j]) && isValidRangeB(Ap[k])) {
                            sum = Math.max(sum, Ap[j][3] + Ap[k][3]);
                        } else if (isValidRangeA(Ap[j])) {
                            sum = Math.max(sum, Ap[j][3]);
                        } else {
                            sum = Math.max(sum, Ap[k][3]);
                        }
                    }
                }

                ans += sum;
                if (i != M) {
                    xA += moves[userA[i]][0];
                    yA += moves[userA[i]][1];
                    xB += moves[userB[i]][0];
                    yB += moves[userB[i]][1];
                }
            }
            bw.append("#").append(tc + " ").append(ans + "\n");
        }
        bw.flush();
    }

    private static boolean isValidRangeA(int[] ap) {
        return Math.abs(xA - ap[0]) + Math.abs(yA - ap[1]) <= ap[2];
    }

    private static boolean isValidRangeB(int[] ap) {
        return Math.abs(xB - ap[0]) + Math.abs(yB - ap[1]) <= ap[2];
    }
}