package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class StudentSortTest {

	public static void main(String[] args) {
		Student[] students = { new Student("정태영", 26), new Student("샛별", 12), new Student("싸피맨", 39) };

		System.out.println("=====이름 기준 오름차순=====");
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));

		System.out.println("=====나이 기준 오름차순=====");
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.age - o2.age;
			}
		});
		System.out.println(Arrays.toString(students));

		System.out.println("=====이름 기준 내림차순=====");
//		Arrays.sort(students, (o1, o2) -> o2.name.compareTo(o1.name));
		Arrays.sort(students, Comparator.reverseOrder());
		System.out.println(Arrays.toString(students));

		System.out.println("=====나이 오름, 이름 내림=====");
		Arrays.sort(students, (o1, o2) -> (o1.age != o2.age) ? o1.age - o2.age : o2.name.compareTo(o1.name));
		System.out.println(Arrays.toString(students));
	}

}
