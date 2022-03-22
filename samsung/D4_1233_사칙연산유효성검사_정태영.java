package samsung;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class D4_1233_사칙연산유효성검사_정태영 {
	static int TC, scene, oper, flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = 10;
		for (int tc = 1; tc <= TC; tc++) {
			flag = 1;
			scene = Integer.parseInt(sc.nextLine());
			oper = scene / 2;
			for (int i = 0; i < oper; i++) {
				byte[] a = sc.nextLine().split(" ")[1].getBytes(StandardCharsets.US_ASCII);
				if (a[0] < 42 || 47 < a[0]) flag = 0; 
            }
			for (int i = oper; i < scene; i++) {
				byte[] a = sc.nextLine().split(" ")[1].getBytes(StandardCharsets.US_ASCII);
				if (a[0] < 48 || 57 < a[0]) flag = 0; 
			}
			System.out.println("#" + tc + " " + flag);
		}
	}
}