package sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityqueueTest {

	public static void main(String[] args) {
		 PriorityQueue<Student> pQueue = new PriorityQueue<Student>(Comparator.reverseOrder());
		 
		 pQueue.offer(new Student("이동욱", 16));
		 pQueue.offer(new Student("김재환", 27));
		 pQueue.offer(new Student("박보검", 30));
		 
		 System.out.println(pQueue.poll());
		 System.out.println(pQueue.poll());
		 System.out.println(pQueue.poll());

	}

}
