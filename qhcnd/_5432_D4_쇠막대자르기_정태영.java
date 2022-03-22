package qhcnd;

import java.util.Scanner;

public class _5432_D4_쇠막대자르기_정태영 {
	static String src = "\r\n" + "2\r\n" + "()(((()())(())()))(())\r\n" + "(((()(()()))(())()))(()())";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src); // src에서 값을 입력 받음

		int T = sc.nextInt(); // test case 개수
		for (int i = 0; i < T; i++) {
			int total = 0; // 답, 레이저로 잘려진 막대기 개수
			int pole = 0; // 막대기 개수
			char front = 'x'; // 현재 읽은 값 앞쪽의 글자
			char current = 'y'; // 현재 읽은 값
			
			String s = sc.next();
			char[] ch = s.toCharArray();

			for (int j = 0; j < ch.length; j++) {
				current = ch[j];
				if (current == '(') {
					pole++;
				} else { // ')' 바로 앞의 글자를 확인해야 됨
					if(front == '(') {
						pole--; // 막대기 수 줄이기
						total += pole; // 막대기 수만큼 조각이 생겨남
					} else { // ')', 막대기 끝
						pole--; // 끝나서 막대기 감소
						total++; // 끝나면서 한 조각 나오는 거 추가
					}
				}
				// 지금 읽었던 글자(current)는 front로 바뀜
				front = current;
			}
			System.out.println("#" + (i + 1) + " " + total);
		}
	}
}
