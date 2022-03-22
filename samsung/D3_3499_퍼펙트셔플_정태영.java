package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_3499_퍼펙트셔플_정태영 {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws IOException {
		int Tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < Tc; ++i) {
			Queue<String> e_queue = new LinkedList<String>();
			Queue<String> o_queue = new LinkedList<String>();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				if (N % 2 == 0) {
					if (j < N / 2) e_queue.offer(st.nextToken());
					else o_queue.offer(st.nextToken());
				} else {
					if (j < N / 2 + 1) e_queue.offer(st.nextToken());
					else o_queue.offer(st.nextToken());
				}
			}
			for (int j = 0; j < N; ++j) {
				if (j % 2 == 0) e_queue.offer(e_queue.poll());
				else e_queue.offer(o_queue.poll());
			}
			bw.append("#" + (i + 1) + " ");
			for (String s : e_queue) bw.append(s + " ");
			bw.append("\n");
		}
		bw.flush();
	}
}