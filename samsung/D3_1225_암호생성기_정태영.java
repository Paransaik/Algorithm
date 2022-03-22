package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D3_1225_암호생성기_정태영 {
	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		for (int scenario = 1; scenario < 11; scenario++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int cnt = 0;
			int dummy = Integer.parseInt(br.readLine());
			String[] number = br.readLine().split(" ");
			for (int i = 0; i < 8; i++) queue.offer(Integer.parseInt(number[i]));
			
			int p;
			while (true) {
				p = queue.poll();
				cnt = (cnt % 5) + 1;
				if (p - cnt > 0) queue.offer(p - cnt);
				else {
					queue.offer(0);
					break;
				}
			}
			
			sb.append("#" + scenario + " ");
			for (int is : queue) sb.append(is + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
