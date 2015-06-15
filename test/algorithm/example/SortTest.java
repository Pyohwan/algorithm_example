package algorithm.example;

import java.util.Arrays;

import org.junit.Test;

public class SortTest {

	@Test
	public void sortInts() {
		final int[] numbers = {-3, -5, 1, 7, 4, -2};
		final int[] expected = {-5, -3, -2, 1, 4, 7};
		
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}
}
