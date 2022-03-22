package sorting;

import java.util.Arrays;

public class TwoArraySortTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int arr[][] = { { 1, 100 }, { 5, 80 }, { 3, 90 } };

//		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		// =
		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}
}
