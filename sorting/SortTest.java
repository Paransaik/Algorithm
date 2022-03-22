package sorting;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		
		int[] values = {3, 6, 1, 10, 5, 6};
		String[] names = {"양다은", "민하은", "이광우", "김태윤"};
		Student[] students = { new Student("정태영", 26), new Student("샛별", 12), new Student("싸피맨", 39)};

		System.out.println("=====정렬전=====");
		System.out.println(Arrays.toString(values));
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(students));
		
		Arrays.sort(values); // F3 원시 함수 확인
		Arrays.sort(names);
		Arrays.sort(students);
		
		System.out.println("=====정렬후=====");
		System.out.println(Arrays.toString(values));
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(students));
	}

}
