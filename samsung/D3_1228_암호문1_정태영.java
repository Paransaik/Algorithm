package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D3_1228_암호문1_정태영 {
	static int N, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < 10; ++i) {
			LinkedList<String> lst = new LinkedList<String>();
			LinkedList<String> o_queue = new LinkedList<String>();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) lst.add(st.nextToken());
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				st.nextToken();
				int start = Integer.parseInt(st.nextToken());
				for (int k = Integer.parseInt(st.nextToken()); k > 0; k--) {
					lst.add(start, st.nextToken());
					start += 1;
				}
			}
			bw.append("#" + (i + 1) + " ");
			for (int l = 0; l < 10; l++) bw.append(lst.removeFirst() + " ");
			bw.append("\n");
		}
		bw.flush();
	}
}