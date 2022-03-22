package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_1289_원재의메모리복구하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			char[] str = br.readLine().toCharArray();
			int idx = 0, cnt = 0;
			for (int i = 0; i < str.length; i++) {
				if(str[i] == '1') {
					for (int j = i; j < str.length; j++) {
						str[j] ^= 1;
					}
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);	
		}
	}
}
