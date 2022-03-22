package greed;

import java.util.*;

public class MeetingRoomGreedyTest {

	static class Meeting implements Comparable<Meeting> {
		int start, end;
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		Meeting[] meetings = new Meeting[count];
		for (int i = 0; i < count; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		List<Meeting> result = getSchedule(meetings);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		
		for (Meeting meeting:result) {
			sb.append(meeting.start).append(" ").append(meeting.end).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static List<Meeting> getSchedule(Meeting[] meetings){
		// 회의 목록을 종료시간 기준으로 오름차순
		// 종료시간이 같다면 시작시간 기준으로 오름차순 정렬
		ArrayList<Meeting> result = new ArrayList<Meeting>();
		
		Arrays.sort(meetings); // 종료
		result.add(meetings[0]); // 첫 회의 추가(종료시간이 가장 빠른 회의)

		for (int i = 0, size = meetings.length; i < size; i++) {
//			 직전회의의 종료시간과 현재회의의 시작시간 비교
//			if(result.get(index))
			if(result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		return result;
	}
}
