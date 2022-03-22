package stack;

/*
 * @author JeongTaeyeong
 */
public class StackAPITest {

	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		stack.push("정태영1");
		System.out.println(stack);
		stack.push("정태영2");
		System.out.println(stack);
		stack.push("정태영3");
		System.out.println(stack);
		stack.push("정태영4");
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
