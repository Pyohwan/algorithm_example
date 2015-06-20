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
	
	@Test
	public void sortTest() {
		final int[] numbers = {2, 9, 4, 6, 1, 8};
		final List<Integer> nums1 = Arrays.asList(2, 9, 4, 6, 1, 8);
		
		System.out.println("insert sort result=" + insertSort(nums1));
		System.out.println("quick sort result=" + quicksort(nums1));
		
		List<Integer> mergeList = mergesort(nums1);
		System.out.println("merge sort result=" + mergeList);
		
		System.out.println("search 1 = " + binarySearch(mergeList, 8));
		System.out.println("search 2 = " + binarySearch(mergeList, 5));
	}
	
	/**
	 * bubble sort; 
	 * @param numbers
	 */
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
	
	/**
	 * insert sort
	 * @param numbers
	 * @return
	 */
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
	
	/**
	 * quick sort
	 * @param numbers
	 * @return
	 */
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
	
	/**
	 * 분할 정복(병합 정렬 merge sort) divide and conquer
	 * @param values
	 * @return
	 */
	public static List<Integer> mergesort(final List<Integer> values) {
		if (values.size() < 2) {
			return values;
		}
		
		final List<Integer> leftHalf = values.subList(0, values.size() / 2);
		final List<Integer> rightHalf = values.subList(values.size() / 2, values.size());
		
		return merge(mergesort(leftHalf), mergesort(rightHalf));
	}
	
	private static List<Integer> merge(final List<Integer> left, final List<Integer> right) {
		int leftPtr = 0;
		int rightPtr = 0;
		
		final List<Integer> merged = new ArrayList<Integer>(left.size() + right.size());
		
		while (leftPtr < left.size() && rightPtr < right.size()) {
			if (left.get(leftPtr) < right.get(rightPtr)) {
				merged.add(left.get(leftPtr));
				leftPtr++;
			} else {
				merged.add(right.get(rightPtr));
				rightPtr++;
			}
		}
		
		while (leftPtr < left.size()) {
			merged.add(left.get(leftPtr));
			leftPtr++;
		}
		
		while (rightPtr < right.size()) {
			merged.add(right.get(rightPtr));
			rightPtr++;
		}
		
		return merged;
	}
	
	/**
	 * 이진 검색. 배열이 정렬되어 있어야 한다.
	 */
	public static boolean binarySearch(final List<Integer> numbers, final Integer value) {
		if (numbers == null || numbers.isEmpty()) {
			return false;
		}
		
		final Integer comparison = numbers.get(numbers.size() / 2);
		if (value.equals(comparison)) {
			return true;
		}
		
		if (value < comparison) {
			return binarySearch(numbers.subList(0, numbers.size() / 2), value);
		} else {
			return binarySearch(numbers.subList(numbers.size() / 2 + 1, numbers.size()), value);
		}
	}

}
 