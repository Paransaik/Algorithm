package stack;

public class Stack {
	private Node top;

	public void push(String data) {
		top = new Node(data, top); // 첫 번째 노드 추가
	}

	public String pop() {
		if (isEmpty())
			return null;

		Node popNode = top; // 첫 번째 노드 삭제
		top = popNode.link;

		return popNode.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public String toString() {
		// top부터 마지막 노드까지 쭉 돌며 data를 문자열로 합치기
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Node currNode = top; currNode != null; currNode = currNode.link) {
			sb.append(currNode.data).append(",");
		}
		sb.append("]");
		return sb.toString();
	}
}
