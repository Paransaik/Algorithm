package treeSearch;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		pQueue.offer(10);
		pQueue.offer(30);
		pQueue.offer(5);
		pQueue.offer(50);
		pQueue.offer(20);
		
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
	}

}
