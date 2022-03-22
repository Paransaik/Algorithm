package treeSearch;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes;
	private final int SIZE;
	private int lastIndex;

	public CompleteBinaryTree(int size) {
		nodes = new char[size + 1]; // 1 인덱스부터 사용하므로 +1 크기로 잡기
		SIZE = size;
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}

	public boolean isFull() {
		return lastIndex == SIZE;
	}

	public void add(char e) {
		if (isFull())
			return;

		nodes[++lastIndex] = e;
	}

	public void bfs() {

		if (isEmpty())
			return;

		// 이진트리 탐색 순서 관리
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(1);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(nodes[current] + " ");

			// 현재 노드의 자식들이 인덱스를 다음 순서가 되었을 때 탐색 되도록 큐에 넣어준다.
			// 왼쪽 자식 노드
			if (current * 2 <= lastIndex)
				queue.offer(current * 2);
			// 오른쪽 자식 노드
			if (current * 2 + 1 <= lastIndex)
				queue.offer(current * 2 + 1);
		}
		System.out.println();
	}

	public void bfs2() {
		if (isEmpty())
			return;

		// 이진트리 탐색 순서 관리
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(1);
		int level = 0;
		while (!queue.isEmpty()) {

			System.out.print("level " + level + ": ");
			// 같은 너비의 노드들 모두 탐색, 같은 행에 출력
			int size = queue.size();
			while (--size >= 0) {

				int current = queue.poll();
				System.out.print(nodes[current] + "\t");

				// 현재 노드의 자식들이 인덱스를 다음 순서가 되었을 때 탐색 되도록 큐에 넣어준다.
				// 왼쪽 자식 노드
				if (current * 2 <= lastIndex)
					queue.offer(current * 2);
				// 오른쪽 자식 노드
				if (current * 2 + 1 <= lastIndex)
					queue.offer(current * 2 + 1);
			}
			System.out.println();
			++level;
		}
	}
	
	public void dfsByPreOrder() {
		System.out.println("dfsByPreOrder");
		dfsByPreOrder(1);
		System.out.println();
		System.out.println("dfsByInOrder");
		dfsByInOrder(1);
		System.out.println();
		System.out.println("dfsByPostOrder");
		dfsByPostOrder(1);
		System.out.println();
	}
	
	private void dfsByPreOrder(int current) {

//		// 현재 노드 방문
//		System.out.print(nodes[current] + " ");
//		// 현재 노드의 자식 노드들 방문
//		if(current*2<=lastIndex) dfsByPreOrder(current*2);
//		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);

		if (current > lastIndex)
			return;
		// 현재 노드 방문
		System.out.print(nodes[current] + " ");
		// 현재 노드의 자식 노드들 방문
		dfsByPreOrder(current * 2);
		dfsByPreOrder(current * 2 + 1);
	}
	
	private void dfsByInOrder(int current) {
		if (current > lastIndex)
			return;
		// 현재 노드의 자식 노드들 방문
		dfsByInOrder(current * 2);
		// 현재 노드 방문
		System.out.print(nodes[current] + " ");
		dfsByInOrder(current * 2 + 1);
	}
	
	private void dfsByPostOrder(int current) {
		if (current > lastIndex)
			return;
		// 현재 노드의 자식 노드들 방문
		dfsByPostOrder(current * 2);
		dfsByPostOrder(current * 2 + 1);
		// 현재 노드 방문
		System.out.print(nodes[current] + " ");
	}
}