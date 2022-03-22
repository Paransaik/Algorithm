package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1218_괄호짝짓기_정태영 {
	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception, IOException {
		for (int scenario = 1; scenario < 11; scenario++) {
			Stack<String> stack = new Stack<String>();
			int flag = 1;
			int dummy = Integer.parseInt(br.readLine());
			String[] bracket = br.readLine().split("");
	
			for (String s : bracket) {
				switch (s) {
				case "(": case "{": case "[": case "<": stack.push(s); break;
				case ")": if (stack.empty() || !stack.pop().contentEquals("(")) flag = 0; break;
				case "]": if (stack.empty() || !stack.pop().contentEquals("[")) flag = 0; break;
				case "}": if (stack.empty() || !stack.pop().contentEquals("{")) flag = 0; break;
				case ">": if (stack.empty() || !stack.pop().contentEquals("<")) flag = 0; break;
				}
			}
			if (!stack.empty()) flag = 0;
			sb.append("#" + scenario + " " + flag + "\n");
		}
		System.out.println(sb.toString());
	}
}
