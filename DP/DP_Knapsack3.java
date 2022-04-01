package DP;

import java.util.Scanner;

// 2022.04.01.
// DP 0-1 Knapsack 1차원 배열

public class DP_Knapsack3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 물건의 개수
        int W = sc.nextInt(); // 물건의 개수
        int[] weights = new int[N + 1]; // 물건의 무게
        int[] profits = new int[N + 1]; // 물건의 가치

        int[] D = new int[W + 1];
        // 물건 0일 때 모든 무게를 만족하는 최적값0: D[0][0~W]
        // 무게 0에 대해 모든 물건의 최적값0: D[0~N][0]

        // 물건 1부터 가방의 모든 무게에 대한 최적값 저장
        int before = 0, current = 1;
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                // 해당 물건의 무게로 w 가방에 가방을 담을 수 있다면
                D[w] = Math.max(D[w], D[w - weights[i]] + profits[i]);
            }
        }
        System.out.println(D[W]);
    }
}
