package algorithm.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.Highlighter.Highlight;

import org.junit.Test;

public class SortTest {

	@Test
	public void sortInts() {
		final int[] numbers = {-3, -5, 1, 7, 4, -2};
		final int[] expected = {-5, -3, -2, 1, 4, 7};
		
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}
	
	@Test
	public void sortObjects() {
		final String[] strings = {"z", "x", "y", "abc", "zzz", "zazzy"};
		final String[] expected = {"abc", "x", "y", "z", "zazzy", "zzz"};
		
		Arrays.sort(strings);
		assertArrayEquals(expected, strings);
	}
	
	public class ReverseNumericalOrder implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
	}
	
	@Test
	public void customSorting() {
		final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		final List<Integer> expected = Arrays.asList(7, 6, 5, 4, 4, 3, 1);
		
		Collections.sort(numbers, new ReverseNumericalOrder());
		assertEquals(expected, numbers);
	}
	
	public void bubbleSort(int[] numbers) {
		boolean numbersSwitched;
		
		do {
			numbersSwitched = false;
			for (int i = 0 ; i < numbers.length - 1 ; i++) {
				if (numbers[i + 1] < numbers[i]) {
					int tmp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = tmp;
					numbersSwitched = true;
				}
			}
		} while(numbersSwitched);
	}
	
	public static List<Integer> insertSort(final List<Integer> numbers) {
		final List<Integer> sortedList = new LinkedList<Integer>();
		
		originalList: for (Integer number : numbers) {
			for (int i = 0 ; i < sortedList.size() ; i++) {
				if (number < sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		
		return sortedList;
	}
	
	public static List<Integer> quicksort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers;
		}
		
		final Integer pivot = numbers.get(0);
		final List<Integer> lower = new ArrayList<Integer>();
		final List<Integer> higher = new ArrayList<Integer>();
		
		for (int i = 1 ; i < numbers.size() ; i++) {
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}
		
		final List<Integer> sorted = quicksort(lower);
		sorted.add(pivot);
		sorted.addAll(quicksort(higher));
		
		return sorted;
	}

}
