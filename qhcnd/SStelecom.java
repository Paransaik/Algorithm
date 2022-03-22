package qhcnd;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SStelecom {
/*
#1 2
#2 4
#3 6
#4 4
#5 1
#6 11
#7 81
#8 0
#9 0
#10 0

 */
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(src);

		int Tc = sc.nextInt();
		for (int tc = 1; tc <= Tc; tc++) {
			int answer = 0;// 답
			int N = sc.nextInt();// 배열크기

			char[][] map = new char[N][N];// 입력데이터가 저장될 배열

			// 1. 입력
			for (int i = 0; i < N; i++) {// 행
				String line = sc.next();// 한줄 읽기. XXXXX

				for (int j = 0; j < N; j++) {// 열
					map[i][j] = line.charAt(j);// i 행 j열에 값 넣기
				}
			}
			// 2.배열에서 기지국 종류별로 커버되는 영역 표시
			for (int i = 0; i < N; i++) {// 행
				for (int j = 0; j < N; j++) {// 열
					char c = map[i][j];// 한글자 꺼내고

					int cnt = 0;// 커버할 칸 갯수
					switch (c) {
					case 'A': // 4방 1칸씩 커버
						cnt = 1;
						break;
					case 'B': // 4방 2칸씩 커버
						cnt = 2;
						break;
					case 'C': // 4방 3칸씩 커버
						cnt = 3;
						break;
					}// switch

					// 칸수별로 커버하기
					for (int m = 1; m <= cnt; m++) {// 4방 커버 횟수
						for (int k = 0; k < 4; k++) {
							int nx = i + m * dx[k]; // 0 + 2 * (-1)= -2
							int ny = j + m * dy[k];

							if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 'H') {// 배열 안쪽이면
								map[nx][ny] = 'Q';
							}
						}
					}
				} // for
			} // for

			// 3.남은 집 갯수 세기('H'의 갯수 세기)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H')
						answer++;
				}
			}
			// 4.결과출력
			System.out.println("#" + tc + " " + answer);
		}
	}

	// 입력용 데이터 저장 변수
	static String src = "10\r\n" + "5\r\n" + "XXXXX\r\n" + "XHXXX\r\n" + "HXAHX\r\n" + "XHHXX\r\n" + "XBHHX\r\n"
			+ "9\r\n" + "XXXXXXXXX\r\n" + "XXXHXXXXX\r\n" + "XXHAHXXHX\r\n" + "XXHHXXXXX\r\n" + "XXXXXXXXX\r\n"
			+ "XXAHHXXXX\r\n" + "XXHXXHAHX\r\n" + "XXAHXXHXX\r\n" + "XXHXHXXXX\r\n" + "9\r\n" + "XXXXXXXXX\r\n"
			+ "XXHHHXXXX\r\n" + "XXHAHXHXX\r\n" + "XXHHHXHXX\r\n" + "XXXHXXXXX\r\n" + "XXXBXXXXX\r\n" + "XXXXXXCHH\r\n"
			+ "XXXXXXXXX\r\n" + "XXXHXXHXX\r\n" + "10\r\n" + "XXXXXXXXXX\r\n" + "XXXHXXXXXX\r\n" + "XHXAHXXXXX\r\n"
			+ "XXXHXXHXXX\r\n" + "XXXHXXHXXX\r\n" + "XXBXXXHXXX\r\n" + "HXHHHHCHHH\r\n" + "XXHXXXHXXX\r\n"
			+ "XXXXXXHXXX\r\n" + "XXHXXXHXXX\r\n" + "10\r\n" + "XXXXXXXXXX\r\n" + "XXXXHXXXXX\r\n" + "XXHAHAXXXX\r\n"
			+ "XXXAHAXXXX\r\n" + "XXHBHHAXXX\r\n" + "XXHBACHXXX\r\n" + "BXXHBCXXXX\r\n" + "HAHCHHAXXX\r\n"
			+ "XXXXXHXXXX\r\n" + "XXXXXXXXXX\r\n" + "9\r\n" + "XXXXHXXXX\r\n" + "XXXXXXXXX\r\n" + "XHXXHXXXX\r\n"
			+ "XXXXXXXXX\r\n" + "XHXXHXXXX\r\n" + "XXXXHHXXH\r\n" + "XXXXXHXXX\r\n" + "XHXXXHXXX\r\n" + "XXXXXXXXX\r\n"
			+ "9\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n"
			+ "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "HHHHHHHHH\r\n" + "10\r\n" + "XAXXXCXXXX\r\n"
			+ "XBXCXAXXXX\r\n" + "XXXBACXXXX\r\n" + "XXXBBABXXX\r\n" + "XXXACXXXXX\r\n" + "XXXXXXAXXX\r\n"
			+ "XCXXXXBXXX\r\n" + "XXAXCXCXXX\r\n" + "XXXXXXXXXX\r\n" + "XXXXXXXXXX\r\n" + "10\r\n" + "ABABCABCAC\r\n"
			+ "BACABACBAC\r\n" + "ABCABCABAC\r\n" + "BACBAABCAB\r\n" + "ABBAABCABC\r\n" + "ABCBABCBAA\r\n"
			+ "ABBBAABCCA\r\n" + "ABBCCABCAB\r\n" + "ABBCAACBBC\r\n" + "ABBCCAACBA\r\n" + "10\r\n" + "HHHHHHHHHH\r\n"
			+ "ABCBABAABA\r\n" + "HHHHHHHHHH\r\n" + "ABCBABCCAB\r\n" + "HHHHHHHHHH\r\n" + "AABCAABBCA\r\n"
			+ "HHHHHHHHHH\r\n" + "BCABBCBCAC\r\n" + "HHHHHHHHHH\r\n" + "CABBCAACCB";
}
