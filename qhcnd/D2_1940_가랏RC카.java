package qhcnd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D2_1940_가랏RC카 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int TC, N, distance, value, speed;
	static int arr[];
	public static void main(String[] args) throws Exception {
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc  <= TC; tc ++) {
			distance = speed = value = 0;
			N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				
				int command = Integer.parseInt(st.nextToken());
				switch(command) {
				case 1:
					value = Integer.parseInt(st.nextToken());
					speed += value; 
					break; // 가속
				case 2:
					value = Integer.parseInt(st.nextToken());
					speed -= value;
					if (speed < 0) speed = 0;
					break; // 감속
				}
				distance += speed; 
			}
			bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(distance)).append("\n");
		}
		bw.flush();
	}
}