package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D3_9229_한빈이와SpotMart_정태영 {

	static int M, N, cnt, r;
	static int[] numbers, input;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static ArrayList<Integer> lst = new ArrayList<Integer>();
	
	public static void main(String args[]) throws IOException {

		int Tc = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 0; i < Tc; ++i) {
			lst.clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 문자 개수
			M = Integer.parseInt(st.nextToken()); // 최대 무게
			r = 2;
			input = new int[N];
			numbers = new int[r];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) input[j] = Integer.parseInt(st.nextToken());

			dfs(0, 0);

			if (lst.isEmpty()) bw.append("#" + i + " -1\n");
			else bw.append("#" + (i + 1) + " " + Collections.max(lst) + "\n");
		}
		bw.flush();
		System.out.println();
	}

	public static void dfs(int cnt, int start) throws IOException {
		if (cnt == r) {
			if (Arrays.stream(numbers).sum() <= M) lst.add(Arrays.stream(numbers).sum());
			return;
		}
		for (int j = start; j < N; j++) {
			numbers[cnt] = input[j];
			dfs(cnt + 1, j + 1);
		}
	}
}