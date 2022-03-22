package samsung;

import java.util.LinkedList;
import java.util.Queue;

public class _0208_QueueMyChew {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int N = 20;
		int person = 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { person, 1 });

		while (N > 0) {
			int[] p = queue.poll();
			int availableCount = (N >= p[1]) ? p[1] : N;
			N -= availableCount;
			
			if(N==0) {
				System.out.println("마지막에 MyChew를 가져간 사람: "+ p[0]+", 가져간 MyChew 개수: " +availableCount);
			} else {
				System.out.println("MyChew를 가져간 사람: "+ p[0]+", 가져간 MyChew 개수: " +availableCount);
			}
			
			// 받은 사람 넣기
			p[1]++;
			queue.offer(p);
			// 새로운 사람 넣기
			queue.offer(new int[] {++person, 1});
		}
	}
	
}
